package com.example.infinitybike;

public class Api {

    //URL para acesso ao bando de dados WEB Service
    private static final String ROOT_URL = "http://192.168.56.1/InfinityBike/v1/Api.php?apicall=";
    //private static final String ROOT_URL = "http://192.168.100.5/InfinityBike/v1/Api.php?apicall=";

    //Variáveis estáticas e globais para acesso os métodos no WEB Service

    public static final String URL_CREATE_HERO = ROOT_URL + "createusuario";
    public static final String URL_READ_HEROES = ROOT_URL + "getusuario";
    public static final String URL_UPDATE_HERO = ROOT_URL + "updateusuario";
    public static final String URL_DELETE_HERO = ROOT_URL + "deleteusuario&id=";

    //Variáveis estáticas e globais para acesso os métodos no WEB Service

    public static final String URL_CREATE_LOGIN = ROOT_URL + "createlogin";
    public static final String URL_READ_LOGIN = ROOT_URL + "getlogin";
}
