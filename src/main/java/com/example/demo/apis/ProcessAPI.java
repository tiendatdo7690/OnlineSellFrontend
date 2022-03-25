package com.example.demo.apis;


import com.example.demo.entities.Process;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public interface ProcessAPI {

    @GET("process/findallbyoder/{idorder}")
    Call<List<Process>> findAllByOrder(@Path("idorder") Long id);
}
