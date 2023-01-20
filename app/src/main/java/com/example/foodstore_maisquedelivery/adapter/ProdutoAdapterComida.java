package com.example.foodstore_maisquedelivery.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
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



public class ProdutoAdapterComida extends RecyclerView.Adapter<ProdutoAdapterComida.MyViewHolder> {

    Context context;
    List<Comidas> listaComidas;
    List<PedidoFeito> listaPedidosfeitos;

    public ProdutoAdapterComida(Context context, List<Comidas> listaComidas){
        this.context = context;
        this.listaComidas = listaComidas;
    }

    public void setComidasList(List<Comidas> listaComidas) {
        this.listaComidas = listaComidas;
        notifyDataSetChanged();
    }


    @Override
    public ProdutoAdapterComida.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_view,parent,false);
        System.out.println("Itens na lista: " + viewType);

        return new MyViewHolder(view);

    }


    @Override
    public void onBindViewHolder(ProdutoAdapterComida.MyViewHolder holder, int position) {

        Comidas comida = listaComidas.get(position);
        //PedidoFeito pedidoFeito = listaPedidosfeitos.get(position);

        holder.nomeProduto.setText(comida.getName());
        holder.descricaoProduto.setText(comida.getDsc());
        holder.rateProduto.setText("Avaliação: "+ comida.getRate() + " Estrelas");

        String vlr = String.valueOf(comida.getPrice());

        holder.valorProduto.setText("R$: " + vlr);

        Glide.with(context).load(listaComidas.get(position).getImg()).apply(RequestOptions.centerCropTransform()).into(holder.imagemProduto);

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
        if(listaComidas != null){
            return listaComidas.size();
        }
        return 0;

    }


    public class MyViewHolder extends RecyclerView.ViewHolder{
        public CardView mCardView;

        private Button botaoLike;

        TextView nomeProduto;
        TextView descricaoProduto;
        TextView rateProduto;
        TextView valorProduto;
        TextView quantidadeProduto;
        ImageView imagemProduto;
        ImageView imagemProduto2;





        public MyViewHolder(View itemView) {
            super(itemView);

            mCardView = (CardView) itemView.findViewById(R.id.card_view);

            nomeProduto = itemView.findViewById(R.id.nome_produto);
            descricaoProduto = itemView.findViewById(R.id.descricao_produto);
            rateProduto = itemView.findViewById(R.id.rate_produto);
            valorProduto = itemView.findViewById(R.id.valor_produto);
            //quantidadeProduto = itemView.findViewById(R.id);
            imagemProduto = itemView.findViewById(R.id.imagem_produto);
            //imagemProduto2 = itemView.findViewById(R.id.imagem_para_Carrinho);

        }
    }

}

