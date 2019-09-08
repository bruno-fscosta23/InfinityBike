package com.example.infinitybike;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;

public class FormCadastro_Activity extends AppCompatActivity {

    private static final int CODE_GET_REQUEST = 1024;
    private static final int CODE_POST_REQUEST = 1025;

    Toolbar toolbar;
    TextInputEditText txtNome,txtEmail,txtEndereco,txtNumero,txtBairro,txtCidade,txtEstado,txtCEP,txtComp,txtTelFixo,txtTelCel,txtCPF;
    Button btnCadastrar;

    List<ListCliente> clienteList;
    boolean cadastro = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_cadastro_layout);

        toolbar = (Toolbar)findViewById(R.id.idToobarForm);
        txtNome = (TextInputEditText)findViewById(R.id.txtNome);
        txtEmail = (TextInputEditText)findViewById(R.id.txtEmail);
        txtEndereco = (TextInputEditText)findViewById(R.id.txtEndereco);
        txtNumero = (TextInputEditText)findViewById(R.id.txtNumero);
        txtBairro = (TextInputEditText)findViewById(R.id.txtBairro);
        txtCidade = (TextInputEditText)findViewById(R.id.txtCidade);
        txtEstado = (TextInputEditText)findViewById(R.id.txtEstado);
        txtCEP = (TextInputEditText)findViewById(R.id.txtCEP);
        txtComp = (TextInputEditText)findViewById(R.id.txtComp);
        txtTelFixo = (TextInputEditText)findViewById(R.id.txtTelFixo);
        txtTelCel =(TextInputEditText)findViewById(R.id.txtTelCel);
        txtCPF = (TextInputEditText)findViewById(R.id.txtCPF);
        btnCadastrar = (Button)findViewById(R.id.btnCadastrar);


        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cadastro){

                }else {
                    createcliente();
                    createendereco();
                }
            }
        });
        readcliente();
        readendereco();

    }



    private void createcliente() {
        String nome_cli = txtNome.getText().toString().trim();
        String cpf_cli = txtCPF.getText().toString().trim();
        String email_cli = txtEmail.getText().toString().trim();
        String tel_cli_fixo = txtTelFixo.getText().toString().trim();
        String tel_cli_cel = txtTelCel.getText().toString().trim();

        HashMap<String,String> params = new HashMap<>();
        params.put("nome_cli",nome_cli);
        params.put("cpf_cli",cpf_cli);
        params.put("email_cli",email_cli);
        params.put("tel_cli_fixo",tel_cli_fixo);
        params.put("tel_cli_cel",tel_cli_cel);

        PerformNetworkRequest request = new PerformNetworkRequest(Api.URL_CREATE_CLIENTE,params,CODE_POST_REQUEST);
        request.execute();
    }

    private void readcliente() {
        PerformNetworkRequest request = new PerformNetworkRequest(Api.URL_READ_CLIENTE,null,CODE_GET_REQUEST);
        request.execute();
    }
    private void readendereco() {
        String logra_end = txtEndereco.getText().toString().trim();
        String comp_cli = txtComp.getText().toString().trim();
        String cep_cli = txtCEP.getText().toString().trim();
        String num_end = txtNumero.getText().toString().trim();
        String bairro_end = txtBairro.getText().toString().trim();
        String cid_end = txtCidade.getText().toString().trim();
        String est_end = txtEstado.getText().toString().trim();

        HashMap<String,String>params = new HashMap<>();
        params.put("logra_end",logra_end);
        params.put("comp_cli",comp_cli);
        params.put("cep_cli",cep_cli);
        params.put("num_end",num_end);
        params.put("bairro_end",bairro_end);
        params.put("cid_end",cid_end);
        params.put("est_end",est_end);

        PerformNetworkRequest request = new PerformNetworkRequest(Api.URL_CREATE_ENDERECO,params,CODE_POST_REQUEST);
        request.execute();

    }

    private void createendereco() {
        PerformNetworkRequest request = new PerformNetworkRequest(Api.URL_READ_ENDERECO,null,CODE_GET_REQUEST);
        request.execute();
    }

    private void refreshClienteList (JSONArray clientes) throws JSONException{
        clienteList.clear();

        for(int i = 0;i <clientes.length(); i++){
            JSONObject obj = clientes.getJSONObject(i);

            clienteList.add(new ListCliente(
                    obj.getString("nome_cli"),
                    obj.getInt("cep_cli"),
                    obj.getString("email_cli"),
                    obj.getInt("tel_cli_fixo"),
                    obj.getInt("tel_cli_cel"),
                    obj.getString("logra_end"),
                    obj.getString("comp_cli"),
                    obj.getInt("cep_cli"),
                    obj.getInt("num_end"),
                    obj.getString("bairro_end"),
                    obj.getString("cid_end"),
                    obj.getString("est_end")
            ));
        }

    }

    private class PerformNetworkRequest extends AsyncTask<Void,Void, String>{
        String url;
        HashMap<String,String> params;
        int requestCode;

        PerformNetworkRequest (String url,HashMap<String,String> params, int requesCode){
            this.url = url;
            this.params = params;
            this.requestCode = requesCode;
        }

        protected void onPreExecute(){
            super.onPreExecute();

        }

        protected void onPostExecute(String s){
            super.onPostExecute(s);

            try{
                JSONObject object = new JSONObject(s);
                if (!object.getBoolean("error")){
                    Toast.makeText(getApplicationContext(), object.getString("message"), Toast.LENGTH_SHORT).show();
                    refreshClienteList(object.getJSONArray("clientes"));
                }
            }catch (JSONException e ){
                e.printStackTrace();
            }
        }
        @Override
        protected String doInBackground(Void... voids) {
            RequestHandler requestHandler = new RequestHandler();

            if (requestCode == CODE_POST_REQUEST)
                return requestHandler.sendPostRequest(url,params);

            if (requestCode == CODE_GET_REQUEST)
                return requestHandler.sendGetRequest(url);

            return null;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_formulario,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.idMenuForm:
                Toast.makeText(getApplicationContext(),"Mandar para o Agendamento",Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
