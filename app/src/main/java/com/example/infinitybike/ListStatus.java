package com.example.infinitybike;

public class ListStatus {
    private String os;
    private String data;
    private String avalicao;
    private String coment;
    private int ratingbar;

    public ListStatus(String s, String s1, String s2) {
    }

    public ListStatus(String os, String data, String avalicao, String coment, int ratingbar) {
        this.os = os;
        this.data = data;
        this.avalicao = avalicao;
        this.coment = coment;
        this.ratingbar = ratingbar;
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

    public int getRatingbar() {
        return ratingbar;
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

    public void setRatingbar(int ratingbar) {
        this.ratingbar = ratingbar;
    }
}
