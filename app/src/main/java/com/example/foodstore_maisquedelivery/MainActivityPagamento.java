package com.example.foodstore_maisquedelivery;

import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivityPagamento extends AppCompatActivity {

    private Button botaoNovoPedido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_pedido_novo);

        botaoNovoPedido = findViewById(R.id.fazer_outro_pedido);



    }



    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivityTelaEscolha.class);
        //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        /*

        AlertDialog.Builder AlertVoltar = new AlertDialog.Builder(this);

        AlertVoltar.setTitle("Atenção");

        AlertVoltar.setMessage("Deseja voltar e manter os itens no carrinho?\n" +
                "Se sim, toque em 'MANTER' e vá no icone 'Home'.\nSenão, tocar em VOLTAR");

        AlertVoltar.setPositiveButton("Manter", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Toast.makeText(getApplicationContext(), "Icone 'HOME' no canto superior direto", Toast.LENGTH_SHORT).show();
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

         */

        startActivity(intent);

    }


    public void voltandoAoInicio(View view) {

        onBackPressed();

    }

    public void alertaVolta(){






    }

}




