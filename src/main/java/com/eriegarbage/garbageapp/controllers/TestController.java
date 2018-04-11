package com.eriegarbage.garbageapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

    @RequestMapping(value = "/")
    @ResponseBody
    public String getHome() {
        return "home";
    }

    @RequestMapping(value = "/stuff")
    public ModelAndView getStuff() {
        ModelAndView mv = new ModelAndView("Stuff");
        mv.addObject("data", "katie");
        return mv;
    }


}
