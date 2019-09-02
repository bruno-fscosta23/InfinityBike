package com.example.infinitybike;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

public class CriarConta_Activity extends AppCompatActivity {

    private static final int CODE_GET_REQUEST = 1024;
    private static final int CODE_POST_REQUEST = 1025;

    EditText txtCriarUsuario,txtSenhaCriar,txtSenhaCriarRep;
    Button btnCriarConta;
    ProgressBar progressBar;

    List<Usuarios> UsuarioList;
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

        UsuarioList = new ArrayList<>();

        btnCriarConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isUpdating){
                    createUsuario();
                }
            }
        });
        readUsuario();
    }

    private void readUsuario() {
        String usuario = txtCriarUsuario.getText().toString();
        String senha = txtSenhaCriar.getText().toString();
        String senhaRep = txtSenhaCriarRep.getText().toString();

        if (TextUtils.isEmpty(usuario)){
            txtCriarUsuario.setError("Insira um usuário");
            txtCriarUsuario.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(senha)){
            txtSenhaCriar.setError("Insira uma senha");
            txtSenhaCriar.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(senha) == TextUtils.isEmpty(senhaRep)){
            txtSenhaCriarRep.setError("Insira a mesma senha");
            txtSenhaCriarRep.requestFocus();
            return;
        }
    }

    private void createUsuario() {
    }
}
