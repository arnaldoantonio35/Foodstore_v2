package com.example.foodstore_maisquedelivery;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.foodstore_maisquedelivery.R;
import com.example.foodstore_maisquedelivery.adapter.ProdutoAdapterBBQS;
import com.example.foodstore_maisquedelivery.adapter.ProdutoAdapterComida;
import com.example.foodstore_maisquedelivery.api.ApiCliente;
import com.example.foodstore_maisquedelivery.api.ApiService;
import com.example.foodstore_maisquedelivery.api.FoodsService;
import com.example.foodstore_maisquedelivery.model.Comidas;
import com.example.foodstore_maisquedelivery.model.PedidoFeito;
import com.example.foodstore_maisquedelivery.model.Postagem;
import com.example.foodstore_maisquedelivery.model.PostagemBBQS;
import com.example.foodstore_maisquedelivery.model.Produto;
import com.example.foodstore_maisquedelivery.adapter.ProdutoAdapter;
import com.example.foodstore_maisquedelivery.model.RecyclerItemClickListener;

import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.app.ProgressDialog.show;
import static android.content.DialogInterface.BUTTON_POSITIVE;
import static java.sql.DriverManager.println;

public class MainActivityTelaEscolha extends AppCompatActivity {//MAIN

    private Retrofit retrofit;
    private FoodsService foodsService;

    //private SelectionTracker<Long> selectionTracker;

    /*
    private RecyclerView recyclerProduto;
    private List<Produto> produtos = new ArrayList<>();
    private List<PostagemBBQS> listaPostagensBbqs = new ArrayList<>();
    private List<Comidas> listaComidas = new ArrayList<>();

    private ProdutoAdapterComida produtoAdapterComida;


     */

    RecyclerView recyclerProduto;
    private List<Produto> produtos = new ArrayList<>();
    private List<PostagemBBQS> listaPostagensBbqs = new ArrayList<>();
    private List<Comidas> listaComidas;
    private ArrayList<PedidoFeito> listaPedidosfeitos = new ArrayList<>();

    private ProdutoAdapterComida produtoAdapterComida;

    PedidoFeito pedidoFeito;

    private String nomeTexto;

    private int ItemSelecionado;

    double valorTotal;

    int listaAPI;

    int contavolta;

    ImageView imagemAlert;
    TextView textoNomeItemAlert;

    Button botaoMeusPedidos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_escolha_pedidos);
        System.out.println("Tela_escolha_pedidos");

        //////////////////////////////////////////////////////////////////////////



        listaComidas = new ArrayList<>();
        recyclerProduto = (RecyclerView)findViewById(R.id.recycler_Produto);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerProduto.setLayoutManager(layoutManager);
        produtoAdapterComida = new ProdutoAdapterComida(getApplicationContext(),listaComidas);
        recyclerProduto.setAdapter(produtoAdapterComida);

        ApiService apiService = ApiCliente.getClient().create(ApiService.class);

        Call<List<Comidas>> call = apiService.getComidas();
        //Call<List<Comidas>> call = apiService.getIceCream();
        //Call<List<Comidas>> call2 = apiService.getBbqs();
        //Call<List<Comidas>> call3 = apiService.getBurgers();

        //call.equals(apiService.getIceCream());

        call.enqueue(new Callback<List<Comidas>>() {

            @Override
            public void onResponse(Call<List<Comidas>> call, Response<List<Comidas>> response) {

                listaComidas = response.body();
                produtoAdapterComida.setComidasList(listaComidas);


                if (response.isSuccessful()) {

                    System.out.println("Sucesso na chamada da API");
                    //listaComidas = response.body();
                    //produtoAdapterComida.setComidasList(listaComidas);

                    System.out.println("Size comidas: " + listaComidas.size());

                    for (int i = 0; i < listaComidas.size(); i++) {
                        Comidas comida = listaComidas.get(i);

                        //Log.d("resultado", "onResponse: " + postagemBBQS.getId() + "\n" + postagemBBQS.getName());

                        /*

                        System.out.println("Numero: " + i);
                        System.out.println("\nNome: " + comida.getName());

                        nomeTexto = comida.getName();

                        System.out.println("Id: " + comida.getId());
                        System.out.println("Desc: " + comida.getDsc());
                        System.out.println("Pre??o: " + comida.getPrice());
                        System.out.println("Rate: " + comida.getRate());
                        System.out.println("Imagem: " + comida.getImg());

                         */




                        //System.out.println(postagemBBQS.getId());

                        //System.out.println("Produto: "+ p);

                    }

                }

            }

            @Override
            public void onFailure(Call<List <Comidas>> call, Throwable t) {
                Log.d("TAG","Response = "+t.toString());
                System.out.println("API sem resposta... checar a rede.");

               //chamaTextSemRede();

            }


        });



       ///////////////////////////////////////////////////////////////////////// MultiSelect



        recyclerProduto.addOnItemTouchListener(new RecyclerItemClickListener(this, recyclerProduto, new RecyclerItemClickListener.OnItemClickListener() {


            @Override
            public void bottomClick(View view, int position){
                Comidas comidasSelecionada = listaComidas.get(position);
                System.out.println("Nome da comida" + comidasSelecionada.getName());
                //abrirDialog();
            }





            @Override
            public void onItemClick(View view,int position) {
                Comidas comidasSelecionada = listaComidas.get(position);


                //ItemSelecionado = listaComidas.get(position);

                System.out.println("Nome da comida" + comidasSelecionada.getName());
                //Toast.makeText(view.getContext(),"item "+ Integer.toString(position) + " - "+ comidasSelecionada.getName() + " - Adicionado no carrinho.", Toast.LENGTH_SHORT).show();


                //PedidoFeito pedidoFeito = new PedidoFeito("id", "img",comidasSelecionada.getName(),comidasSelecionada.getDsc(),comidasSelecionada.getPrice(),comidasSelecionada.getRate(),1);

                //abrirDialog(position);
                DialogView(position);

            }

            @Override
            public void onLongItemClick(View view, int position) {

            }

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        }));




