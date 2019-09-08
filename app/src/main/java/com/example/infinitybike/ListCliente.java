package com.example.infinitybike;

public class ListCliente {

    private String nome_cli;
    private int cpf_cli;
    private String email_cli;
    private int tel_cli_fixo;
    private int tel_cli_cel;
    private String logra_end;
    private String comp_cli;
    private int cep_cli;
    private int num_end;
    private String bairro_end;
    private String cid_end;
    private String est_end;

    public ListCliente() {
    }

    public ListCliente(String nome_cli, int cpf_cli, String email_cli, int tel_cli_fixo, int tel_cli_cel, String logra_end, String comp_cli, int cep_cli, int num_end, String bairro_end, String cid_end, String est_end) {
        this.nome_cli = nome_cli;
        this.cpf_cli = cpf_cli;
        this.email_cli = email_cli;
        this.tel_cli_fixo = tel_cli_fixo;
        this.tel_cli_cel = tel_cli_cel;
        this.logra_end = logra_end;
        this.comp_cli = comp_cli;
        this.cep_cli = cep_cli;
        this.num_end = num_end;
        this.bairro_end = bairro_end;
        this.cid_end = cid_end;
        this.est_end = est_end;
    }

    public String getNome_cli() {
        return nome_cli;
    }

    public void setNome_cli(String nome_cli) {
        this.nome_cli = nome_cli;
    }

    public int getCpf_cli() {
        return cpf_cli;
    }

    public void setCpf_cli(int cpf_cli) {
        this.cpf_cli = cpf_cli;
    }

    public String getEmail_cli() {
        return email_cli;
    }

    public void setEmail_cli(String email_cli) {
        this.email_cli = email_cli;
    }

    public int getTel_cli_fixo() {
        return tel_cli_fixo;
    }

    public void setTel_cli_fixo(int tel_cli_fixo) {
        this.tel_cli_fixo = tel_cli_fixo;
    }

    public int getTel_cli_cel() {
        return tel_cli_cel;
    }

    public void setTel_cli_cel(int tel_cli_cel) {
        this.tel_cli_cel = tel_cli_cel;
    }

    public String getLogra_end() {
        return logra_end;
    }

    public void setLogra_end(String logra_end) {
        this.logra_end = logra_end;
    }

    public String getComp_cli() {
        return comp_cli;
    }

    public void setComp_cli(String comp_cli) {
        this.comp_cli = comp_cli;
    }

    public int getCep_cli() {
        return cep_cli;
    }

    public void setCep_cli(int cep_cli) {
        this.cep_cli = cep_cli;
    }

    public int getNum_end() {
        return num_end;
    }

    public void setNum_end(int num_end) {
        this.num_end = num_end;
    }

    public String getBairro_end() {
        return bairro_end;
    }

    public void setBairro_end(String bairro_end) {
        this.bairro_end = bairro_end;
    }

    public String getCid_end() {
        return cid_end;
    }

    public void setCid_end(String cid_end) {
        this.cid_end = cid_end;
    }

    public String getEst_end() {
        return est_end;
    }

    public void setEst_end(String est_end) {
        this.est_end = est_end;
    }
}
