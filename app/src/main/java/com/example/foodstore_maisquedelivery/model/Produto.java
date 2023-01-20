package com.example.foodstore_maisquedelivery.model;

public class Produto {

    private String nome;
    private String descricao;
    private String rate;
    private String valor;
    private int quantidade;
    private int imagem;


    public Produto() {
    }

    public Produto(String nome, String descricao, String rate, String valor, int quantidade, int imagem) {
        this.nome = nome;
        this.descricao = descricao;
        this.rate = rate;
        this.valor = valor;
        this.quantidade = quantidade;
        this.imagem = imagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }
}
