package br.com.provaandroid.util;

import android.content.res.AssetManager;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.provaandroid.entities.Cliente;

public class Uteis {

    private Cliente cliente;

    public String pegaDataHora() {

        //Devido ao baixo nível da minha sdk vou ter que utilizar a classe Date ao invés da Classe Instant
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

}
