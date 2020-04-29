package com.example.examenpractico2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ListaDeRestaurantes extends AppCompatActivity {

    ListView lstRes;
    Restaurantes[] rest={
            new Restaurantes("La Junta", "Antojería informal y sencilla que se especializa en tacos y montados, con amplia barra de verduras y salsas."
                    , "5542661", R.drawable.lajunta,R.drawable.dose),
            new Restaurantes("La Junta", "Antojería informal y sencilla que se especializa en tacos y montados, con amplia barra de verduras y salsas."
                    , "5542661", R.drawable.poeta,R.drawable.dose),
            new Restaurantes("La Junta", "Antojería informal y sencilla que se especializa en tacos y montados, con amplia barra de verduras y salsas."
                    , "5542661", R.drawable.elpapalote,R.drawable.trese),
            new Restaurantes("La Junta", "Antojería informal y sencilla que se especializa en tacos y montados, con amplia barra de verduras y salsas."
                    , "5542661", R.drawable.rodeo,R.drawable.unae),
            new Restaurantes("La Junta", "Antojería informal y sencilla que se especializa en tacos y montados, con amplia barra de verduras y salsas."
                    , "5542661", R.drawable.chihuas,R.drawable.trese)
    };
    ArrayList estrellas=new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_restaurantes);

        String archivos[]=fileList();

        if(ArchivoExiste(archivos,"json.txt")){
            try {
                InputStreamReader archivo = new InputStreamReader(openFileInput("json.txt"));
                BufferedReader br = new BufferedReader(archivo);
                String linea=br.readLine();
                String JSON="";

                while(linea!=null){
                    JSON+=linea+"\n";
                    linea=br.readLine();
                }
                br.close();
                archivo.close();

            }catch(IOException e){

            }
        }

        estrellas.add(R.drawable.unae);
        estrellas.add(R.drawable.dose);
        estrellas.add(R.drawable.trese);

        lstRes=findViewById(R.id.lstRes);
        lstRes.setAdapter((ListAdapter) new RestaurantAdapter(this, R.layout.activity_lista_de_restaurantes,rest));
    }

    protected void onDestroy() {

        super.onDestroy();
    }

    protected void mensaje(String mensaje){
        Toast toast=Toast.makeText(this,mensaje,Toast.LENGTH_SHORT);
        toast.show();
    }





}
