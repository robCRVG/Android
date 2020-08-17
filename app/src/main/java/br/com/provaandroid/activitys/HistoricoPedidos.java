package br.com.provaandroid.activitys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;

import br.com.provaandroid.R;
import br.com.provaandroid.entities.HcPedidos;

public class HistoricoPedidos extends AppCompatActivity {
    private ListView listView;
    private ArrayList<String> arrayList = new ArrayList<>();
    private ArrayAdapter<String> arrayAdapter;
    private HcPedidos hcPedidos = new HcPedidos();
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico_pedidos);
        inicializaCampos();
        getJson();
        navButtomNavigation(bottomNavigationView);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    private void getJson() {
        JSONObject jsonPedidos;
        String json;
        try {
            InputStream inputStream = this.getAssets().open("json/pedidos.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer, "UTF-8");
            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.getJSONArray("pedidos");
            for (int i = 0; i <= jsonArray.length(); i++) {
                jsonPedidos = jsonArray.getJSONObject(i);
                hcPedidos.setNumero_ped_Rca(jsonPedidos.getString("numero_ped_Rca"));
                hcPedidos.setNumero_ped_erp(jsonPedidos.getString("numero_ped_erp"));
                hcPedidos.setCodigoCliente(jsonPedidos.getString("codigoCliente"));
                hcPedidos.setNOMECLIENTE(jsonPedidos.getString("NOMECLIENTE"));
                hcPedidos.setData(jsonPedidos.getString("data"));
                hcPedidos.setStatus(jsonPedidos.getString("status"));
                if(jsonPedidos.equals("critica")){
                    hcPedidos.setCritica(jsonPedidos.getString("critica"));
                }else{

                }
                hcPedidos.setTipo(jsonPedidos.getString("tipo"));
                if(jsonPedidos.equals("legendas")) {
                    hcPedidos.setLegendas(jsonPedidos.getString("legendas"));
                }
                String aux = hcPedidos.toString();
                arrayList.add(aux);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(arrayAdapter);
    }

    private void inicializaCampos() {
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        listView = findViewById(R.id.listViewPedidos);
    }

    private void navButtomNavigation(BottomNavigationView bottomNavigationView) {
        bottomNavigationView.setSelectedItemId(R.id.item_historico_pedidos);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.item_pessoa:
                        startActivity(new Intent(getApplicationContext(), DadosCliente.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.item_historico_pedidos:
                        return true;
                    case R.id.item_alvaras:
                        startActivity(new Intent(getApplicationContext(), Alvaras.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });
    }

//    @SuppressLint("ResourceType")
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.id.legenda, menu);
//        return true;
//    }
}