package br.com.provaandroid.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import br.com.provaandroid.R;
import br.com.provaandroid.entities.Cliente;
import br.com.provaandroid.util.Uteis;

public class DadosCliente extends AppCompatActivity {

    private static final String titleDadosCliente = "Dados do cliente";
    private Button btnStatusCliente;
    private Snackbar snackbar;
    Uteis uteis = new Uteis();
    ArrayList<String> numberList = new ArrayList<>();
    Cliente cliente = new Cliente();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_cliente);
        setTitle(titleDadosCliente);
        inicializaCampos();
        verificaStatus();

    }

    private void inicializaCampos() {
        btnStatusCliente = findViewById(R.id.btnStatusCliente);
    }

    private void verificaStatus() {
        btnStatusCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getJson();
                snackbar = Snackbar.make(btnStatusCliente, uteis.pegaDataHora() + " - Status " + cliente.getStatus(), Snackbar.LENGTH_INDEFINITE);
                snackbar.setAction("FECHAR", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                    }
                }).show();
                snackbar.show();
            }
        });
    }

    public void getJson() {
        String json = "";
        try {
            InputStream inputStream = getAssets().open("clientes.json");
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while (line != null) {
                line = bufferedReader.readLine();
                json = json + line;
            }

            JSONObject jsonObject = new JSONObject(json);
            JSONObject listaObjeto = jsonObject.getJSONObject("cliente");
            cliente.setStatus(listaObjeto.getString("status"));

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}