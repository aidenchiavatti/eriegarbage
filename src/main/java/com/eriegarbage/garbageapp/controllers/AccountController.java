package com.eriegarbage.garbageapp.controllers;

import com.eriegarbage.garbageapp.managers.AccountManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AccountController {

    @Autowired
    AccountManager accountManager;

    @RequestMapping(value = "/")
    public ModelAndView getCustomerMainPage() {
        ModelAndView mv = new ModelAndView("CustomerMainPage");
        mv.addObject("pickupTime", accountManager.getPickupTime("username"));
        return mv;
    }

    @RequestMapping(value = "/viewAccountPage")
    public ModelAndView getAccountPage() {
        ModelAndView mv = new ModelAndView("AccountPage");
        mv.addObject("accountInfo", "info");
        return mv;
    }


}
