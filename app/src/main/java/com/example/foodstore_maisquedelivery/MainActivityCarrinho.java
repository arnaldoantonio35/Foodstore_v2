package com.example.foodstore_maisquedelivery;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

//import com.example.foodstore_maisquedelivery.adapter.PedidoFeitoAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodstore_maisquedelivery.adapter.PedidoFeitoAdapter;
import com.example.foodstore_maisquedelivery.adapter.ProdutoAdapterComida;
import com.example.foodstore_maisquedelivery.model.Comidas;
import com.example.foodstore_maisquedelivery.model.PedidoFeito;
import com.example.foodstore_maisquedelivery.model.Produto;

import java.util.ArrayList;
import java.util.List;

public class MainActivityCarrinho extends AppCompatActivity {

    private TextView textNome;
    private TextView textIdade;
    private TextView textEmail;

    private String nomeTexto;


    RecyclerView recyclerPedidos;

    private List<Produto> produtos = new ArrayList<>();

    private List<PedidoFeito> listaPedidosfeitos;

    private PedidoFeitoAdapter pedidoFeitoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_carrinho);

        /////////////////////////////////////////////////////

        listaPedidosfeitos = new ArrayList<>();
        recyclerPedidos = (RecyclerView)findViewById(R.id.RecyclerView_carrinho);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerPedidos.setLayoutManager(layoutManager);
        pedidoFeitoAdapter = new PedidoFeitoAdapter(getApplicationContext(),listaPedidosfeitos);
        recyclerPedidos.setAdapter(pedidoFeitoAdapter);

        pedidoFeitoAdapter.setListaPedidosfeitos(listaPedidosfeitos);

        System.out.println("Size lista: " + listaPedidosfeitos.size());

        for (int i = 0; i < listaPedidosfeitos.size(); i++) {
            PedidoFeito pedidoFeito = listaPedidosfeitos.get(i);

            //Log.d("resultado", "onResponse: " + postagemBBQS.getId() + "\n" + postagemBBQS.getName());

            System.out.println("Id: " + pedidoFeito.getId());

                        /*

                        System.out.println("Numero: " + i);
                        System.out.println("\nNome: " + comida.getName());

                        nomeTexto = comida.getName();

                        System.out.println("Id: " + comida.getId());
                        System.out.println("Desc: " + comida.getDsc());
                        System.out.println("Preço: " + comida.getPrice());
                        System.out.println("Rate: " + comida.getRate());
                        System.out.println("Imagem: " + comida.getImg());

                         */




            //System.out.println(postagemBBQS.getId());

            //System.out.println("Produto: "+ p);

        }



        //////////////////////////////////////////////
        textNome = findViewById(R.id.valor_nome);
        textIdade = findViewById(R.id.valor_valor);
        textEmail = findViewById(R.id.email_valor);


        //recuperar os valores na proxima tela(activity)

        Bundle dados = getIntent().getExtras();

        //String nome = dados.getString("nome");
        //int idade = dados.getInt("idade");


        //Usuario usuario = (Usuario) dados.getSerializable("objeto");

        //configurar valores

        //textNome.setText(nome);
        //textIdade.setText(String.valueOf(idade));

        //textNome.setText(usuario.getNome());
        //textIdade.setText(usuario.getIdade());
        //textEmail.setText(usuario.getEmail());


        //textIdade.setText(usuario.getIdade());



    }

    public void inicioHome(View view){

        Intent intent = new Intent(this, MainActivityTelaEscolha.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
    }


    public void prepararProdutos(){


        /*
        Postagem p = new Postagem("Arnaldo Antônio @arnaldowiski", "Olha a cara dessse FDP kkkkjkk", R.drawable.after_cookie, 2, index++);
        this.postagens.add(p);
        p = new Postagem("Matheus Falcão @m.falcaoum", "Mizinga", R.drawable.imagem1, 3, index++);
        this.postagens.add(p);
        p = new Postagem("Felipe Melo @felipe.melo", "Do nada, Dubai", R.drawable.imagem2, 7, index++);
        this.postagens.add(p);
        p = new Postagem("Humberto Escorel @Uberto", "Obrigado Hotmart kkkk", R.drawable.imagem3, 4, index++);
        this.postagens.add(p);

         */


        //ProdutoAdapterBBQS g = new ProdutoAdapterBBQS(listaPostagensBbqs);
        //this.listaPostagensBbqs.add(g);

        //g = new ProdutoAdapterBBQS("", "" )

        System.out.println("Nome texto: " + nomeTexto);

        PedidoFeito p = new PedidoFeito("id","R.drawable.burger_loader","Nome","descri",19.90,"6",1);
        //this.listaPedidosfeitos(p);

        //Produto p = new PedidoFeito("id","R.drawable.burger_loader","Nome","descri",19.90,"6",1);
        //this.listaPedidosfeitos.add(p);

        System.out.println("Oq tem em produto p: " + p);

        /*

        Produto p = new Produto("Comida 1 xxxx","Descrição xxxxxxDescrição xxxxxx Descrição xxxxxx","Rate: 5","R$: 19,40",1, R.drawable.burger_loader);
        this.produtos.add(p);

        p = new Produto("Comida 2 xxxx","Descrição xxxxxxDescrição xxxxxx Descrição xxxxxx","Rate: 4","R$: 29,40",1, R.drawable.burger_loader);
        this.produtos.add(p);

        p = new Produto("Comida 3 xxxx","Descrição xxxxxxDescrição xxxxxx Descrição xxxxxx","Rate: 5","R$: 39,40",1, R.drawable.burger_loader);
        this.produtos.add(p);

        p = new Produto("Comida 4 xxxx","Descrição xxxxxxDescrição xxxxxx Descrição xxxxxx","Rate: 3","R$: 49,40",1, R.drawable.burger_loader);
        this.produtos.add(p);

        p = new Produto("Comida 5 xxxx","Descrição xxxxxxDescrição xxxxxx Descrição xxxxxx","Rate: 2","R$: 12,50",1, R.drawable.burger_loader);
        this.produtos.add(p);

        p = new Produto("Comida 6 xxxx","Descrição xxxxxxDescrição xxxxxx Descrição xxxxxx","Rate: 5","R$: 30,40",1, R.drawable.burger_loader);
        this.produtos.add(p);

        p = new Produto("Comida 7 xxxx","Descrição xxxxxxDescrição xxxxxx Descrição xxxxxx","Rate: 4","R$: 9,90",1, R.drawable.burger_loader);
        this.produtos.add(p);

        p = new Produto("Comida 8 xxxx","Descrição xxxxxxDescrição xxxxxx Descrição xxxxxx","Rate: 6","R$: 60,00",1, R.drawable.burger_loader);
        this.produtos.add(p);

        p = new Produto("Comida 9 xxxx","Descrição xxxxxxDescrição xxxxxx Descrição xxxxxx","Rate: 9","R$: 40,40",1, R.drawable.burger_loader);
        this.produtos.add(p);

         */


    }






}
