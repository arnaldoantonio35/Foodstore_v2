package com.example.foodstore_maisquedelivery.adapter;

import android.content.Context;
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
import com.example.foodstore_maisquedelivery.R;
import com.example.foodstore_maisquedelivery.model.Comidas;
import com.example.foodstore_maisquedelivery.model.PedidoFeito;

import java.util.List;

public class PedidoFeitoAdapter extends RecyclerView.Adapter<PedidoFeitoAdapter.MyViewHolder>{

    Context context;
    List<PedidoFeito> listaPedidosfeitos;

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

        PedidoFeito pedidoFeito = listaPedidosfeitos.get(position);

        holder.nomePedido.setText(pedidoFeito.getName());
        holder.descricaoPedido.setText(pedidoFeito.getDsc());
        holder.ratePedido.setText("Avaliação: "+ pedidoFeito.getRate() + " Estrelas");

        String vlr2 = String.valueOf(pedidoFeito.getPrice());

        holder.valorPedido.setText("R$: " + vlr2);

        Glide.with(context).load(listaPedidosfeitos.get(position).getImg()).apply(RequestOptions.centerCropTransform()).into(holder.imagemPedido);

        holder.mCardView.setTag(position);

        System.out.println("Posição: " + position);


        /*

        holder.nomeProduto.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View itemView) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
                alertDialog.setTitle("Your title");
                alertDialog.setMessage("your message ");
                alertDialog.setPositiveButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                alertDialog.setNegativeButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        // DO SOMETHING HERE

                    }
        })

         */

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

        private Button botaoLike;

        TextView nomePedido;
        TextView descricaoPedido;
        TextView ratePedido;
        TextView valorPedido;
        TextView quantidadePedido;
        ImageView imagemPedido;







        public MyViewHolder(View itemView) {
            super(itemView);

            mCardView = (CardView) itemView.findViewById(R.id.card_view);

            nomePedido = itemView.findViewById(R.id.nome_item_carrinho);
            //descricaoPedido = itemView.findViewById(R.id.);
            //ratePedido = itemView.findViewById(R.id.);
            valorPedido = itemView.findViewById(R.id.valor_item_carrinho);
            quantidadePedido = itemView.findViewById(R.id.quant_item_carrinho);
            imagemPedido = itemView.findViewById(R.id.imagem_item_carrinho);


        }
    }

}
