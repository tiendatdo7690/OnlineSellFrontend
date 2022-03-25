package com.example.demo.apis;

import com.example.demo.entities.OrderProduct;
import com.example.demo.entities.OrderProductShow;
import com.example.demo.entities.Product;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface OrderProductAPI {

    @POST("orderproduct/saveallorderproduct")
    Call<Void> saveAll(@Body List<OrderProduct> orderProducts);

    @GET("orderproduct/findallbycustomer/{idCustomer}")
    Call<List<OrderProductShow>> findAllByCustomer(@Path("idCustomer") Long idCustomer);

    @DELETE("orderproduct/deleteorder/{idOrder}")
    Call<Boolean> deleteOrder(@Path("idOrder") Long idOrder);
}
