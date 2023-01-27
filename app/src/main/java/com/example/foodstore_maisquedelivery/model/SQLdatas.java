package com.example.foodstore_maisquedelivery.model;

import java.io.Serializable;

public class SQLdatas implements Serializable {

    private String ids;
    private String names;
    private String quantidade;
    private String valor;
    private String total;

    public String getIds() {
        return ids;
    }

    public void setIds(String id) {
        this.ids = id;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String name) {
        this.names = name;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
