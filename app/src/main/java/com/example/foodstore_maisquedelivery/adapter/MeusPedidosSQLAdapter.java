package com.example.foodstore_maisquedelivery.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodstore_maisquedelivery.R;
import com.example.foodstore_maisquedelivery.model.SQLdatas;

import java.util.List;

public class MeusPedidosSQLAdapter extends RecyclerView.Adapter<MeusPedidosSQLAdapter.MeusPedidosViewHolder> {

    private Context context;
   // private List<MeusPedidosSQLAdapter> meusDadosSQL;


    /*
    public MeusPedidosSQLAdapter(List<SQLData> lista, Context context){


    }

     */

    private List<SQLdatas> listaSQLData;

    public MeusPedidosSQLAdapter(List<SQLdatas> lista) {
        this.listaSQLData = lista;
    }

    @NonNull
    @Override
    public MeusPedidosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_pedidos,parent,false);
        return new MeusPedidosViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MeusPedidosViewHolder holder, int position) {

        SQLdatas sQLData = listaSQLData.get(position);

        holder.idText.setText(sQLData.getIds());
        holder.nomeText.setText(sQLData.getNames());
        holder.quantText.setText(sQLData.getQuantidade());
        holder.valorText.setText(sQLData.getValor());
        holder.totalText.setText(sQLData.getTotal());

    }

    @Override
    public int getItemCount() {
        return this.listaSQLData.size();
    }

    public class MeusPedidosViewHolder extends RecyclerView.ViewHolder {

        TextView idText;
        TextView nomeText;
        TextView quantText;
        TextView valorText;
        TextView totalText;


        public MeusPedidosViewHolder(@NonNull View itemView) {
            super(itemView);

            idText = itemView.findViewById(R.id.id_produto);
            nomeText = itemView.findViewById(R.id.nome_item);
            quantText = itemView.findViewById(R.id.quantidade_pedido);
            valorText = itemView.findViewById(R.id.valor_und);
            totalText = itemView.findViewById(R.id.valor_total);

        }
    }




}
