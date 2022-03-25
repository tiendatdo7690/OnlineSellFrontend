package com.example.demo.controllers;

import com.example.demo.apis.*;
import com.example.demo.entities.*;
import com.example.demo.entities.Process;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.*;
import retrofit2.Response;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = {"","client"})
public class ClientControllers {

    private CategoryAPI categoryAPI = APIConfiguration.getClient().create(CategoryAPI.class);

    private ProductAPI productAPI = APIConfiguration.getClient().create(ProductAPI.class);

    private CustomerAPI customerAPI = APIConfiguration.getClient().create(CustomerAPI.class);

    private AddressAPI addressAPI = APIConfiguration.getClient().create(AddressAPI.class);

    private OrderProductAPI orderProductAPI = APIConfiguration.getClient().create(OrderProductAPI.class);

    private ProcessAPI processAPI = APIConfiguration.getClient().create(ProcessAPI.class);

    @RequestMapping(value = {"","home"}, method = RequestMethod.GET)
    public String index(HttpServletRequest request, ModelMap modelMap, HttpSession session,
                        @RequestParam(value = "category", required = false) String category,
                        @RequestParam(value = "logout",required = false) String logout,
                        @RequestParam(value = "keySearch",required = false) String keySearch) throws IOException {
        if(session.getAttribute("countCart") == null){
            int count = 0;
            session.setAttribute("countCart",count);
        }

        if(session.getAttribute("cart") == null){
            List<ProductCart> productCarts = new ArrayList<ProductCart>();
            session.setAttribute("cart", productCarts);
        }

        List<ProductRespone> products = new ArrayList<ProductRespone>();
        Response<List<ProductRespone>> productResponse = null;
        Response<List<Category>> categoryResponse = null;

        if(category != null) {
            productResponse = productAPI.findAllByCategory(category).execute();
            products = productResponse.body();
            modelMap.put("category",category);

        }
        else if(keySearch != null) {
            productResponse = productAPI.findAllByName(keySearch).execute();
            products = productResponse.body();
            modelMap.put("category", "Result with key");
        }
        else {
            productResponse = productAPI.findAll().execute();
            products = productResponse.body();
            modelMap.put("category","All Product");
        }




        categoryResponse = categoryAPI.findAll().execute();
        List<Category> categories = categoryResponse.body();
        System.out.println(categories);
        modelMap.put("categories", categories);



        if(products != null) {
            PagedListHolder pagedListHolder = new PagedListHolder(products);
            int page = ServletRequestUtils.getIntParameter(request, "p", 0);
            pagedListHolder.setPage(page);
            pagedListHolder.setPageSize(8);
            modelMap.put("pagedListHolder", pagedListHolder);
        }


        return "client/index";
    }

