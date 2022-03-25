package com.example.demo.apis;

import com.example.demo.entities.UserAccount;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CustomerAPI {

    @GET("customer/getidbyuser/{username}")
    Call<Long> getIdByUser(@Path("username") String username);
}
