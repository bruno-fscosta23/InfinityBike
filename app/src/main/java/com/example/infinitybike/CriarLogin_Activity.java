package com.example.infinitybike;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.JsonReader;
import android.util.Log;
import android.view.LayoutInflater;
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

public class CriarLogin_Activity extends AppCompatActivity {

    EditText txtCriarUsuario, txtSenhaCriar, txtSenhaCriarRep;
    Button btnCriarConta;
    ProgressBar progressBar;
    List<Usuarios> usuarioList;
    boolean isUpdating = false;

    private static final int CODE_GET_REQUEST = 1024;
    private static final int CODE_POST_REQUEST = 1025;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.criar_login_layout);

        txtCriarUsuario = (EditText) findViewById(R.id.txtCriarUsuario);
        txtSenhaCriar = (EditText) findViewById(R.id.txtSenhaCriar);
        txtSenhaCriarRep = (EditText) findViewById(R.id.txtSenhaCriarRep);
        btnCriarConta = (Button) findViewById(R.id.btnCriarConta);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        usuarioList = new ArrayList<>();

        btnCriarConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Login_Activity.class));
                finish();
//                if (isUpdating) {
//
//                } else {
//                    createlogin();
//                    txtCriarUsuario.setText("");
//                    txtSenhaCriar.setText("");
//                    txtSenhaCriarRep.setText("");
//                    txtCriarUsuario.requestFocus();
//                }
            }
        });
        readlogin();

    }

    private void createlogin() {
        String login_cli = txtCriarUsuario.getText().toString();
        String senha_cli = txtSenhaCriar.getText().toString();
        String senhausurep = txtSenhaCriarRep.getText().toString();

        if (TextUtils.isEmpty(login_cli)) {
            txtCriarUsuario.setError("Por favor coloque Usuário");
            txtCriarUsuario.requestFocus();
        }

        if (TextUtils.isEmpty(senha_cli)) {
            txtSenhaCriar.setError("Coloque uma Senha");
            txtSenhaCriar.requestFocus();
        }
        if (TextUtils.isEmpty(senha_cli) != (TextUtils.isEmpty(senhausurep))) {
            txtSenhaCriarRep.setError("Senha  Incompatível");
            txtSenhaCriarRep.requestFocus();
        }


        HashMap<String, String> params = new HashMap<>();
        params.put("login_cli", login_cli);
        params.put("senha_cli", senha_cli);

        PerformNetworkRequest request = new PerformNetworkRequest(Api.URL_CREATE_LOGIN,params, CODE_POST_REQUEST);
        request.execute();


    }

    private void readlogin() {
        PerformNetworkRequest request = new PerformNetworkRequest(Api.URL_READ_LOGIN, null, CODE_GET_REQUEST);
        request.execute();


    }

    private void refreshUsuarioList(JSONArray usuarios) throws JSONException {
        usuarioList.clear();

        for (int i = 0; i < usuarios.length(); i++) {
            JSONObject obj = usuarios.getJSONObject(i);

            usuarioList.add(new Usuarios(
                    obj.getString("login_cli"),
                    obj.getString("senha_cli")
            ));
        }
    }

    private class PerformNetworkRequest extends AsyncTask<Void, Void, String> {
        String url;
        HashMap<String, String> params;
        int requestCode;


        PerformNetworkRequest(String url, HashMap<String, String> params, int requestCode) {
            this.url = url;
            this.params = params;
            this.requestCode = requestCode;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            progressBar.setVisibility(View.GONE);

            try {
                JSONObject object = new JSONObject(s);
                if (!object.getBoolean("error")) {
                    Toast.makeText(getApplicationContext(), object.getString("message"), Toast.LENGTH_SHORT).show();
                    refreshUsuarioList(object.getJSONArray("usuarios"));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }


        @Override
        protected String doInBackground(Void... voids) {
            RequestHandler requestHandler = new RequestHandler();

            if (requestCode == CODE_POST_REQUEST)
                return requestHandler.sendPostRequest(url, params);

            if (requestCode == CODE_GET_REQUEST)
                return requestHandler.sendGetRequest(url);
            return null;
        }
    }
}
