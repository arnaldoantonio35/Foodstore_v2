package com.example.foodstore_maisquedelivery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.foodstore_maisquedelivery.api.FoodsService;
import com.example.foodstore_maisquedelivery.model.PostagemBBQS;
import com.example.foodstore_maisquedelivery.model.Produto;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;



public class MainActivity extends AppCompatActivity {

    private Retrofit retrofit;
    private FoodsService foodsService;


    private RecyclerView recyclerProduto;
    private List<Produto> produtos = new ArrayList<>();
    private List<PostagemBBQS> listaPostagensBbqs = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_inicial);
        System.out.println("Primeira tela");

    }


    public void proximaTela(View view){

        Intent intent = new Intent(this, MainActivityTelaEscolha.class);
        startActivity(intent);
    }



}