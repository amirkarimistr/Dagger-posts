package com.example.myapplicationjava.api;

import com.example.myapplicationjava.models.Photo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RandomUserApi {

    @GET("aws1994/f583d54e5af8e56173492d3f60dd5ebf/raw/c7796ba51d5a0d37fc756cf0fd14e54434c547bc/anime.json")
    Call<List<Photo>> getPhotos();

}
