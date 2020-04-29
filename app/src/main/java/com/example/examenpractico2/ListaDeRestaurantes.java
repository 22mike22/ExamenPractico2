package com.example.examenpractico2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ListaDeRestaurantes extends AppCompatActivity {

    ListView lstRes;
    /*Restaurantes[] rest2={
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
    };*/

    ArrayList<Restaurantes> rest=new ArrayList();
    Gson gson=new Gson();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_restaurantes);

        rest=leerArchivo("JSON.txt");

        lstRes=findViewById(R.id.lstRes);
        lstRes.setAdapter((ListAdapter) new RestaurantAdapter(this, R.layout.activity_lista_de_restaurantes,rest));

        lstRes.setClickable(true);
        lstRes.getOnItemClickListener();

    }

    protected void onDestroy() {

        super.onDestroy();
    }

    protected void mensaje(String mensaje){
        Toast toast=Toast.makeText(this,mensaje,Toast.LENGTH_SHORT);
        toast.show();
    }

    private ArrayList<Restaurantes> leerArchivo(String nombre){
        String archivos[]=fileList();
        if(ArchivoExiste(archivos,nombre)){
            try {
                InputStreamReader archivo = new InputStreamReader(openFileInput(nombre));
                BufferedReader br = new BufferedReader(archivo);
                String linea=br.readLine();
                String JSON="";

                while(linea!=null){
                    JSON+=linea+"\n";
                    linea=br.readLine();
                }
                br.close();
                archivo.close();
                return gson.fromJson(JSON,new TypeToken<ArrayList<Restaurantes>>(){}.getType());

            }catch(IOException e){
                return new ArrayList<Restaurantes>();
            }
        }
        return new ArrayList<Restaurantes>();
    }

    private boolean ArchivoExiste(String archivos[],String nombreArchivo){
        for(int i=0;i<archivos.length;i++)
            if(nombreArchivo.equals(archivos[i]))
                return true;
        return false;
    }





}
