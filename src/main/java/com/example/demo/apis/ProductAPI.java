package com.example.demo.apis;

import com.example.demo.entities.Category;
import com.example.demo.entities.Product;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ProductAPI {

    @POST("product/saveproduct")
    Call<Boolean> savProduct(@Body Product product);
}
