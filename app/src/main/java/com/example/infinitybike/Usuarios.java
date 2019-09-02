package com.example.infinitybike;

public class Usuarios {

    private String usuario_usu;
    private String senha_usu;

    public Usuarios() {
    }

    public Usuarios(String usuario_usu, String senha_usu) {
        this.usuario_usu = usuario_usu;
        this.senha_usu = senha_usu;
    }

    public String getUsuario_usu() {
        return usuario_usu;
    }

    public void setUsuario_usu(String usuario_usu) {
        this.usuario_usu = usuario_usu;
    }

    public String getSenha_usu() {
        return senha_usu;
    }

    public void setSenha_usu(String senha_usu) {
        this.senha_usu = senha_usu;
    }
}
