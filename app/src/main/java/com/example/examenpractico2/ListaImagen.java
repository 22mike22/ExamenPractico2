package com.example.examenpractico2;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ListaImagen extends AppCompatActivity {

    ListView lstImagen;
    Imagenes[] img={new Imagenes(R.drawable.rest1), new Imagenes(R.drawable.rest2),
            new Imagenes(R.drawable.rest3)};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_imagen);

        lstImagen=findViewById(R.id.lstImagen);

        lstImagen.setAdapter(new ImagenesAdapter(this, R.layout.imagen,img));
    }


}
