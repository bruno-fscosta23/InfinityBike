package com.example.infinitybike;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class DadosAgendamento_Activity extends AppCompatActivity {

    Toolbar toolbar;
    Button btnFecharDadosAgenda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dados_agendamento_layout);

        toolbar = (Toolbar) findViewById(R.id.idToobarDadosAgendamento);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");

        btnFecharDadosAgenda = (Button)findViewById(R.id.btnFecharDados);
        btnFecharDadosAgenda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Agendamento_Activity.class));
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_dados,menu);
        return super.onCreateOptionsMenu(menu);
    }


}
