package com.example.demo.controllers;

import com.example.demo.apis.APIConfiguration;
import com.example.demo.apis.CategoryAPI;
import com.example.demo.apis.ProductAPI;
import com.example.demo.entities.Category;
import com.example.demo.entities.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping(value = {"salesman"})
public class SalesManController {

    private ProductAPI productAPI = APIConfiguration.getClient().create(ProductAPI.class);
    private CategoryAPI categoryAPI = APIConfiguration.getClient().create(CategoryAPI.class);


    @RequestMapping(value = {"home"}, method = RequestMethod.GET)
    public String index(){
        return "salesman/index";
    }

    @RequestMapping(value = {"addproduct"}, method = RequestMethod.GET)
    public String addProduct(ModelMap modelMap){
        Product product = new Product();
        modelMap.put("product",product);

        Response<List<Category>> responseCategoryAPI = null;
        try {
            responseCategoryAPI = categoryAPI.findAll().execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Category> categories = responseCategoryAPI.body();
        modelMap.put("categories",categories);

        return "salesman/addproduct";
    }

    @RequestMapping(value = {"saveproduct"}, method = RequestMethod.POST)
    public String saveCategory(@ModelAttribute("product") Product product){
        System.out.println(product);
        Response<Boolean> responseProductAPI = null;
        try {
            responseProductAPI = productAPI.savProduct(product).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Save: " + responseProductAPI.body());
        return "redirect:/salesman/addproduct";
    }
}
