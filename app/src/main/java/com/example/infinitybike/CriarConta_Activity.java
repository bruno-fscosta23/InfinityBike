package com.example.infinitybike;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CriarConta_Activity extends AppCompatActivity {

    private static final int CODE_GET_REQUEST = 1024;
    private static final int CODE_POST_REQUEST = 1025;

    EditText txtCriarUsuario,txtSenhaCriar,txtSenhaCriarRep;
    Button btnCriarConta;
    ProgressBar progressBar;

    List<Usuarios> usuarioList;
    boolean isUpdating = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.criar_conta_layout);

        txtCriarUsuario = (EditText)findViewById(R.id.txtCriarUsuario);
        txtSenhaCriar = (EditText)findViewById(R.id.txtSenhaCriar);
        txtSenhaCriarRep = (EditText)findViewById(R.id.txtSenhaCriarRep);

        btnCriarConta = (Button)findViewById(R.id.btnCriarConta);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);

        usuarioList = new ArrayList<>();

        btnCriarConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isUpdating){

                }else {
                    createUsuario();
                }
            }
        });
        readUsuario();
    }

    private void createUsuario() {
        String login_usu = txtCriarUsuario.getText().toString();
        String senha_usu = txtSenhaCriar.getText().toString();
        String senhaRep = txtSenhaCriarRep.getText().toString();

        if (TextUtils.isEmpty(login_usu)){
            txtCriarUsuario.setError("Insira um usuário");
            txtCriarUsuario.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(senha_usu)){
            txtSenhaCriar.setError("Insira uma senha");
            txtSenhaCriar.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(senha_usu) != TextUtils.isEmpty(senhaRep)){
            txtSenhaCriarRep.setError("Insira a mesma senha");
            txtSenhaCriarRep.requestFocus();
            return;
        }

        HashMap<String,String> params = new HashMap<>();
        params.put("login_usu",login_usu);
        params.put("senha_usu",senha_usu);

        PerformNetworkRequest request = new PerformNetworkRequest(Api.URL_CREATE_HERO,params,CODE_POST_REQUEST);
        request.execute();

        btnCriarConta.setText("Concluido");

        txtCriarUsuario.setText("");
        txtSenhaCriar.setText("");
        txtSenhaCriarRep.setText("");

        isUpdating = false;

    }


    private void readUsuario() {
        PerformNetworkRequest request = new PerformNetworkRequest(Api.URL_READ_HEROES,null,CODE_GET_REQUEST);
        request.execute();
    }

    private void refreshUsuarioList (JSONArray usuario) throws JSONException {
        usuarioList.clear();

        for (int i = 0; i < usuario.length(); i++){
            JSONObject obj = usuario.getJSONObject(i);
            usuarioList.add(new Usuarios(
                    obj.getString("login_usu"),
                    obj.getString("senha_usu")
            ));
        }
    }

    private class PerformNetworkRequest extends AsyncTask<Void, Void, String>{
        String url;
        HashMap<String,String>params;
        int requestCode;

        PerformNetworkRequest (String url, HashMap<String,String>params,int requestCode){
            this.url = url;
            this.params = params;
            this.requestCode = requestCode;

        }
        @Override
        protected  void onPreExecute(){
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
        }
        @Override
        protected void onPostExecute(String s){
            super.onPostExecute(s);
            progressBar.setVisibility(View.GONE);
            try {
                JSONObject object = new JSONObject(s);
                if (!object.getBoolean("error")){
                    Toast.makeText(getApplicationContext(),object.getString("message"),Toast.LENGTH_SHORT).show();
                    refreshUsuarioList(object.getJSONArray("usuarios"));
                }
            }catch (JSONException e){
                e.printStackTrace();
            }
        }

        @Override
        protected String doInBackground(Void... voids) {
            RequestHandler requestHandler = new RequestHandler();

            if (requestCode == CODE_POST_REQUEST)
                return requestHandler.sendPostResquest(url,params);

            if (requestCode == CODE_GET_REQUEST)
                return requestHandler.sendGetRequest(url);

            return null;
        }
    }
}
