package com.example.demo.apis;

import com.example.demo.entities.UserAccount;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public interface AccountAPI {

    @GET("account/findbyusername/{username}")
    Call<UserAccount> findByUsername(@Path("username") String username);

}
