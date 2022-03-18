package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = {"salesman"})
public class SalesManController {

    @RequestMapping(value = {"home"}, method = RequestMethod.GET)
    public String index(){
        return "salesman/index";
    }

    @RequestMapping(value = {"addproduct"}, method = RequestMethod.GET)
    public String addProduct(){
        return "salesman/addproduct";
    }
}
