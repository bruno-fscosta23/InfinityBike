package com.example.infinitybike;

public class ListAltUsuario {

    private String nome;
    private String endereco;
    private int num;
    private String bairro;
    private String cidade;
    private String estado;
    private int cep;
    private String comp;
    private int telFixo;
    private int telCel;
    private int cpf;

    public ListAltUsuario() {
    }

    public ListAltUsuario(String nome, String endereco, int num, String bairro, String cidade, String estado, int cep, String comp, int telFixo, int telCel, int cpf) {
        this.nome = nome;
        this.endereco = endereco;
        this.num = num;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.comp = comp;
        this.telFixo = telFixo;
        this.telCel = telCel;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public int getNum() {
        return num;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public int getCep() {
        return cep;
    }

    public String getComp() {
        return comp;
    }

    public int getTelFixo() {
        return telFixo;
    }

    public int getTelCel() {
        return telCel;
    }

    public int getCpf() {
        return cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public void setComp(String comp) {
        this.comp = comp;
    }

    public void setTelFixo(int telFixo) {
        this.telFixo = telFixo;
    }

    public void setTelCel(int telCel) {
        this.telCel = telCel;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }
}
