package com.example.foodstore_maisquedelivery.api;

import com.example.foodstore_maisquedelivery.model.Comidas;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("/our-foods")
    Call<List<Comidas>> getComidas();


}
