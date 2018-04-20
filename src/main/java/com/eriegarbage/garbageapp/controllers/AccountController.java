package com.eriegarbage.garbageapp.controllers;

import com.eriegarbage.garbageapp.dto.AccountDto;
import com.eriegarbage.garbageapp.dto.AccountEditDto;
import com.eriegarbage.garbageapp.managers.AccountManager;
import com.eriegarbage.garbageapp.models.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class AccountController {

    @Autowired
    AccountManager accountManager;

    @RequestMapping(value = "/")
    public ModelAndView getCustomerMainPage() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth.getAuthorities().contains(new SimpleGrantedAuthority("ADMIN"))) {
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
        ModelAndView mv = new ModelAndView("AccountPageEdit");
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

    @RequestMapping(value = "/cancelAccount", method = RequestMethod.GET)
    public String cancelAccount() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        accountManager.cancelAccount(accountManager.getAccount(auth.getName()));
        auth.setAuthenticated(false);
        return "redirect:/";
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
}
