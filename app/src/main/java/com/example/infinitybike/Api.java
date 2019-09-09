package com.example.infinitybike;

public class Api {

    //URL para acesso ao bando de dados WEB Service
    private static final String ROOT_URL = "http://10.23.49.25/InfinityBikeApi/v1/Api.php?apicall=";
    //private static final String ROOT_URL = "http://192.168.100.5/InfinityBikeApi/v1/Api.php?apicall=";

    //Variáveis estáticas e globais para acesso os métodos no WEB Service

    public static final String URL_CREATE_LOGIN = ROOT_URL + "createlogin";
    public static final String URL_READ_LOGIN = ROOT_URL + "getlogin";
    public static final String URL_UPDATE_HERO = ROOT_URL + "updatelogin";
    public static final String URL_DELETE_HERO = ROOT_URL + "deletelogin&id=";

    //Variáveis estáticas e globais para acesso os métodos no WEB Service

    public static final String URL_CREATE_ACESSO = ROOT_URL + "createacesso";
    public static final String URL_READ_ACESSO = ROOT_URL + "getacesso";

    //Variáveis estáticas e globais para acesso os métodos no WEB Service

    public static final String URL_CREATE_CLIENTE = ROOT_URL + "createcliente";
    public static final String URL_READ_CLIENTE = ROOT_URL + "getcliente";

    //Variáveis estáticas e globais para acesso os métodos no WEB Service

    public static final String URL_CREATE_ENDERECO = ROOT_URL + "createendereco";
    public static final String URL_READ_ENDERECO = ROOT_URL + "getendereco";

}
