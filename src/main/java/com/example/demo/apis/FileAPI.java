package com.example.demo.apis;


import com.example.demo.entities.File;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;


import java.util.List;

public interface FileAPI {


    @POST("file/uploadfile")
    Call<Void> uploadFile(@Body File file);

    @POST("file/uploadfiles")
    Call<Void> uploadFiles(@Body List<File> files);
}
