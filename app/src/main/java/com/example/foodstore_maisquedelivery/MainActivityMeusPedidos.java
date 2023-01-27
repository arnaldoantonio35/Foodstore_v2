package com.example.foodstore_maisquedelivery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.example.foodstore_maisquedelivery.adapter.MeusPedidosSQLAdapter;
import com.example.foodstore_maisquedelivery.model.PedidoFeito;
import com.example.foodstore_maisquedelivery.model.SQLdatas;

import java.sql.SQLData;
import java.util.ArrayList;
import java.util.List;

public class MainActivityMeusPedidos extends AppCompatActivity {

    RecyclerView recyclerPedidosSQL;
    private MeusPedidosSQLAdapter meusPedidosSQLAdapter;
    private List<SQLdatas> listaSQLData = new ArrayList<>();
    private SQLiteDatabase bancoDados;

    List<SQLdatas> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_meus_pedidos);

        recyclerPedidosSQL = findViewById(R.id.recyclerView_pedidos);



        /*

        SQLdatas sLQdata1 = new SQLdatas();
        sLQdata1.setIds("ID: " + "1");
        sLQdata1.setNames("PEDIDO: " + "NOME QUALQUER");
        sLQdata1.setQuantidade("QTD: " + "2");
        sLQdata1.setValor("VALOR: R$: " + "10");
        sLQdata1.setTotal("TOTAL: R$: " + "20");
        listaSQLData.add(sLQdata1);

        SQLdatas sLQdata2 = new SQLdatas();
        sLQdata2.setIds("ID: " + "1");
        sLQdata2.setNames("PEDIDO: " + "NOME QUALQUER");
        sLQdata2.setQuantidade("QTD: " + "2");
        sLQdata2.setValor("VALOR: R$: " + "10");
        sLQdata2.setTotal("TOTAL: R$: " + "20");
        listaSQLData.add(sLQdata2);


        SQLdatas sLQdata3 = new SQLdatas();
        sLQdata3.setIds("ID: " + "1");
        sLQdata3.setNames("PEDIDO: " + "NOME QUALQUER");
        sLQdata3.setQuantidade("QTD: " + "2");
        sLQdata3.setValor("VALOR: R$: " + "10");
        sLQdata3.setTotal("TOTAL: R$: " + "20");
        listaSQLData.add(sLQdata3);


        SQLdatas sLQdata4 = new SQLdatas();
        sLQdata4.setIds("ID: " + "1");
        sLQdata4.setNames("PEDIDO: " + "NOME QUALQUER");
        sLQdata4.setQuantidade("QTD: " + "2");
        sLQdata4.setValor("VALOR: R$: " + "10");
        sLQdata4.setTotal("TOTAL: R$: " + "20");
        listaSQLData.add(sLQdata4);


        SQLdatas sLQdata5 = new SQLdatas();
        sLQdata5.setIds("ID: " + "1");
        sLQdata5.setNames("PEDIDO: " + "NOME QUALQUER");
        sLQdata5.setQuantidade("QTD: " + "2");
        sLQdata5.setValor("VALOR: R$: " + "10");
        sLQdata5.setTotal("TOTAL: R$: " + "20");
        listaSQLData.add(sLQdata5);


         */

        listar();



        meusPedidosSQLAdapter = new MeusPedidosSQLAdapter(listaSQLData);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());

        recyclerPedidosSQL.setLayoutManager(layoutManager);

        recyclerPedidosSQL.setHasFixedSize(true);

        recyclerPedidosSQL.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayoutManager.VERTICAL));

        recyclerPedidosSQL.setAdapter(meusPedidosSQLAdapter);


    }

    public List<SQLdatas> listar(){



        bancoDados = openOrCreateDatabase("app", MODE_PRIVATE, null);

        String consulta = "SELECT * FROM pedidos";

        Cursor cursor = bancoDados.rawQuery(consulta, null);

        //indices da tabela



        cursor.moveToFirst();

        if(cursor != null && cursor.moveToFirst()){
            do{

                SQLdatas sqldatas = new SQLdatas();


                int indiceID = cursor.getColumnIndex("id");
                int indiceNome = cursor.getColumnIndex("nome");
                int indiceQuantidade = cursor.getColumnIndex("quantidade");
                int indiceValor = cursor.getColumnIndex("valor");
                int indiceValorTotal = cursor.getColumnIndex("valorTotal");


                sqldatas.setIds("ID: "+ cursor.getString(indiceID));
                sqldatas.setNames("Nome item: " + cursor.getString(indiceNome));
                sqldatas.setQuantidade("QTD: " + cursor.getString(indiceQuantidade));
                sqldatas.setValor("UND R$: " + cursor.getString(indiceValor));
                sqldatas.setTotal("TOTAL R$: " + cursor.getString(indiceValorTotal));

                listaSQLData.add(sqldatas);



                System.out.println("Resultado ID:  " + cursor.getString(indiceID));
                System.out.println("Resultado Nome: " + cursor.getString(indiceNome));
                System.out.println("Resultado Quantidade: " + cursor.getString(indiceQuantidade));
                System.out.println("Resultado Valor: " + cursor.getString(indiceValor));
                System.out.println("Resultado ValorTotal: " + cursor.getString(indiceValorTotal));




            }while(cursor.moveToNext());
        }


        return list;
    }





}