package com.example.foodstore_maisquedelivery.model;

public class Postagem {

    private String nome;
    private String postagem;
    private int imagens;
    private int like;
    private int index;

    public Postagem() {
    }

    public Postagem(String nome, String postagem, int imagens, int like, int index) {
        this.nome = nome;
        this.postagem = postagem;
        this.imagens = imagens;
        this.like = like;
        this.index = index;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPostagem() {
        return postagem;
    }

    public void setPostagem(String postagem) {
        this.postagem = postagem;
    }

    public int getImagens() {
        return imagens;
    }

    public void setImagens(int imagens) {
        this.imagens = imagens;
    }

    public int getLike() { return like; }

    public void setLike(int like) { this.like = like;}

    public int getIndex() { return index;}

    public void setIndex(int index) { this.index = index; }

}
