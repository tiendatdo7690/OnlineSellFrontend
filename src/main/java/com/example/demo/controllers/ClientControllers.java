package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = {"","client"})
public class ClientControllers {

    @RequestMapping(value = {"","home"}, method = RequestMethod.GET)
    public String index(){
        return "client/index";
    }
}
