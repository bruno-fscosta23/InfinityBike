package com.example.infinitybike;

public class ListStatus {
    private String os;
    private String data;
    private String avalicao;
    private String coment;

    public ListStatus() {
    }

    public ListStatus(String os, String data, String avalicao, String coment) {
        this.os = os;
        this.data = data;
        this.avalicao = avalicao;
        this.coment = coment;
    }

    public String getOs() {
        return os;
    }

    public String getData() {
        return data;
    }

    public String getAvalicao() {
        return avalicao;
    }

    public String getComent() {
        return coment;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setAvalicao(String avalicao) {
        this.avalicao = avalicao;
    }

    public void setComent(String coment) {
        this.coment = coment;
    }
}
