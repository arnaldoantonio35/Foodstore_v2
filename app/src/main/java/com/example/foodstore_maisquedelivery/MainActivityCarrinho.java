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


    private TextView valorBotaoTotal;


    RecyclerView recyclerPedidos;

    private List<Produto> produtos = new ArrayList<>();

    private List<PedidoFeito> listaPedidosfeitos;

    private PedidoFeitoAdapter pedidoFeitoAdapter;

    double valorTotal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_carrinho);


        /////////////////////////////////////////////////////

        System.out.println("Lista de pedidos: " + (ArrayList<PedidoFeito>) getIntent().getSerializableExtra("pedidos"));

        listaPedidosfeitos = (ArrayList<PedidoFeito>) getIntent().getSerializableExtra("pedidos");


        recyclerPedidos = (RecyclerView)findViewById(R.id.RecyclerView_carrinho);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerPedidos.setLayoutManager(layoutManager);
        pedidoFeitoAdapter = new PedidoFeitoAdapter(getApplicationContext(),listaPedidosfeitos);
        recyclerPedidos.setAdapter(pedidoFeitoAdapter);

        //pedidoFeitoAdapter.setListaPedidosfeitos(listaPedidosfeitos);

        System.out.println("Size lista: " + listaPedidosfeitos.size());

        for (int i = 0; i < listaPedidosfeitos.size(); i++) {
            PedidoFeito pedidoFeito = listaPedidosfeitos.get(i);

            //Log.d("resultado", "onResponse: " + postagemBBQS.getId() + "\n" + postagemBBQS.getName());

            System.out.println("Id: " + pedidoFeito.getId());


                        /*
                        System.out.println("Numero: " + i);
                        System.out.println("\nNome: " + pedidoFeito.getName());

                        nomeTexto = pedidoFeito.getName();

                        System.out.println("Id: " + pedidoFeito.getId());
                        System.out.println("Desc: " + pedidoFeito.getDsc());
                        System.out.println("Preço: " + pedidoFeito.getPrice());
                        System.out.println("Rate: " + pedidoFeito.getRate());
                        System.out.println("Imagem: " + pedidoFeito.getImg());

                         */






            //System.out.println(postagemBBQS.getId());

            //System.out.println("Produto: "+ p);

        }



        //////////////////////////////////////////////
        //textNome = findViewById(R.id.valor_nome);
        //textIdade = findViewById(R.id.valor_valor);
        //textEmail = findViewById(R.id.email_valor);

        valorBotaoTotal = findViewById(R.id.botao_Pagar);


        //recuperar os valores na proxima tela(activity)

        Bundle dados = getIntent().getExtras();

        valorTotal = dados.getDouble("valorTotal");

        System.out.println("valor total carrinho: " + valorTotal);

        valorBotaoTotal.setText("PAGAR R$: "+ valorTotal);

        //String nome = dados.getString("nome");
        //int idade = dados.getInt("idade");




        //valorBotaoTotal.setText(valorTotal);

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


        finish();

    }

    public void telaPagamento(View view){

        System.out.println("Entrou no metodo tela pagamento");

        Intent intent = new Intent(this, MainActivityPagamento.class);

        startActivity(intent);

    }

    /*

    public void chamaValorTotal(){

        TextView pagarValor = findViewById(R.id.botao_Pagar);

        pagarValor.setText("PAGAR R$: "+ valorTotal);

    }

     */








}
