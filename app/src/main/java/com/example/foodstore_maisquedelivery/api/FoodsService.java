package com.example.foodstore_maisquedelivery.api;

import com.example.foodstore_maisquedelivery.model.PostagemBBQS;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FoodsService {

    @GET("/bbqs")
    Call<List<PostagemBBQS>> recuperarBBQS();

    @GET("/best-foods")
    Call<List<PostagemBBQS>> recuperarBestFoods();

    @GET("/breads")
    Call<List<PostagemBBQS>> recuperarBreads();

    @GET("/burgers")
    Call<List<PostagemBBQS>> recuperarBurgers();

    @GET("/chocolates")
    Call<List<PostagemBBQS>> recuperarChocolates();

    @GET("/desserts")
    Call<List<PostagemBBQS>> recuperarDesserts();

    @GET("/drinks")
    Call<List<PostagemBBQS>> recuperarDrinks();

    @GET("/fried-chicken")
    Call<List<PostagemBBQS>> recuperarFriedChicken();

    @GET("/pizzas")
    Call<List<PostagemBBQS>> recuperarPizzas();

    @GET("/porks")
    Call<List<PostagemBBQS>> recuperarPorks();

    @GET("/sausages")
    Call<List<PostagemBBQS>> recuperarSausages();

    @GET("/sandwiches")
    Call<List<PostagemBBQS>> recuperarSandwiches();

    @GET("/steaks")
    Call<List<PostagemBBQS>> recuperarSteaks();

    @GET("/ice-cream")
    Call<List<PostagemBBQS>> recuperarIceCream ();

    @GET("/our-foods")
    Call<List<PostagemBBQS>> recuperarOurFoods();

}

