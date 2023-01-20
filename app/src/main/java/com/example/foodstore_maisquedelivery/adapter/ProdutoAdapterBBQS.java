package com.example.foodstore_maisquedelivery.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodstore_maisquedelivery.R;
import com.example.foodstore_maisquedelivery.model.Postagem;
import com.example.foodstore_maisquedelivery.model.PostagemBBQS;
import com.example.foodstore_maisquedelivery.model.Produto;

import java.util.List;

//import com.example.cardview.R;
//import com.example.cardview.model.Postagem;

//import com.example.recyclerviewv4.R;
//import com.example.recyclerviewv4.activity.model.Filme;

public class ProdutoAdapterBBQS extends RecyclerView.Adapter<ProdutoAdapterBBQS.MyViewHolder> {

    /*
    private List<Post> listaFilmes;

    public PostagemAdapter(List<Post> lista) {
        this.listaFilmes = lista;
    }
    */

    /*

    */


    /*

    private List<Postagem> postagens;

    public PostagemAdapter(List<Postagem> listaPostagens) {
        this.postagens = listaPostagens;

        for(int i = 0; i < listaPostagens.size(); i++){

            Postagem index = listaPostagens.get(i);

            System.out.println("\n" + i + "- Lista de postagens: " + listaPostagens.get(i));
        }

    }


     */

    //private List<Postagem> postagens;

    /*

    private List<PostagemBBQS> postagensBBQS;

    public PostagemAdapter(List<PostagemBBQS> listaPostagens) {
        this.postagensBBQS = listaPostagens;

        for(int i = 0; i < listaPostagens.size(); i++){

            //Postagem index = listaPostagens.get(i);

            System.out.println("\n" + i + "- Lista de postagens: " + listaPostagens.get(i));
        }

    }

     */



    //private List<Produto> produtos;


    /*

    public ProdutoAdapterBBQS(List<Produto> listaProdutos){
        this.produtos = listaProdutos;


    }

     */

    private List<PostagemBBQS> postagensBBQS;

    public ProdutoAdapterBBQS(Context applicationContext, List<PostagemBBQS> listaPostagemBBQS){
        this.postagensBBQS = listaPostagemBBQS;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        //System.out.println("Itens na lista: " + viewType);
        return new MyViewHolder(itemLista);

    }

    /*
    private class MyViewHolder extends RecyclerView.ViewHolder {
        public CardView mCardView;

        public MyViewHolder(View view) {
            super(view);
            mCardView = (CardView) view.findViewById(R.id.card_view);
        }

        TextView nomeUser;
        TextView postagemUser;
        ImageView imagemUser;
        TextView likeUser;

    }

     */

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        //Produto produto = produtos.get(position);
        PostagemBBQS postagemBBQS = postagensBBQS.get(position);

        /*

        holder.nomeUser.setText(postagem.getNome());
        holder.postagemUser.setText(postagem.getPostagem());
        holder.imagemUser.setImageResource(postagem.getImagens());

        String likes = String.valueOf(postagem.getLike());

        //likes.toString();

        holder.likeUser.setText(likes);

        holder.mCardView.setTag(position);

        System.out.println("Posição: " + position);

         */


        holder.nomeProduto.setText(postagemBBQS.getName());
        holder.descricaoProduto.setText(postagemBBQS.getDsc());
        holder.rateProduto.setText(postagemBBQS.getRate());
        //holder.valorProduto.setText(postagemBBQS.getPrice());

        String vlr = String.valueOf(postagemBBQS.getPrice());

        holder.valorProduto.setText(vlr);

        //holder.imagemProduto.setImageResource(postagemBBQS.getImg());

        String ImgURL = String.valueOf(postagemBBQS.getImg());

        holder.imagemProduto.setImageResource(Integer.parseInt(ImgURL));


        holder.mCardView.setTag(position);

        System.out.println("Posição: " + position);







        /*
        holder.nomeUser.setText("Arnaldo Antônio @arnaldowiski");
        holder.postagemUser.setText("Olha a cara desse fdp llkkkkjkk");
        holder.imagemUser.setImageResource(R.drawable.after_cookie);


        //Filme filme = listaFilmes.get(position);

        //chamada do metodo do model


        holder.titulo.setText(filme.getTituloFilme());
        holder.genero.setText(filme.getGeneroFilme());
        holder.ano.setText(filme.getAnoFilme());

         */
    }

    @Override
    public int getItemCount() {
        //return (10); //Tamanho da lista

        /*
        System.out.println("Quantidade de postagens: " + postagens.size());
        return  postagens.size();

         */

        System.out.println("Quantidade de postagens: " + postagensBBQS.size());
        return  postagensBBQS.size();


    }


public class MyViewHolder extends RecyclerView.ViewHolder{
        public CardView mCardView;

        private Button botaoLike;

        /*

        TextView nomeUser;
        TextView postagemUser;
        ImageView imagemUser;
        TextView likeUser;


         */

        TextView nomeProduto;
        TextView descricaoProduto;
        TextView rateProduto;
        TextView valorProduto;
        TextView quantidadeProduto;
        ImageView imagemProduto;





public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            mCardView = (CardView) itemView.findViewById(R.id.card_view);


            /*
            botaoLike = (Button) itemView.findViewById(R.id.botao_Curtir);
            nomeUser = itemView.findViewById(R.id.text_nome);
            postagemUser = itemView.findViewById(R.id.texto_postagem);
            imagemUser = itemView.findViewById(R.id.image_Postagem);
            likeUser = itemView.findViewById(R.id.texto_like);

             */

            nomeProduto = itemView.findViewById(R.id.nome_produto);
            descricaoProduto = itemView.findViewById(R.id.descricao_produto);
            rateProduto = itemView.findViewById(R.id.rate_produto);
            valorProduto = itemView.findViewById(R.id.valor_produto);
            //quantidadeProduto = itemView.findViewById(R.id);
            imagemProduto = itemView.findViewById(R.id.imagem_produto);



        }
    }

}
