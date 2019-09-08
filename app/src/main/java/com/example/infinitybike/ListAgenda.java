package com.example.infinitybike;

public class ListAgenda {

    private String tipo;
    private String data;
    private String hora;
    private String desc;
    private int cod_cli;

    public ListAgenda() {
    }

    public ListAgenda(String tipo, String data, String hora, String desc, int cod_cli) {
        this.tipo = tipo;
        this.data = data;
        this.hora = hora;
        this.desc = desc;
        this.cod_cli = cod_cli;
    }

    public String getTipo() {
        return tipo;
    }

    public String getData() {
        return data;
    }

    public String getHora() {
        return hora;
    }

    public String getDesc() {
        return desc;
    }

    public int getCod_cli() {
        return cod_cli;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setCod_cli(int cod_cli) {
        this.cod_cli = cod_cli;
    }
}
