package br.com.provaandroid.activitys;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.snackbar.Snackbar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;

import br.com.provaandroid.R;
import br.com.provaandroid.entities.Cliente;
import br.com.provaandroid.entities.Contato;
import br.com.provaandroid.util.Uteis;

public class DadosCliente extends AppCompatActivity {
    private static final String titleDadosCliente = "Dados do cliente";
    private Button btnStatusCliente;
    private Snackbar snackbar;
    private BottomNavigationView bottomNavigationView;
    private TextView tvTelaDadosCliente, tvTelaClienteCodigo, tvTelaClienteRazaoSocial, tvTelaClienteNomeFantasia, tvTelaClienteCnpj, tvTelaClienteRamoAtividade, tvTelaClienteEndereco;
    private TextView tvTelaDadosContato, tvNomeContato, tvTelaClienteTelefone, tvTelaClienteEmail, tvTelaClienteCelular, tvTelaClienteDtNascimento, tvTelaClienteConjuge, tvTelaClienteDtnConjuge, tvTelaClienteTipo, tvTelaClienteTime;
    private Uteis uteis = new Uteis();
    private ArrayList<String> numberList = new ArrayList<>();
    private Cliente cliente = new Cliente();
    private Contato contato = new Contato();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_cliente);
        setTitle(titleDadosCliente);
        inicializaCampos();
        getJson();
        verificaStatus();
        mostraDados();
        navButtomNavigation();
    }

    private void navButtomNavigation() {
        bottomNavigationView.setSelectedItemId(R.id.item_pessoa);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.item_historico_pedidos:
                        startActivity(new Intent(getApplicationContext(), HistoricoPedidos.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.item_pessoa:
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

    private void mostraDados() {
        tvTelaClienteCodigo.setText(cliente.getCodigo() + " -");
        tvTelaClienteRazaoSocial.setText(cliente.getRazao_social());
        tvTelaClienteNomeFantasia.setText(cliente.getNomefantasia());
        tvTelaClienteCnpj.setText("CNPJ: " + cliente.getCnpj());
        tvTelaClienteRamoAtividade.setText("Ramo de atividade: " + cliente.getRamo_atividade());
        tvTelaClienteEndereco.setText("Endereço: " + cliente.getEndereco());
        tvNomeContato.setText(contato.getNome());
        tvTelaClienteTelefone.setText("Telefone: " + contato.getTelefone());
        tvTelaClienteEmail.setText("E-mail: " + contato.getE_mail());
        tvTelaClienteCelular.setText("Celular: " + contato.getCelular());
        tvTelaClienteDtNascimento.setText("Data Nasc.: " + contato.getData_nascimento());
        tvTelaClienteConjuge.setText("Cônjuge: " + contato.getConjuge());
        tvTelaClienteDtnConjuge.setText("Data Nasc. Cônjuge: " + contato.getDataNascimentoConjuge());
        tvTelaClienteTipo.setText("Tipo: " + contato.getTipo());
        tvTelaClienteTime.setText("Time: " + contato.getTime());
    }

    private void inicializaCampos() {
        Typeface font = Typeface.createFromAsset(getAssets(), "Santral-ExtraBold.ttf");
        tvTelaDadosCliente = findViewById(R.id.tvDadosCliente);
        tvTelaDadosCliente.setTypeface(font);
        tvTelaClienteCodigo = findViewById(R.id.tvTelaClienteCodigo);
        tvTelaClienteRazaoSocial = findViewById(R.id.tvTelaClienteRazaoSocial);
        tvTelaClienteNomeFantasia = findViewById(R.id.tvTelaClienteNomeFantasia);
        tvTelaClienteCnpj = findViewById(R.id.tvTelaClienteCnpj);
        tvTelaClienteRamoAtividade = findViewById(R.id.tvTelaClienteRamoAtividade);
        tvTelaClienteEndereco = findViewById(R.id.tvTelaClienteEndereco);
        tvTelaDadosContato = findViewById(R.id.tvDadosContatos);
        tvTelaDadosContato.setTypeface(font);
        tvNomeContato = findViewById(R.id.tvNomeContato);
        tvTelaClienteTelefone = findViewById(R.id.tvTelaClienteTelefone);
        tvTelaClienteEmail = findViewById(R.id.tvTelaClienteEmail);
        tvTelaClienteCelular = findViewById(R.id.tvTelaClienteCelular);
        tvTelaClienteDtNascimento = findViewById(R.id.tvTelaClienteDtNascimento);
        tvTelaClienteConjuge = findViewById(R.id.tvTelaClienteConjuge);
        tvTelaClienteDtnConjuge = findViewById(R.id.tvTelaClienteDtnConjuge);
        tvTelaClienteTipo = findViewById(R.id.tvTelaClienteTipo);
        tvTelaClienteTime = findViewById(R.id.tvTelaClienteTime);
        btnStatusCliente = findViewById(R.id.btnStatusCliente);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
    }

    private void verificaStatus() {
        btnStatusCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
        JSONObject jsonContatos;
        String json = null;
        try {
            InputStream inputStream = this.getAssets().open("json/clientes.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer, "UTF-8");
            JSONObject jsonObject = new JSONObject(json);
            JSONObject objCliente = jsonObject.getJSONObject("cliente");
            setClienteObject(objCliente);
            JSONArray jsonArray = objCliente.getJSONArray("contatos");
            setContatosObject(jsonArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setContatosObject(JSONArray jsonArray) throws JSONException {
        JSONObject jsonContatos;
        for (int i = 0; i <= jsonArray.length(); i++) {
            jsonContatos = jsonArray.getJSONObject(i);
            contato.setNome(jsonContatos.getString("nome"));
            contato.setTelefone(jsonContatos.getString("telefone"));
            contato.setCelular(jsonContatos.getString("celular"));
            contato.setConjuge(jsonContatos.getString("conjuge"));
            contato.setTipo(jsonContatos.getString("tipo"));
            contato.setTime(jsonContatos.getString("time"));
            contato.setE_mail(jsonContatos.getString("e_mail"));
            contato.setData_nascimento(jsonContatos.getString("data_nascimento"));
            contato.setDataNascimentoConjuge(jsonContatos.getString("dataNascimentoConjuge"));
        }
    }

    private void setClienteObject(JSONObject objCliente) throws JSONException {
        //            cliente.setId(jsonObject.getString("id"));
        cliente.setCodigo(objCliente.getString("codigo"));
        cliente.setRazao_social(objCliente.getString("razao_social"));
        cliente.setNomefantasia(objCliente.getString("nomeFantasia"));
        cliente.setCnpj(objCliente.getString("cnpj"));
        cliente.setRamo_atividade(objCliente.getString("ramo_atividade"));
        cliente.setEndereco(objCliente.getString("endereco"));
        cliente.setStatus(objCliente.getString("status"));
    }

}