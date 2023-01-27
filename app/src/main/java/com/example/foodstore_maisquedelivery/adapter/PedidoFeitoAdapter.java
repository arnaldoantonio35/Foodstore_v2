package com.example.foodstore_maisquedelivery.adapter;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.icu.text.DecimalFormat;
import android.icu.text.Transliterator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.foodstore_maisquedelivery.MainActivity;
import com.example.foodstore_maisquedelivery.MainActivityCarrinho;
import com.example.foodstore_maisquedelivery.R;
import com.example.foodstore_maisquedelivery.model.Comidas;
import com.example.foodstore_maisquedelivery.model.PedidoFeito;

import java.util.List;

public class PedidoFeitoAdapter extends RecyclerView.Adapter<PedidoFeitoAdapter.MyViewHolder>{

    int quantidade;
    int quantidadeNegativa;

    int PosicaoAnterior;
    int PosicaoAtual;
    int NovaPosicao;
    int buffer;

    private SQLiteDatabase bancoDados;

    double valorItem = 0;

    double valorTodosItens;

    double aux;

    int entrou = 0;

    Context context;
    List<PedidoFeito> listaPedidosfeitos;

    int quant1;

    double valorTotal;

    public PedidoFeitoAdapter(Context context, List<PedidoFeito> listaPedidosfeitos){
        this.context = context;
        this.listaPedidosfeitos = listaPedidosfeitos;
    }

    public void setListaPedidosfeitos(List<PedidoFeito> listaPedidosfeitos) {
        this.listaPedidosfeitos = listaPedidosfeitos;
        notifyDataSetChanged();
    }


    @Override
    public PedidoFeitoAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_view_carrinho,parent,false);
        System.out.println("Itens na lista: " + viewType);


        return new PedidoFeitoAdapter.MyViewHolder(view);

    }


    @Override
    public void onBindViewHolder(PedidoFeitoAdapter.MyViewHolder holder, int position) {

        entrou++;

        PedidoFeito pedidoFeito = listaPedidosfeitos.get(position);

        holder.nomePedido.setText(pedidoFeito.getName());
        //holder.descricaoPedido.setText(pedidoFeito.getDsc());
        //holder.ratePedido.setText("Avaliação: "+ pedidoFeito.getRate() + " Estrelas");

        quant1 = pedidoFeito.getQuantidade();

        String quant = String.valueOf(quant1);

        pedidoFeito.setQuantidade(quant1);

        System.out.println("Quantidade: "+ pedidoFeito.getQuantidade() +" na posição: " + position);

        holder.quantidadePedido.setText(quant);


        String vlr2 = String.valueOf(pedidoFeito.getPrice());

        valorItem = pedidoFeito.getPrice() * pedidoFeito.getQuantidade();


        DecimalFormat df = new DecimalFormat("0.00"); //deixar com duas casas decimais

        String valorItemString = String.valueOf(df.format(valorItem));

        holder.valorPedido.setText("R$: " + vlr2);


        holder.valorItemPedido.setText("R$: " + valorItemString);

        Glide.with(context).load(listaPedidosfeitos.get(position).getImg()).apply(RequestOptions.centerCropTransform()).into(holder.imagemPedido);

        holder.mCardView.setTag(position);

        holder.position = position;

        //System.out.println("Posição: " + position);


        aux = valorItem;

        pedidoFeito.setPriceTotal(valorItem);

        //position = position + 1;

        //System.out.println("pedidoFeito.getPriceTotal: " + pedidoFeito.getPriceTotal() + " / Posição: "+ position);

        //System.out.println("Valor total Price: " + pedidoFeito.getPriceTotal());



        valorTotalSomado(pedidoFeito);

        System.out.println("Entrou:" + entrou);


    }

    public void valorTotalSomado(PedidoFeito pedidoFeito){


        valorTodosItens = pedidoFeito.getPriceTotal();

        System.out.println("ValorTodosItens: " + valorTodosItens);


    }

    @Override
    public int getItemCount() {
        if(listaPedidosfeitos != null){
            return listaPedidosfeitos.size();
        }
        return 0;

    }



    public class MyViewHolder extends RecyclerView.ViewHolder{
        public CardView mCardView;


        TextView nomePedido;
        TextView descricaoPedido;
        TextView ratePedido;
        TextView valorPedido;
        TextView quantidadePedido;
        ImageView imagemPedido;
        TextView valorItemPedido;
        int position;





        public MyViewHolder(View itemView) {

            super(itemView);


            mCardView = (CardView) itemView.findViewById(R.id.card_view_carrinho);

            nomePedido = itemView.findViewById(R.id.nome_item_carrinho);
            //descricaoPedido = itemView.findViewById(R.id.);
            //ratePedido = itemView.findViewById(R.id.);
            valorPedido = itemView.findViewById(R.id.valor_item_carrinho);
            quantidadePedido = itemView.findViewById(R.id.quant_item_carrinho);
            imagemPedido = itemView.findViewById(R.id.imagem_item_carrinho);
            valorItemPedido = itemView.findViewById(R.id.valor_total_item);

            quantidade = position;



            itemView.findViewById(R.id.botao_mais).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    PedidoFeito pedidoFeito = listaPedidosfeitos.get(position);

                    pedidoFeito.setAdicionaItem(1);

                    notifyDataSetChanged();


                    }


            });

            itemView.findViewById(R.id.botao_menos).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    PedidoFeito pedidoFeito = listaPedidosfeitos.get(position);

                    pedidoFeito.setSubtraiItem(1);

                    notifyDataSetChanged();
                }


            });



        }
    }





}
