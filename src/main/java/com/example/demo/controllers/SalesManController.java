package com.example.demo.controllers;

import com.example.demo.apis.*;
import com.example.demo.entities.Category;
import com.example.demo.entities.File;
import com.example.demo.entities.Product;
import com.example.demo.entities.UserAccount;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;
import retrofit2.Response;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = {"salesman"})
public class SalesManController implements ServletContextAware {

    private ProductAPI productAPI = APIConfiguration.getClient().create(ProductAPI.class);
    private CategoryAPI categoryAPI = APIConfiguration.getClient().create(CategoryAPI.class);
   // private FileAPI fileAPI = APIConfiguration.getClient().create(FileAPI.class);
    private AccountAPI accountAPI = APIConfiguration.getClient().create(AccountAPI.class);


    private ServletContext servletContext;

    @RequestMapping(value = {"home"}, method = RequestMethod.GET)
    public String index(){
        return "salesman/index";
    }

    @RequestMapping(value = {"addproduct"}, method = RequestMethod.GET)
    public String addProduct(ModelMap modelMap, Authentication authentication){

        Response<UserAccount> responseAccountAPI = null;

        try {
            responseAccountAPI = accountAPI.findByUsername(authentication.getName()).execute();

        } catch (IOException e) {
            e.printStackTrace();
        }

        Product product = new Product();
        product.setIdSalesMan(responseAccountAPI.body().getId());
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
    public String saveProduct(@ModelAttribute("product") Product product, @RequestParam("avatar1") MultipartFile avatar,
                               @RequestParam("images1") MultipartFile[] images) throws IOException {
        List<File> files = new ArrayList<File>();
        for (MultipartFile file : images){
            files.add(new File(file.getBytes(), file.getOriginalFilename()));
        }
         File file = new File(avatar.getBytes(),avatar.getOriginalFilename());
        product.setAvatar(file);
        product.setImages(files);
        Response<Boolean> responseProductAPI = null;
//        Response<Void> responseFileAPI = null;
//        Response<Void> responseFilesAPI = null;
        try {
            responseProductAPI = productAPI.savProduct(product).execute();
//            responseFileAPI = fileAPI.uploadFile(new File(avatar.getBytes(),avatar.getOriginalFilename())).execute();
//            responseFilesAPI = fileAPI.uploadFiles(files).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(responseProductAPI.body()){

//            responseFileAPI.body();
//            responseFilesAPI.body();
            System.out.println("Upload File ---------------------");
        }
        return "redirect:/salesman/addproduct";
    }

    @Override
    public void setServletContext(ServletContext servletContext){
        this.servletContext = servletContext;
    }
}
