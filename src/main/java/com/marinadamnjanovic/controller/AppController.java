package com.marinadamnjanovic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class AppController {

    @Autowired
    MessageSource messageSource;

    @RequestMapping("/")
    public String backHome(){
        return "index";
    }


}
