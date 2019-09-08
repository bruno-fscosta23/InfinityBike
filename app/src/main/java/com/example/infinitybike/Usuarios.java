package com.example.infinitybike;

public class Usuarios {

    private String login_cli;
    private String senha_cli;

    public Usuarios() {
    }

    public Usuarios(String login_cli, String senha_cli) {
        this.login_cli = login_cli;
        this.senha_cli = senha_cli;
    }

    public String getLogin_cli() {
        return login_cli;
    }

    public String getSenha_cli() {
        return senha_cli;
    }

    public void setLogin_cli(String login_cli) {
        this.login_cli = login_cli;
    }

    public void setSenha_cli(String senha_cli) {
        this.senha_cli = senha_cli;
    }
}
