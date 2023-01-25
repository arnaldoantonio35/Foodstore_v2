package com.example.foodstore_maisquedelivery.api;

import com.example.foodstore_maisquedelivery.model.Comidas;
import com.example.foodstore_maisquedelivery.model.PostagemBBQS;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("/our-foods")
    Call<List<Comidas>> getComidas();

    @GET("/bbqs")
    Call<List<Comidas>> getBbqs();

    @GET("/best-foods")
    Call<List<Comidas>> getBestFoods();

    @GET("/breads")
    Call<List<Comidas>> getBreads();

    @GET("/burgers")
    Call<List<Comidas>> getBurgers();

    @GET("/chocolates")
    Call<List<Comidas>> getChocolates();

    @GET("/desserts")
    Call<List<Comidas>> getDesserts();

    @GET("/drinks")
    Call<List<Comidas>> getDrinks();

    @GET("/fried-chicken")
    Call<List<Comidas>> getFriedChicken();

    @GET("/pizzas")
    Call<List<Comidas>> getPizzas();

    @GET("/porks")
    Call<List<Comidas>> getPorks();

    @GET("/sausages")
    Call<List<Comidas>> getSausages();

    @GET("/sandwiches")
    Call<List<Comidas>> getSandwiches();

    @GET("/steaks")
    Call<List<Comidas>> getSteaks();

    @GET("/ice-cream")
    Call<List<Comidas>> getIceCream();




}
