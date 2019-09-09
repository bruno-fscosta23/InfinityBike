package com.example.infinitybike;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class RecebeCardView_Activity extends AppCompatActivity {


    Toolbar toolbar;
    Button btnVoltarMenu;

    List<ListStatus> lstStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recebe_card_view_layout);

        toolbar = (Toolbar)findViewById(R.id.idToobarStatusAgendamento);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("");

        btnVoltarMenu = (Button)findViewById(R.id.btnVoltarStatus);
        btnVoltarMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MenuNavigation_Activity.class));
                finish();
            }
        });


        lstStatus = new ArrayList<>();
        lstStatus.add(new ListStatus("01","02/05/2019","lorem","lorem",R.id.idRatingbar));

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.idRecyclerViewPedido);
        RecyclerViewAdapter mAdapter = new RecyclerViewAdapter(getApplicationContext(),lstStatus);
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),1));
        recyclerView.setAdapter(mAdapter);
    }

}
