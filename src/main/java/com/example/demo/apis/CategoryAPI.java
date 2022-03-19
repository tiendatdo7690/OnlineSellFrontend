package com.example.demo.apis;

import com.example.demo.entities.Category;
import com.example.demo.entities.UserAccount;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

import java.util.List;

public interface CategoryAPI {

    @POST("category/savecategory")
    Call<Boolean> saveCategory(@Body Category category);

    @GET("category/findall")
    Call<List<Category>> findAll();
}
