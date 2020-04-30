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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class detallado extends AppCompatActivity {
    TextView nombre,descripcion,direccion;
    ImageView imagen,opinion;
    Button eliminar,regresar;
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
        regresar=findViewById(R.id.buttonRegresar);

        imagen=findViewById(R.id.imageViewImagen);
        opinion=findViewById(R.id.imageViewOpnion);

        lista=leerArchivo("JSON.txt");

        posicion=getIntent().getIntExtra("posicion",0);

        final Restaurantes elemento=lista.get(posicion);

        nombre.setText(elemento.getNomRest());
        direccion.setText(elemento.getDircyTel());
        descripcion.setText(elemento.getDesc());



        imagen.setImageResource(elemento.getImagen());
        opinion.setImageResource(elemento.getEstrellas());

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
                    case R.drawable.unae:
                        lista.get(posicion).setEstrellas(R.drawable.dose);
                        break;
                    case R.drawable.dose:
                        lista.get(posicion).setEstrellas(R.drawable.trese);
                        break;
                    case R.drawable.trese:
                        lista.get(posicion).setEstrellas(R.drawable.unae);
                        break;
                    default:
                       Toast t= Toast.makeText(v.getContext(),"ERROR",Toast.LENGTH_LONG);
                       t.show();
                }
                Intent intento=new Intent(v.getContext(),detallado.class);
                Guardar();
                startActivity(intento);
            }
        });

        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento=new Intent(v.getContext(),ListaDeRestaurantes.class);
                startActivity(intento);
            }
        });
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
