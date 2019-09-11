package com.example.infinitybike;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Date;

public class Agendamento_Activity extends AppCompatActivity {

    TextView txtData;
    Button btnVoltarAgenda;
    Toolbar toolbar;
    FloatingActionButton btnFloatAgenda;
    CalendarView calendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.agendamento_layout);

        btnVoltarAgenda = (Button)findViewById(R.id.btnVoltarAgenda);
        toolbar = (Toolbar)findViewById(R.id.idToobarAgendamento);
        btnFloatAgenda = (FloatingActionButton)findViewById(R.id.idFloatAgenda);
        calendarView = (CalendarView)findViewById(R.id.idCalendario);
        txtData = (TextView)findViewById(R.id.txtData);

        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("");

        btnVoltarAgenda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MenuNavigation_Activity.class));
                finish();
            }
        });


        btnFloatAgenda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Agendamento_Activity.this,DadosAgendamento_Activity.class);
                String data = txtData.getText().toString().trim();
                intent.putExtra("data",data);
                startActivity(intent);
            }
        });

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                Intent intent = new Intent(Agendamento_Activity.this,Agendamento_Activity.class);
                intent.putExtra("datalong",(long) calendarView.getDate());

                TextView txtData = (TextView)findViewById(R.id.txtData);
                txtData.setText(dayOfMonth + "/" + month + "/" + year);



            }
        });




    }
}
