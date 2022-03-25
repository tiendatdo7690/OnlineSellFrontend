package com.example.demo.apis;

import com.example.demo.entities.Address;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public interface AddressAPI {

    @GET("address/findallbycustomer/{idcustomer}")
    Call<List<Address>> findByUserName(@Path("idcustomer") Long idcustomer);
}
