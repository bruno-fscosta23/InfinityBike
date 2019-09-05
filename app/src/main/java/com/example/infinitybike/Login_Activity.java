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

import java.util.HashMap;
import java.util.List;

public class Login_Activity extends AppCompatActivity {

    private static final int CODE_GET_REQUEST = 1024;
    private static final int CODE_POST_REQUEST = 1025;

    EditText txtlogin, txtsenha;
    Button btnEntrar;
    ProgressBar progLogin;

    List<Login> loginList;

    boolean isUpdating = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

        txtlogin = (EditText) findViewById(R.id.txtLoginDois);
        txtsenha = (EditText) findViewById(R.id.txtSenha);
        btnEntrar = (Button) findViewById(R.id.btnEntrar);

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isUpdating) {

                }
                createlogin();
                txtlogin.setText("");
                txtsenha.setText("");
                txtlogin.requestFocus();
            }
        });
        readlogin();
    }

    private void createlogin() {
        String login_usu = txtlogin.getText().toString();
        String senha_usu = txtsenha.getText().toString();
        progLogin = (ProgressBar) findViewById(R.id.idProgLogin);

        if (TextUtils.isEmpty(login_usu)) {
            txtlogin.setText("Insira um Login!");
            txtlogin.requestFocus();
        }
        if (TextUtils.isEmpty(senha_usu)) {
            txtsenha.setText("Insira uma senha!");
        }

        HashMap<String, String> params = new HashMap<>();
        params.put("login_usu", login_usu);
        params.put("senha_usu", senha_usu);

        PerformNetworkRequest request = new PerformNetworkRequest(Api.URL_CREATE_LOGIN, params, CODE_POST_REQUEST);
        request.execute();
    }

    private void readlogin() {
        PerformNetworkRequest request = new PerformNetworkRequest(Api.URL_READ_LOGIN, null, CODE_GET_REQUEST);
        request.execute();
    }

    private void refreshLoginList(JSONArray login) throws JSONException {
        loginList.clear();

        for (int i = 0; i < login.length(); i++) {
            JSONObject obj = login.getJSONObject(i);

            loginList.add(new Login(
                    obj.getString("login_usu"),
                    obj.getString("senha_usu")
            ));
        }
    }

    private class PerformNetworkRequest extends AsyncTask<Void, Void, String> {
        String url;
        HashMap<String, String> params;
        int requestCode;

        public PerformNetworkRequest(String url, HashMap<String, String> params, int requestCode) {
            this.url = url;
            this.params = params;
            this.requestCode = requestCode;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progLogin.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onPostExecute(String s){
            super.onPostExecute(s);
            progLogin.setVisibility(View.GONE);

            try {
                JSONObject object = new JSONObject(s);
                if (!object.getBoolean("error")){
                    Toast.makeText(getApplicationContext(),object.getString("message"),Toast.LENGTH_LONG);
                    refreshLoginList(object.getJSONArray("login"));
                }
            }catch (Exception e ){
                e.printStackTrace();
            }
        }

        @Override
        protected String doInBackground(Void... voids) {
            RequestHandler requestHandler = new RequestHandler();
            if (requestCode == CODE_POST_REQUEST){
                return requestHandler.sendPostRequest(url,params);
            }
            if (requestCode == CODE_GET_REQUEST){
                return requestHandler.sendGetRequest(url);
            }

            return null;
        }
    }
}
