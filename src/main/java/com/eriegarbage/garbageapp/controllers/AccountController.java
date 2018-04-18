package com.eriegarbage.garbageapp.controllers;

import com.eriegarbage.garbageapp.dto.AccountDto;
import com.eriegarbage.garbageapp.managers.AccountManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
            System.out.println("This is a user");
        }

        ModelAndView mv = new ModelAndView("CustomerMainPage");
        mv.addObject("pickupTime", accountManager.getAccount(auth.getName()).getPickupTime());
        return mv;
    }

    @RequestMapping(value = "/viewAccountPage")
    public ModelAndView getAccountPage() {
        ModelAndView mv = new ModelAndView("AccountPage");
        mv.addObject("accountInfo", "info");
        return mv;
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
