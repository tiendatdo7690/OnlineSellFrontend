package com.example.demo.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = {"account"})
public class AccountController {

    @RequestMapping(value = {"welcome"}, method = RequestMethod.GET)
    public String index(Authentication authentication){

        if(authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_SALE_MAN"))){
            return "redirect:/salesman/home";
        }
        else if(authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"))){
            return "redirect:/admin/home";
        }
        else if(authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_CLIENT"))){
            return "redirect:/client/home";
        }
        return "account/index";
    }
}
