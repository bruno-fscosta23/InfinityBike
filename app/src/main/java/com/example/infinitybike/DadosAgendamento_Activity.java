package com.example.infinitybike;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DadosAgendamento_Activity extends AppCompatActivity {

    Toolbar toolbar;
    Button btnFecharDadosAgenda;
    EditText recData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dados_agendamento_layout);

        recData = (EditText)findViewById(R.id.idDataAgenda);
        toolbar = (Toolbar) findViewById(R.id.idToobarDadosAgendamento);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");

        btnFecharDadosAgenda = (Button)findViewById(R.id.btnFecharDados);
        btnFecharDadosAgenda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(DadosAgendamento_Activity.this);

                builder.setTitle("Discarta Agendamento")
                        .setMessage("Tem certeza que deseja excluir?")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startActivity(new Intent(getApplicationContext(),Agendamento_Activity.class));
                                finish();
                            }
                        })
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }
        });

        Bundle extras = getIntent().getExtras();
        if (extras != null){
            String value = extras.getString("data");
            recData.setText(value);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_dados,menu);
        return super.onCreateOptionsMenu(menu);
    }


}
