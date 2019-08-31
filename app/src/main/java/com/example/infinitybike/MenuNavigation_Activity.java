package com.example.infinitybike;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MenuNavigation_Activity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_navigation_layout);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.idBottonNanigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.mStatus:
                        startActivity(new Intent(getApplicationContext(), RecebeCardView_Activity.class));
                        break;
                    case R.id.mAgenda:
                        startActivity(new Intent(getApplicationContext(), Agendamento_Activity.class));
                        break;
                    case R.id.mPerfil:
                        startActivity(new Intent(getApplicationContext(), PerfilUsuario_Activity.class));
                        break;
                }
                return true;
            }
        });
    }
}
