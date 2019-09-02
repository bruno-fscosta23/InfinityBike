package com.example.infinitybike;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Agendamento_Activity extends AppCompatActivity {

    Button btnVoltarAgenda;
    FloatingActionButton btnFloatAgenda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.agendamento_layout);

        btnVoltarAgenda = (Button)findViewById(R.id.btnVoltarAgenda);
        btnFloatAgenda = (FloatingActionButton)findViewById(R.id.idFloatAgenda);

        btnVoltarAgenda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),MenuNavigation_Activity.class));
                finish();
            }
        });

        btnFloatAgenda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Agendamento_Activity.this, DadosAgendamento_Activity.class);
                startActivity(intent);

            }
        });

    }
}
