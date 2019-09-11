package com.example.infinitybike;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MenuNavigation_Activity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    Toolbar toolbar;
    List<ListMenu> lstMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_navigation_layout);

        toolbar = (Toolbar)findViewById(R.id.idToobarMenu);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");




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
                        startActivity(new Intent(getApplicationContext(), Login_Activity.class));
                        break;
                }
                return true;
            }
        });

        lstMenu = new ArrayList<>();
        lstMenu.add(new ListMenu("BRASIL","Greve de ônibus em SP: aplicativos oferecem descontos e bicicleta grátis","6 set 2019, 09h18",R.drawable.imgbike));
        lstMenu.add(new ListMenu("TECNOLOGIA","Bicicletas elétricas de rival da Uber estão pegando fogo nos EUA","1 ago 2019, 15h38",R.drawable.imgbikedois));
        lstMenu.add(new ListMenu("PME","Fabricante de bike elétrica é primeira a instalar pontos de recarga em SP","5 jul 2019, 06h30",R.drawable.imgbiketres));
        lstMenu.add(new ListMenu("BRASIL","Uso de bicicletas aumenta 24% em SP, puxado por ciclovias na zona oeste","3 jul 2019, 12h31",R.drawable.imgbikequartro));


        RecyclerView mRecycle = (RecyclerView)findViewById(R.id.idRecycleMenu);
        MenuAdapter mAdapter = new MenuAdapter(getApplicationContext(),lstMenu);
        mRecycle.setLayoutManager(new GridLayoutManager(getApplicationContext(),1));
        mRecycle.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_sair,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.mEntrar){
            startActivity(new Intent(getApplicationContext(),Login_Activity.class));
            finish();
            return true;
        }
        if (id == R.id.mSair){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
