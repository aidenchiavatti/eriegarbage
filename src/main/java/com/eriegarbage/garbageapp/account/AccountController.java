package com.eriegarbage.garbageapp.account;

import com.eriegarbage.garbageapp.account.dto.AccountDto;
import com.eriegarbage.garbageapp.account.dto.AccountEditDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class AccountController {

    @Autowired
    AccountManager accountManager;

    @GetMapping("/")
    public String getCustomerMainPage(Model model, Authentication auth) {
        if (auth.getAuthorities().contains(new SimpleGrantedAuthority("ADMIN"))) {
            return "redirect:/admin";
        }

        if(accountManager.getAccount(auth.getName()).isSuspended()) {
            return "account/Suspended";
        }
        model.addAttribute(accountManager.getAccount(auth.getName()));
        return "CustomerMainPage";
    }

    @GetMapping("/admin")
    public String getAdminMainPage() {
        return "AdminMainPage";
    }

    @GetMapping("/admin/accounts/create.html")
    public String newAdminPage(Model model) {
        model.addAttribute("account", new AccountDto());
        return "/account/NewAdminPage";
    }

    @PostMapping("/admin/accounts/admins")
    public String registerAdminAccount(@ModelAttribute("account")
                                               @Valid AccountDto accountDto) {
        accountManager.registerNewAdmin(accountDto);
        return "redirect:/";
    }

    @GetMapping("/accounts/account.html")
    public String getAccountPage(Model model, Principal principal) {
        model.addAttribute("userName", principal.getName());
        model.addAttribute("accountInfo", accountManager.getAccount(principal.getName()));
        return "account/AccountPage";
    }

    @GetMapping("/accounts/edit.html")
    public String getAccountPageEdit(Model model, Principal principal) {
        model.addAttribute("userName", principal.getName());
        model.addAttribute("accountInfo", accountManager.getAccount(principal.getName()));
        return "account/AccountEditPage";
    }

    @PostMapping("/accounts/edit")
    @ResponseStatus(value = HttpStatus.OK)
    public void submitAccountEdit(Principal principal, @RequestBody AccountEditDto accountInfo) {
        accountManager.accountEditInfo(accountInfo, accountManager.getAccount(principal.getName()));
    }

    @PostMapping("/admin/accounts/{accountId}/suspend")
    @ResponseStatus(value = HttpStatus.OK)
    public void suspendAccount(@PathVariable("accountId") int accountId) {
        try {
            accountManager.suspend(accountId);
        } catch(Exception e) {
            //TODO: replace this too with custom exception
        }
    }

    @GetMapping("/accounts/cancel")
    public String cancelAccount(Authentication auth) {
        accountManager.cancelAccount(accountManager.getAccount(auth.getName()));
        auth.setAuthenticated(false);
        return "redirect:/";
    }

    @GetMapping("/admin/accounts/suspendable.html")
    public String getSuspendableAccounts(Model model) {
        model.addAttribute(accountManager.getSuspendableAccounts());
        return "account/ManageSuspendAccountPage";
    }

    @PostMapping("/accounts/suspend")
    @ResponseBody
    public String suspendAccountRequest(Principal principal) {
        accountManager.requestSuspend(accountManager.getAccount(principal.getName()));
        return "Pass";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "account/Login";
    }

    @GetMapping("/register.html")
    public String registrationPage(Model model) {
        model.addAttribute("account", new AccountDto());
        return "account/Registration";
    }

    @PostMapping("/register")
    public String registerUserAccount(@ModelAttribute("account") @Valid AccountDto accountDto,
                                      BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "account/Registration";
        }
        accountManager.registerNewAccount(accountDto);
        return "redirect:/";
    }

    @GetMapping("/accounts/overdue.html")
    public String getOverdueAccounts(Model model) {
        model.addAttribute("overdueAccounts", accountManager.getOverdueAccounts());
        return "accounts/ManageOverdueBillsPage";
    }
}
