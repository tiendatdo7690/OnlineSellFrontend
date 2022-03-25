package com.example.demo.apis;

import com.example.demo.entities.Category;
import com.example.demo.entities.File;
import com.example.demo.entities.Product;
import com.example.demo.entities.ProductRespone;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import sun.plugin.util.PluginSysUtil;

import java.util.List;

public interface ProductAPI {

    @POST("product/saveproduct")
    Call<Boolean> savProduct(@Body Product product);

    @GET("product/findall")
    Call<List<ProductRespone>> findAll();

    @GET("product/getproduct/{id}")
    Call<ProductRespone> findProductById(@Path("id") Long id);

    @GET("product/findallbycategory/{namecategory}")
    Call<List<ProductRespone>> findAllByCategory(@Path("namecategory") String namecategory);

    @GET("product/findallbyname/{key}")
    Call<List<ProductRespone>> findAllByName(@Path("key") String keySearch);
}