/////////////////////////////////////////////////////////////////////////////////////

        /*

        retrofit = new Retrofit.Builder()
                //.baseUrl("https://viacep.com.br/ws/")
                //.baseUrl("https://jsonplaceholder.typicode.com")
                .baseUrl("https://free-food-menus-api.onrender.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        foodsService = retrofit.create(FoodsService.class);


        //recuperarListaBBQS();
        //prepararProdutos();

        this.recuperarListaBBQS();
        this.prepararProdutos();



        //////////////////////////////////////////////////////////////////////////////

        recyclerProduto = findViewById(R.id.recycler_Produto);

        //definindo o layout

        //RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        //layoutManager.setOrientation(LinearLayout. HORIZONTAL);
        layoutManager.setOrientation(LinearLayout. VERTICAL);

        recyclerProduto.setLayoutManager(layoutManager);


        //definindo o adapter

        //this.prepararProdutos(); //metodo que cria as postagens  que est?? no metodo de baixo

        //ProdutoAdapter adapter = new ProdutoAdapter(recuperarListaBBQS());
        ProdutoAdapter adapter = new ProdutoAdapter(produtos);
        recyclerProduto.setAdapter( adapter );

        //ProdutoAdapterBBQS adapter = new ProdutoAdapterBBQS(listaPostagensBbqs);

        //recyclerAdapter = new RecyclerView(getApplicationContext(), (AttributeSet) listaPostagensBbqs);
        //recyclerProduto.setAdapter( adapter );

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

        /*

        FoodsService foodsService = retrofit.create(FoodsService.class);
        Call<List<PostagemBBQS>> call = foodsService.recuperarOurFoods();

        call.enqueue(new Callback<List<PostagemBBQS>>(){

            @Override
            public void onResponse(Call<List<PostagemBBQS>> call, Response<List<PostagemBBQS>> response) {
                if(response.isSuccessful()){
                    listaPostagensBbqs = response.body();



                    //implementa????o das BBQS via activity main

                    for(int i = 0; i < listaPostagensBbqs.size(); i++){
                        PostagemBBQS postagemBBQS = listaPostagensBbqs.get(i);
                        //Log.d("resultado", "onResponse: " + postagemBBQS.getId() + "\n" + postagemBBQS.getName());


                        System.out.println("Numero: " + i);
                        System.out.println("\nNome: " + postagemBBQS.getName());

                        nomeTexto = postagemBBQS.getName();

                        System.out.println("Id: " + postagemBBQS.getId());
                        System.out.println("Desc: " + postagemBBQS.getDsc());
                        System.out.println("Pre??o: " + postagemBBQS.getPrice());
                        System.out.println("Rate: " + postagemBBQS.getRate());
                        System.out.println("Imagem: " + postagemBBQS.getImg());


                        //System.out.println(postagemBBQS.getId());

                        //System.out.println("Produto: "+ p);

                    }

                }

            }

            @Override
            public void onFailure(Call<List<PostagemBBQS>> call, Throwable t) {
                System.out.println("Falhou no onFailure do BBQS");
                System.out.println("erro" + t);
            }
        });

         */


        /*

        private void generateDataList(List<PostagemBBQS> PostagemBBQS) {
            recyclerProduto = findViewById(R.id.recycler_Produto);
            adapter = new RecyclerviewAdapter(this,listaPostagensBbqs);
            //RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);

            ProdutoAdapterBBQS adapter = new ProdutoAdapterBBQS(listaPostagensBbqs);
            recyclerProduto.setAdapter( adapter );

            recyclerProduto.setLayoutManager(layoutManager);
            recyclerProduto.setAdapter(adapter);
        }


         */

        final Button button = (Button) findViewById(R.id.button_pedidos);
        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                System.out.println("Entrou no metodo da tela de pedidos");

                Intent intent = new Intent(MainActivityTelaEscolha.this, MainActivityMeusPedidos.class);

                startActivity(intent);
            }
        });


    }

    public void EnviaValores(int position){

        Comidas comidasSelecionada = listaComidas.get(position);

        PedidoFeito produtoSelecionado = listaPedidosfeitos.get(position);

        String nomePedido = comidasSelecionada.getName();

        ArrayList<PedidoFeito> pedidoFeitos = new ArrayList<>();


    }



    public void DialogView(int position){


        Comidas comidasSelecionada = listaComidas.get(position);


        textoNomeItemAlert = findViewById(R.id.nome_item_carrinho);

        System.out.println("Comida selecionada: " + comidasSelecionada.getName());

        //textoNomeItemAlert.setText("comidas");
        //textoNomeItemAlert.setText(comidasSelecionada.getName());

        //mostraNoAlert(position);

        AlertDialog.Builder alertadd = new AlertDialog.Builder(this);

        alertadd.setTitle("Detalhes do produto:");

        alertadd.setMessage(comidasSelecionada.getName() + "\n" +
                            comidasSelecionada.getDsc() + "\n\n" +
                            "Este item ?? " + comidasSelecionada.getRate() + " estrelas"+ "\n\n" +
                            "R$: "+comidasSelecionada.getPrice() +"\n\n" +
                            "Deseja adicionar o item no carrinho?"

        );


        //PedidoFeito pedidoFeito = .setName(comidasSelecionada.getName());
        //System.out.println(pedidoFeito.getName());

        /*
        LayoutInflater factory = LayoutInflater.from(this);
        final View view = factory.inflate(R.layout.item_view_carrinho, null);
        alertadd.setView(view);

         */

        alertadd.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        System.out.println("Sim acionado");

                        //mandar o atributos para a lista de pedidos feitos (carrinho).

                        System.out.println("Comida selecionada: " + comidasSelecionada.getName());

                        //String name = comidasSelecionada.getName();

                        PedidoFeito pedido = new PedidoFeito(comidasSelecionada.getId(),
                                                            comidasSelecionada.getImg(),
                                                            comidasSelecionada.getName(),
                                                            comidasSelecionada.getDsc(),
                                                            comidasSelecionada.getPrice(),
                                                            comidasSelecionada.getRate(),1, 0, 0, 0);



                        pedido.setId(comidasSelecionada.getId());
                        pedido.setImg(comidasSelecionada.getImg());
                        pedido.setName(comidasSelecionada.getName());
                        pedido.setDsc(comidasSelecionada.getDsc());
                        pedido.setPrice(comidasSelecionada.getPrice());
                        //pedido.setQuantidade(comidasSelecionada.get);


                        System.out.println("Pedido selecionado: " + pedido.getName() +"\n"
                                                                  + pedido.getDsc() +"\n"
                                                                  + pedido.getPrice() + "\n"
                                                                + pedido.getId() + "\n"
                        );

                        double aux = comidasSelecionada.getPrice();

                        //add

                        System.out.println("Valor total: " + valorTotal);

                        listaPedidosfeitos.add(pedido);

                        System.out.println("tamanho lista pedidos: " + pedido);


                        System.out.println("Size lista main: " + listaPedidosfeitos.size());

                        int tamanho = listaPedidosfeitos.size();

                        chamaQuantidade(tamanho);

                        enviaValorTotal(aux);

                        Toast.makeText(getApplicationContext(),"item "+ Integer.toString(position) + " - "+ comidasSelecionada.getName() + " - Adicionado no carrinho.", Toast.LENGTH_LONG).show();
                        Toast.makeText(getApplicationContext(), "O seu item foi adicionado, voc?? pode escolher a quantidade no carrinho - uhuuu!", Toast.LENGTH_LONG).show();
                        //Toast.makeText(view.getContext(),"item "+ Integer.toString(position) + " - "+ comidasSelecionada.getName() + " - Adicionado no carrinho.", Toast.LENGTH_SHORT).show();

                    }
                });

        alertadd.setNegativeButton("N??o", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                System.out.println("N??o acionado");
                Toast.makeText(getApplicationContext(), "Tudo bem, escolha outro item!", Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(), "Se desejar, toque no bot??o ''CATEGORIAS'' e escolha uma delicia especifica :)", Toast.LENGTH_LONG).show();

            }
        });


        alertadd.show();


    }



    public void abrirDialog(int position) {

        Comidas comidasSelecionada = listaComidas.get(position);

        //ItemSelecionado = listaComidas.get(position);

        System.out.println("Nome da comida" + comidasSelecionada.getName());


        //instanciar
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);

        dialog.setTitle("Detalhes do produto:");
        //dialog.setMessage("Nada n??o est?? t??o ruim que n??o possa piorar");
        //dialog.setMessage("N??o sabendo que era impossivel, fui l?? e soube");
        dialog.setMessage(comidasSelecionada.getName());

        dialog.setCancelable(false);

        dialog.setIcon(android.R.drawable.ic_dialog_alert);

        dialog.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                System.out.println("Sim acionado");
                Toast.makeText(getApplicationContext(), "Executar a????o ao clicar no SIM", Toast.LENGTH_SHORT).show();

            }
        });

        dialog.setNegativeButton("FUMO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                System.out.println("N??o acionado");
                Toast.makeText(getApplicationContext(), "N??o ir?? executar nada", Toast.LENGTH_SHORT).show();


            }
        });

        dialog.create();
        dialog.show();

    }

    private void mostraNoAlert(int position){

        setContentView(R.layout.item_view_carrinho);
        Comidas comidasSelecionada = listaComidas.get(position);

        System.out.println("chamou metodo");

        TextView comprova = (TextView) findViewById(R.id.nome_item_carrinho);
        comprova.setText(comidasSelecionada.getName());


    }



    private void chamaTextSemRede(){

        TextView textview = findViewById(R.id.recycler_Produto);

        LinearLayout.LayoutParams esconderTextView = (LinearLayout.LayoutParams) textview.getLayoutParams();

        esconderTextView.weight = 1;
        textview.setLayoutParams(esconderTextView);

    }



    public void positionAction(@NotNull View itemView) {
        int position = (int) itemView.getTag();
        Toast.makeText(itemView.getContext(),Integer.toString(position), Toast.LENGTH_SHORT).show();
    }


    public void telaCarrinho(View view){

        Intent intent = new Intent(this, MainActivityCarrinho.class);
       //intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);

        intent.putExtra("pedidos",listaPedidosfeitos);


        System.out.println("lista pedidos size: " + listaPedidosfeitos.size());

        intent.putExtra("valorTotal",listaPedidosfeitos.size());

        startActivity(intent);
    }

    public void chamaQuantidade(int tamanho){

        TextView qtsPedidos = findViewById(R.id.Qtd_itens);

        if(tamanho <= 1){
            qtsPedidos.setText(tamanho  +"  Item add\nNo carrinho");
        }else {
            qtsPedidos.setText(tamanho + "  Itens add\nNo carrinho");
        }

    }

    public  void enviaValorTotal(double aux){

        valorTotal = valorTotal + aux;

        TextView valorPedidos = findViewById(R.id.Qtd_valor);

        valorPedidos.setText("TOTAL: \nR$: " + valorTotal);

        //Intent intent = new Intent(this, MainActivityCarrinho.class);

        //intent.putExtra("nome","Arnaldo A.");


    }

    public void categorias(View view){

        ApiService apiService = ApiCliente.getClient().create(ApiService.class);


        // setup the alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Selecione uma categoria");

        // add a list
        String[] categorias = {"Todas comidas", "Burgues", "bbqs", "best-foods ", "desserts", "drinks", "fried-chicken","ice-cream","pizzas","porks","sandwiches","sausages ","steaks"};
        builder.setItems(categorias, new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {

                    case 0: // Todas comidas
                        Call<List<Comidas>> call = apiService.getComidas();
                    case 1:
                        //Call<List<Comidas>> call = apiService.getComidas();
                    case 2:

                    case 3:

                    case 4:

                    case 5:

                    case 6:

                    case 7:
                        //Call<List<Comidas>> call = apiService.getIceCream();
                    case 8:

                    case 9:

                    case 10:

                    case 11:

                    case 12:





                    default:
                        listaAPI = 200;
                }
            }
        });

// create and show the alert dialog
        AlertDialog dialog = builder.create();
        builder.show();


    }

    public void onBackPressed() {

        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        startActivity(intent);

        contavolta++;

        if(contavolta > 1){
            finish();
        }
    }



}