package com.eriegarbage.garbageapp.controllers;

import com.eriegarbage.garbageapp.dto.AccountDto;
import com.eriegarbage.garbageapp.dto.AccountEditDto;
import com.eriegarbage.garbageapp.managers.AccountManager;
import com.eriegarbage.garbageapp.models.Account;
import java.util.ArrayList;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AccountController {

    @Autowired
    AccountManager accountManager;

    @RequestMapping(value = "/")
    public ModelAndView getCustomerMainPage() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth.getAuthorities().contains(new SimpleGrantedAuthority("ADMIN"))) {
            return new ModelAndView("redirect:/admin");
        }

        ModelAndView mv = new ModelAndView("CustomerMainPage");
        mv.addObject("pickupTime", accountManager.getAccount(auth.getName()).getPickupTime());
        return mv;
    }

    @RequestMapping(value = "/admin")
    public ModelAndView getAdminMainPage() {
        ModelAndView mv = new ModelAndView("AdminMainPage");
        return mv;
    }

    @RequestMapping(value = "/newAdmin", method = RequestMethod.GET)
    public ModelAndView getNewAdminPage() {
        AccountDto accountDto = new AccountDto();
        ModelAndView mv = new ModelAndView("NewAdminPage");
        mv.addObject("account", accountDto);
        return mv;
    }

    @RequestMapping(value = "/newAdmin", method = RequestMethod.POST)
    public String registerUserAdminAccount(@ModelAttribute("account")
                                               @Valid AccountDto accountDto) {
        accountManager.registerNewAdmin(accountDto);
        System.out.println("i am here");
        return "redirect:/";
    }

    @RequestMapping(value = "/viewAccountPage")
    public ModelAndView getAccountPage() {
        ModelAndView mv = new ModelAndView("AccountPage");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        mv.addObject("userName", auth.getName());
        mv.addObject("accountInfo", accountManager.getAccount(auth.getName()));
        return mv;
    }

    @RequestMapping(value = "/viewAccountPageEdit")
    public ModelAndView getAccountPageEdit() {
        ModelAndView mv = new ModelAndView("AccountEditPage");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        mv.addObject("userName", auth.getName());
        mv.addObject("accountInfo", accountManager.getAccount(auth.getName()));
        return mv;
    }

    @RequestMapping(value = "/submitAccountEdit", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void submitAccountEdit(@RequestBody AccountEditDto accountInfo) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        accountManager.accountEditInfo(accountInfo, accountManager.getAccount(auth.getName()));
    }

    @RequestMapping(value = "/SuspendAccount", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void SuspendAccount(@RequestBody String username) {
        accountManager.updateAnAccountAsSuspended(username.substring(1,username.length()-1));
    }

    @RequestMapping(value = "/cancelAccount", method = RequestMethod.GET)
    public String cancelAccount() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        accountManager.cancelAccount(accountManager.getAccount(auth.getName()));
        auth.setAuthenticated(false);
        return "redirect:/";
    }

    @RequestMapping(value = "/getSuspendableAccounts", method = RequestMethod.GET)
    public ModelAndView getSuspendableAccounts() {
        ModelAndView mv = new ModelAndView("ManageSuspendAccountPage");
        ArrayList<String> usernames = new ArrayList<>();
        ArrayList<Account> as = accountManager.getSuspendableAccounts();
        for (Account a : as) {
            usernames.add(a.getUserName());
        }
        mv.addObject("usernames", usernames);
        return mv;
    }

    @RequestMapping(value = "/suspendAccountRequest", method = RequestMethod.GET)
    @ResponseBody
    public String suspendAccountRequest() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        accountManager.requestSuspend(accountManager.getAccount(auth.getName()));
        return "Pass";
    }

    @RequestMapping(value = "/login")
    public ModelAndView loginPage() {
        ModelAndView mv = new ModelAndView("Login");
        return mv;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView registrationPage() {
        AccountDto accountDto = new AccountDto();
        ModelAndView mv = new ModelAndView("Registration");
        mv.addObject("account", accountDto);
        return mv;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerUserAccount(@ModelAttribute("account") @Valid AccountDto accountDto) {
        accountManager.registerNewAccount(accountDto);
        return "redirect:/";
    }

    //an admin page
    @RequestMapping(value = "/overdueAccounts")
    public ModelAndView getOverdueAccounts() {
        ModelAndView mv = new ModelAndView("ManageOverdueBillsPage");
        mv.addObject("overdueAccounts", accountManager.getOverdueAccounts());
        return mv;
    }
}
