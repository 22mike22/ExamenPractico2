package com.example.examenpractico2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.picasso.Picasso;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class detallado extends AppCompatActivity {
    TextView nombre,descripcion,direccion;
    ImageView imagen,opinion;
    Button eliminar;
    Gson gson=new Gson();
    int posicion;
    ArrayList<Restaurantes> lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detallado);
        getSupportActionBar().hide();

        nombre=findViewById(R.id.textViewNombre);
        descripcion=findViewById(R.id.textViewDescripcion);
        direccion=findViewById(R.id.textViewDirecion);

        eliminar=findViewById(R.id.botonBorrar);

        imagen=findViewById(R.id.imageViewImagen);
        opinion=findViewById(R.id.imageViewOpnion);

        lista=leerArchivo("JSON.txt");

        posicion=getIntent().getIntExtra("posicion",0);

        final Restaurantes elemento=lista.get(posicion);

        nombre.setText(elemento.getNomRest());
        direccion.setText(elemento.getDircyTel());
        descripcion.setText(elemento.getDesc());

        recargarImagen();
        Picasso.get().load(lista.get(posicion).getImagen()).resize(255,255).into(imagen);

        eliminar.setOnClickListener(new View.OnClickListener(){
           public void onClick(View v){
               lista.remove(posicion);
               Guardar();
               Intent intento=new Intent(v.getContext(),MainActivity.class);
               startActivity(intento);
           }
        });

        opinion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (lista.get(posicion).getEstrellas()){
                    case R.drawable.estrella1:
                        lista.get(posicion).setEstrellas(R.drawable.estrella2);
                        break;
                    case R.drawable.estrella2:
                        lista.get(posicion).setEstrellas(R.drawable.estrella3);
                        break;
                    case R.drawable.estrella3:
                        lista.get(posicion).setEstrellas(R.drawable.estrella1);
                        break;
                    default:
                       Toast t= Toast.makeText(v.getContext(),"ERROR",Toast.LENGTH_LONG);
                       t.show();
                }
                recargarImagen();
                Guardar();
            }
        });


    }

    private void recargarImagen(){
        Picasso.get().load(lista.get(posicion).getEstrellas()).resize(255,255).into(opinion);
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
    public void Guardar() {
        try{
            OutputStreamWriter archivo = new OutputStreamWriter(openFileOutput("JSON.txt", Activity.MODE_PRIVATE));
            archivo.write(gson.toJson(lista));
            archivo.flush();
            archivo.close();
        } catch (IOException e) {

        }

    }

}
