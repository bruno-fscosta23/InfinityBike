package com.example.infinitybike;

public class Usuarios {

    private String login_usu;
    private String senha_usu;

    public Usuarios() {
    }

    public Usuarios(String login_usu, String senha_usu) {
        this.login_usu = login_usu;
        this.senha_usu = senha_usu;
    }

    public String getLogin_usu() {
        return login_usu;
    }

    public String getSenha_usu() {
        return senha_usu;
    }

    public void setLogin_usu(String login_usu) {
        this.login_usu = login_usu;
    }

    public void setSenha_usu(String senha_usu) {
        this.senha_usu = senha_usu;
    }
}
