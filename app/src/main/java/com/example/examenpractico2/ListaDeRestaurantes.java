package com.example.examenpractico2;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ListaDeRestaurantes extends AppCompatActivity {

    ListView lstRes;

    ArrayList<Restaurantes> rest = new ArrayList();
    Gson gson = new Gson();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_restaurantes);
        getSupportActionBar().hide();
        rest = leerArchivo("JSON.txt");

        lstRes = findViewById(R.id.lstRes);

        lstRes.setAdapter(new RestaurantAdapter(this, R.layout.activity_lista_de_restaurantes, rest));

        lstRes.setClickable(true);
        lstRes.getOnItemClickListener();

    }
    protected void onResume() {
        super.onResume();
        rest=leerArchivo("JSON.txt");
        lstRes.setAdapter(new RestaurantAdapter(this, R.layout.activity_lista_de_restaurantes, rest));
    }

    protected void onDestroy() {

        super.onDestroy();

        lstRes.setAdapter(new RestaurantAdapter(this, R.layout.activity_lista_de_restaurantes, rest));

    }

    protected void mensaje(String mensaje) {
        Toast toast = Toast.makeText(this, mensaje, Toast.LENGTH_SHORT);
        toast.show();
    }

    private ArrayList<Restaurantes> leerArchivo(String nombre) {
        String archivos[] = fileList();
        if (ArchivoExiste(archivos, nombre)) {
            try {
                InputStreamReader archivo = new InputStreamReader(openFileInput(nombre));
                BufferedReader br = new BufferedReader(archivo);
                String linea = br.readLine();
                String JSON = "";

                while (linea != null) {
                    JSON += linea + "\n";
                    linea = br.readLine();
                }
                br.close();
                archivo.close();
                return gson.fromJson(JSON, new TypeToken<ArrayList<Restaurantes>>() {
                }.getType());

            } catch (IOException e) {
                return new ArrayList<Restaurantes>();
            }
        }
        return new ArrayList<Restaurantes>();
    }

    private boolean ArchivoExiste(String archivos[], String nombreArchivo) {
        for (int i = 0; i < archivos.length; i++)
            if (nombreArchivo.equals(archivos[i]))
                return true;
        return false;
    }


}