    @RequestMapping(value = {"product/{id}"}, method = RequestMethod.GET)
    public String Product(@PathVariable Long id, ModelMap modelMap){

        Response<ProductRespone> productResponse = null;
        try {
            productResponse = productAPI.findProductById(id).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ProductRespone productRespone1 = productResponse.body();

        modelMap.put("product",productRespone1);

        ProductCart productCart = new ProductCart();
        productCart.setId(productRespone1.getId());
        productCart.setName(productRespone1.getName());
        productCart.setPrice(productRespone1.getPrice());

        modelMap.put("productCart", productCart);

        return "client/product";
    }

    @RequestMapping(value = {"addcart"}, method = RequestMethod.POST)
    public String addCart(@ModelAttribute("productCart") ProductCart productCart,HttpSession session){

        int countCart = ( Integer) session.getAttribute("countCart");
        session.setAttribute("countCart",countCart+1);
        ((ArrayList<ProductCart>)session.getAttribute("cart")).add(productCart);



        return "redirect:/client/product/" + productCart.getId().toString();
    }

    @RequestMapping(value = {"cart"}, method = RequestMethod.GET)
    public String cart( Authentication authentication, ModelMap model){

        Response<List<Address>> addressResponse = null;
        Response<Long> customerResponse = null;
        List<Address> addresses = null;
        Long idCustomer = null;

        try {
            customerResponse = customerAPI.getIdByUser(authentication.getName()).execute();
            idCustomer = customerResponse.body();

            addressResponse = addressAPI.findByUserName(idCustomer).execute();

            addresses = addressResponse.body();
        } catch (IOException e) {
            e.printStackTrace();
        }

        model.put("addresses",addresses);
        InfoOrder infoOrder = new InfoOrder();
        infoOrder.setIdCustomer(idCustomer);
        model.put("infoOrder",infoOrder);

        return "client/cart";
    }

    @RequestMapping(value = {"order"}, method = RequestMethod.POST)
    public String order(@ModelAttribute("infoOrder") InfoOrder infoOrder, HttpSession session){


        infoOrder.setDate(new Date());
        System.out.println(infoOrder);

        List<OrderProduct> orderProducts = new ArrayList<OrderProduct>();
        ArrayList<ProductCart> productCarts = ((ArrayList<ProductCart>)session.getAttribute("cart"));
        for (ProductCart productCart : productCarts){
            OrderProduct orderProduct = new OrderProduct();
            orderProduct.setDate(infoOrder.getDate());
            orderProduct.setIdAddress(infoOrder.getIdAddress());
            orderProduct.setIdCustomer(infoOrder.getIdCustomer());
            orderProduct.setQuantity(productCart.getQuantity());
            orderProduct.setIdProduct(productCart.getId());
            orderProducts.add(orderProduct);
        }

        Response<Void> orderProductResponse = null;

        try {
            orderProductResponse = orderProductAPI.saveAll(orderProducts).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        orderProductResponse.body();

        return "redirect:/client/listorder";
    }

    @RequestMapping(value = {"listorder"}, method = RequestMethod.GET)
    public String listOrder(@ModelAttribute("infoOrder") InfoOrder infoOrder,@RequestParam(required = false,value = "isDelete") Boolean isDelete,
                        HttpServletRequest request, ModelMap model, Authentication authentication){

        if(isDelete !=null){
            model.put("isDelete",isDelete);
        }

        Response<List<OrderProductShow>> findOrderProductResponse = null;
        Response<Long> customerResponse = null;
        try {
            customerResponse = customerAPI.getIdByUser(authentication.getName()).execute();
            findOrderProductResponse = orderProductAPI.findAllByCustomer(customerResponse.body()).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<OrderProductShow> orderProductList = findOrderProductResponse.body();

        System.out.println(orderProductList);

        PagedListHolder pagedListHolder = new PagedListHolder(orderProductList);
        int page = ServletRequestUtils.getIntParameter(request, "p", 0);
        pagedListHolder.setPage(page);
        pagedListHolder.setPageSize(10);
        model.put("pagedListHolder", pagedListHolder);


        return "client/order";
    }

    @RequestMapping(value = {"deleteproductcart/{id}"}, method = RequestMethod.GET)
    public String deleteProductCart(@PathVariable Long id, HttpSession session){

        ArrayList<ProductCart> productCarts = ((ArrayList<ProductCart>)session.getAttribute("cart"));
        for (ProductCart productCart : productCarts){
            if(productCart.getId() == id){
                productCarts.remove(productCart);
                break;
            }
        }
        int count = (Integer) session.getAttribute("countCart");
        session.setAttribute("countCart",count-1);
        session.setAttribute("cart",productCarts);



        return "redirect:/client/cart";
    }

    @RequestMapping(value = {"deliveryprocess/{id}"}, method = RequestMethod.GET)
    public String deliveryProcess(@PathVariable Long id, ModelMap modelMap){


        Response<List<Process>> processResponse = null;
        try {
            processResponse = processAPI.findAllByOrder(id).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Process> processes = processResponse.body();

        modelMap.put("processes",processes);

        return "client/listprocess";
    }

    @RequestMapping(value = {"deleteorder/{id}"}, method = RequestMethod.GET)
    public String deleteOrder(@PathVariable Long id, ModelMap modelMap){

        Response<Boolean> orderResponse = null;
        try {
            orderResponse = orderProductAPI.deleteOrder(id).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Boolean isDelete = orderResponse.body();


        return "redirect:/client/listorder?isDelete=" + isDelete;
    }

    @RequestMapping(value = {"home/search"}, method = RequestMethod.POST)
    public String search(@RequestParam("keySearch") String keySearch){

        System.out.println("key search: " + keySearch);


        return "redirect:/home?keySearch="+keySearch;
    }
}
