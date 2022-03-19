package com.example.demo.controllers;


import com.example.demo.apis.APIConfiguration;
import com.example.demo.apis.AccountAPI;
import com.example.demo.apis.CategoryAPI;
import com.example.demo.entities.Category;
import com.example.demo.entities.UserAccount;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import retrofit2.Response;

import java.io.IOException;
import java.util.Locale;

@Controller
@RequestMapping(value = {"admin"})
public class AdminController {

    private CategoryAPI categoryAPI = APIConfiguration.getClient().create(CategoryAPI.class);

    @RequestMapping(value = {"home"}, method = RequestMethod.GET)
    public String index(){
        return "admin/index";
    }

    @RequestMapping(value = {"addcategory"}, method = RequestMethod.GET)
    public String addCategory(ModelMap modelMap){
        Category category = new Category();
        modelMap.put("category",category);
        return "admin/addcategory";
    }

    @RequestMapping(value = {"savecategory"}, method = RequestMethod.POST)
    public String saveCategory(@ModelAttribute("category") Category category){
        System.out.println(category);
        Response<Boolean> responseCategoryAPI = null;
        try {
            responseCategoryAPI = categoryAPI.saveCategory(category).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Save: " + responseCategoryAPI.body());
        return "redirect:/admin/addcategory";
    }
}
