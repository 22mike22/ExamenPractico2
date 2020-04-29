package com.example.examenpractico2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class CapturarNuevo extends AppCompatActivity implements View.OnClickListener {

    Gson gson=new Gson();
    Restaurantes capturar;
    EditText txtNombre,txtDescr,txtDirecc;
    ArrayList<Restaurantes> BD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capturar_nuevo);
        getSupportActionBar().hide();

        txtNombre=findViewById(R.id.txtNombre);
        txtDescr=findViewById(R.id.txtDescr);
        txtDirecc=findViewById(R.id.txtDirecc);

        ImageView imgSelecionada = findViewById(R.id.imgSelect);
        imgSelecionada.setOnClickListener(this);

        Button btnGuardar=findViewById(R.id.btnGuardar);
        btnGuardar.setOnClickListener(this);

        BD = leerArchivo("JSON.txt");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imgSelect:
                //lansar actividad para elegir imagen;
                break;
            case R.id.btnGuardar:
                String nombre=txtNombre.getText().toString();
                String Descripcion=txtDescr.getText().toString();
                String Direccion=txtDirecc.getText().toString();
                if(nombre.equalsIgnoreCase("")){
                    mensaje("Añadir nombre");
                }else if(Descripcion.equalsIgnoreCase("")){
                    mensaje("Añadir descripcion");
                }else if(Direccion.equalsIgnoreCase("")){
                    mensaje("Añadir direcion");
                }else {
                    capturar = new Restaurantes(nombre, Descripcion, Direccion, R.drawable.chihuas, R.drawable.unae);
                    BD.add(capturar);
                    Guardar();
                }
                break;
        }
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
            archivo.write(gson.toJson(BD));
            archivo.flush();
            archivo.close();
            mensaje("guardado");
        } catch (IOException e) {

        }

    }
    protected void mensaje(String mensaje){
        Toast toast=Toast.makeText(this,mensaje,Toast.LENGTH_SHORT);
        toast.show();
    }
}
