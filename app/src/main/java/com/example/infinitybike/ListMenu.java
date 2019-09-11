package com.example.infinitybike;

public class ListMenu {

    private String titulo;
    private String noticia;
    private String data;
    private int imagem;

    public ListMenu() {
    }

    public ListMenu(String titulo, String noticia, String data, int imagem) {
        this.titulo = titulo;
        this.noticia = noticia;
        this.data = data;
        this.imagem = imagem;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNoticia() {
        return noticia;
    }

    public void setNoticia(String noticia) {
        this.noticia = noticia;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }
}
