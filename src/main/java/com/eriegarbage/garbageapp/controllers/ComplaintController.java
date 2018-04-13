package com.eriegarbage.garbageapp.controllers;

import com.eriegarbage.garbageapp.managers.ComplaintManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ComplaintController {

    @Autowired
    ComplaintManager complaintManager;

    @RequestMapping(value = "/fileComplaintPage")
    public ModelAndView getAccountPage() {
        ModelAndView mv = new ModelAndView("ComplaintPage");
       // mv.addObject("accountInfo", "info");
        return mv;
    }
}
