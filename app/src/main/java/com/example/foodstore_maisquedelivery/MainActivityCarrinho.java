package com.example.foodstore_maisquedelivery;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

//import com.example.foodstore_maisquedelivery.adapter.PedidoFeitoAdapter;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodstore_maisquedelivery.adapter.PedidoFeitoAdapter;
import com.example.foodstore_maisquedelivery.adapter.PedidoFeitoAdapter.MyViewHolder;
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

    int quantidadeDeItens;

    private SQLiteDatabase bancoDados;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_carrinho);


        /////////////////////////////////////////////////////

        System.out.println("Lista de pedidos: " + (ArrayList<PedidoFeito>) getIntent().getSerializableExtra("pedidos"));

        listaPedidosfeitos = (ArrayList<PedidoFeito>) getIntent().getSerializableExtra("pedidos");


        recyclerPedidos = (RecyclerView) findViewById(R.id.RecyclerView_carrinho);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerPedidos.setLayoutManager(layoutManager);
        pedidoFeitoAdapter = new PedidoFeitoAdapter(getApplicationContext(), listaPedidosfeitos);
        recyclerPedidos.setAdapter(pedidoFeitoAdapter);

        //pedidoFeitoAdapter.setListaPedidosfeitos(listaPedidosfeitos);

        System.out.println("Size lista: " + listaPedidosfeitos.size());

        for (int i = 0; i < listaPedidosfeitos.size(); i++) {
            PedidoFeito pedidoFeito = listaPedidosfeitos.get(i);

            //Log.d("resultado", "onResponse: " + postagemBBQS.getId() + "\n" + postagemBBQS.getName());

            System.out.println("Id: " + pedidoFeito.getId());


        }



        valorBotaoTotal = findViewById(R.id.botao_Pagar);


        Bundle dados = getIntent().getExtras();

        quantidadeDeItens = dados.getInt("valorTotal");

        System.out.println("valor total carrinho: " + quantidadeDeItens);

        if(quantidadeDeItens > 1){
            valorBotaoTotal.setText("PAGAR - " + quantidadeDeItens + " itens");
        }else{
            valorBotaoTotal.setText("PAGAR - " + quantidadeDeItens + " item");
        }



    }



    public void inicioHome(View view){


        finish();

    }

    public void telaPagamento(View view){//bot??o pagar


        if(quantidadeDeItens >= 1) {

            AlertDialog.Builder alertConfirmar = new AlertDialog.Builder(this);

            alertConfirmar.setTitle("Confima????o de pedidos");

            alertConfirmar.setMessage("Confirma os itens selecionados?" +

                     "\n\n Total de: " + quantidadeDeItens + " itens no carrinho." +
                            "\n\n Deseja finalizar a compra?"

                    );

            System.out.println("Entrou no metodo tela pagamento");

            Intent intent = new Intent(this, MainActivityPagamento.class);

            alertConfirmar.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    System.out.println("Compra finalizada");

                    startActivity(intent);
                }
            });

            alertConfirmar.create();
            alertConfirmar.show();


            salvaEmBanco();





        }else{

            AlertDialog.Builder alertaZeroItens = new AlertDialog.Builder(this);

            alertaZeroItens.setTitle("CARRINHO VAZIO :(");

            alertaZeroItens.setMessage("O carrinho est?? vazio, deseja adicionar algum item?\n" +
                                        "Toque em confirmar para escolher algum item."
            );

            alertaZeroItens.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    System.out.println("Toast carrinho vazio, voltou a tela de escolha");
                    onBackPressed();

                }
            });

            alertaZeroItens.create();
            alertaZeroItens.show();



        }

    }

    public void onBackPressed() {

        Intent intent = new Intent(this, MainActivityTelaEscolha.class);
        //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        if(quantidadeDeItens >= 1) {

            android.app.AlertDialog.Builder AlertVoltar = new android.app.AlertDialog.Builder(this);

            AlertVoltar.setTitle("Aten????o");

            AlertVoltar.setMessage("Deseja voltar e manter os itens no carrinho?\n\n" +
                    "Se sim, toque em 'MANTER'.\n\nSen??o, toque em VOLTAR.");

            AlertVoltar.setPositiveButton("Manter", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    Toast.makeText(getApplicationContext(), "?? possivel voltar e manter os itens indo no icone 'HOME'\n no canto superior direito.", Toast.LENGTH_LONG).show();

                    finish();
                }
            });
            AlertVoltar.setNegativeButton("Voltar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {


                    startActivity(intent);

                }
            });

            AlertVoltar.create();
            AlertVoltar.show();

        }else{

        startActivity(intent);
        }
    }



    public void salvaEmBanco() {


        try {


            //bancoDados = openOrCreateDatabase("app", MODE_PRIVATE, null);

            //criar ou abrir o banco
            bancoDados = openOrCreateDatabase("app", MODE_PRIVATE, null);

            for (int i = 0; i < listaPedidosfeitos.size(); i++) {
                PedidoFeito pedidoFeito = listaPedidosfeitos.get(i);




                String nome = String.valueOf(pedidoFeito.getName());

                nome = nome.replaceAll("'", " ");

                int quant = pedidoFeito.getQuantidade();
                double valorUnidade = pedidoFeito.getPrice();
                double valortotal = pedidoFeito.getPriceTotal();


                //criar tabela
                bancoDados.execSQL("CREATE TABLE IF NOT EXISTS pedidos(id INTEGER PRIMARY KEY AUTOINCREMENT, nome VARCHAR, quantidade INT(3), valor DOUBLE(4), valorTotal DOUBLE(4))");
                //bancoDados.execSQL("CREATE TABLE IF NOT EXISTS pedidos(id INTEGER PRIMARY KEY AUTOINCREMENT, valorTotalSQL DOUBLE(4))");

                //bancoDados.execSQL("DROP TABLE pedidos");

                bancoDados.execSQL("INSERT INTO pedidos(nome, quantidade, valor, valorTotal) VALUES('" + nome + "', " + quant + ", " + valorUnidade + ", " + valortotal + ");");
                //bancoDados.execSQL("INSERT INTO pedidos(nome, quantidade, valor) VALUES('prato4', 6, 99.90)");

            }


            System.out.println("SQL pedidos adicionados");


            //bancoDados.execSQL("DELETE pedidos" );

            System.out.println("Adicionou no SQL");


            String consulta = "SELECT * FROM pedidos";


            //recuperar pedidos
            Cursor cursor = bancoDados.rawQuery(consulta, null);

            //indices da tabela

            int indiceID = cursor.getColumnIndex("id");
            int indiceNome = cursor.getColumnIndex("nome");
            int indiceQuantidade = cursor.getColumnIndex("quantidade");
            int indiceValor = cursor.getColumnIndex("valor");
            int indiceValorTotal = cursor.getColumnIndex("valorTotal");


            cursor.moveToFirst();

            if(cursor != null && cursor.moveToFirst()){
                do{
                    System.out.println("Resultado ID:  " + cursor.getString(indiceID));
                    System.out.println("Resultado Nome: " + cursor.getString(indiceNome));
                    System.out.println("Resultado Quantidade: " + cursor.getString(indiceQuantidade));
                    System.out.println("Resultado Valor: " + cursor.getString(indiceValor));
                    System.out.println("Resultado ValorTotal: " + cursor.getString(indiceValorTotal));
                }while(cursor.moveToNext());
            }



        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("N??o salvou no banco de dados");
        }


    }

    public void botaoPedidosfeitos(View view){

        meusPedidosFeitos();

    }


    public void meusPedidosFeitos(){

        System.out.println("Entrou no metodo da tela de pedidos");

        Intent intent = new Intent(MainActivityCarrinho.this, MainActivityMeusPedidos.class);

        startActivity(intent);


        try {


            bancoDados = openOrCreateDatabase("app", MODE_PRIVATE, null);

            String consulta = "SELECT * FROM pedidos";


            //recuperar pedidos
            Cursor cursor = bancoDados.rawQuery(consulta, null);

            //indices da tabela

            int indiceID = cursor.getColumnIndex("id");
            int indiceNome = cursor.getColumnIndex("nome");
            int indiceQuantidade = cursor.getColumnIndex("quantidade");
            int indiceValor = cursor.getColumnIndex("valor");
            int indiceValorTotal = cursor.getColumnIndex("valorTotal");


            cursor.moveToFirst();

            AlertDialog.Builder alertadiagPedidos = new AlertDialog.Builder(this);

            if(cursor != null && cursor.moveToFirst()){
                do{
                    System.out.println("Resultado ID:  " + cursor.getString(indiceID));
                    System.out.println("Resultado Nome: " + cursor.getString(indiceNome));
                    System.out.println("Resultado Quantidade: " + cursor.getString(indiceQuantidade));
                    System.out.println("Resultado Valor: " + cursor.getString(indiceValor));
                    System.out.println("Resultado ValorTotal: " + cursor.getString(indiceValorTotal));


                }while(cursor.moveToNext());
            }



            System.out.println("Finaliza????o de abertura de banco");


        }catch (Exception e){

            e.printStackTrace();
            System.out.println("N??o foi possivel abrir o banco de dados");



        }



    }




}
