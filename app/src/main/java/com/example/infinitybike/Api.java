package com.example.infinitybike;

public class Api {

    //URL para acesso ao bando de dados WEB Service
    private static final String ROOT_URL = "http://192.168.100.5/HeroApi/v1/Api.php?apicall=";

    //Variáveis estáticas e globais para acesso os métodos no WEB Service

    public static final String URL_CREATE_HERO = ROOT_URL + "createusuario";
    public static final String URL_READ_HEROES = ROOT_URL + "getusuario";
    public static final String URL_UPDATE_HERO = ROOT_URL + "updateheror";
    public static final String URL_DELETE_HERO = ROOT_URL + "deletehero&id=";
}
