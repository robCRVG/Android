package br.com.provaandroid.activitys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import br.com.provaandroid.R;

public class Alvaras extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alvaras);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.item_alvaras);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.item_pessoa:
                        startActivity(new Intent(getApplicationContext(), DadosCliente.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.item_alvaras:
                        return true;
                    case R.id.item_historico_pedidos:
                        startActivity(new Intent(getApplicationContext(), HistoricoPedidos.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }
}