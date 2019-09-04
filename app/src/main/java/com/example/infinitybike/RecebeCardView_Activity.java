package com.example.infinitybike;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class RecebeCardView_Activity extends AppCompatActivity {

    Toolbar toolbar;

    List<ListStatus> lstStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recebe_card_view_layout);


        toolbar = (Toolbar)findViewById(R.id.idToobarForm);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");

        lstStatus = new ArrayList<>();
        lstStatus.add(new ListStatus("01","02/05/2019","lorem","lorem",R.id.idRatingbar));

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.idRecyclerViewPedido);
        RecyclerViewAdapter mAdapter = new RecyclerViewAdapter(getApplicationContext(),lstStatus);
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),1));
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_formulario,menu);
        return super.onCreateOptionsMenu(menu);
    }
}
