package com.example.examenpractico2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class detallado extends AppCompatActivity {
    TextView nombre,descripcion,direccion;
    ImageView imagen,opinion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detallado);
        getSupportActionBar().hide();

        nombre=findViewById(R.id.textViewNombre);
        descripcion=findViewById(R.id.textViewDescripcion);
        direccion=findViewById(R.id.textViewDirecion);

        imagen=findViewById(R.id.imageViewImagen);
        opinion=findViewById(R.id.imageViewOpnion);

    }
}
