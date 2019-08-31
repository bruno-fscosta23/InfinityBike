package com.example.infinitybike;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;

public class RecebeCardView_Activity extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recebe_card_view_layout);

        toolbar = (Toolbar)findViewById(R.id.idToobarForm);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_formulario,menu);
        return super.onCreateOptionsMenu(menu);
    }
}
