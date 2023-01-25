package com.example.foodstore_maisquedelivery.model;

import java.io.Serializable;

public class PedidoFeito implements Serializable {

    private String id;
    private String img;
    private String name;
    private String dsc;
    private double price;
    private String rate;

    private int quantidade;
    private int adicionaItem;
    private int subtraiItem;
    private double priceTotal;


    public PedidoFeito(String id, String img, String name, String dsc, double price, String rate, int quantidade, int adicionaItem, int subtraiItem, double priceTotal) {
        this.id = id;
        this.img = img;
        this.name = name;
        this.dsc = dsc;
        this.price = price;
        this.rate = rate;
        this.quantidade = quantidade;
        this.adicionaItem = adicionaItem;
        this.subtraiItem = subtraiItem;
        this.priceTotal = priceTotal;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDsc() {
        return dsc;
    }

    public void setDsc(String dsc) {
        this.dsc = dsc;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getAdicionaItem() { return adicionaItem; }

    public void setAdicionaItem(int adicionaItem) {
        this.adicionaItem = adicionaItem;
        setQuantidade(getQuantidade() + 1 );
    }
    public int getSubtraiItem() { return subtraiItem; }

    public void setSubtraiItem(int subtraiItem) {
        this.subtraiItem = subtraiItem;
        setQuantidade(getQuantidade() - 1);

        if(getQuantidade() < 0){
            setQuantidade(0);
        }
    }

    public double getPriceTotal() { return priceTotal; }

    public void setPriceTotal(double priceTotal) {
        this.priceTotal = priceTotal;

        priceTotal = getQuantidade() * getPrice();

    }




}
