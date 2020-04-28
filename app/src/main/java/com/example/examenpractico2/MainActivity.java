package com.example.examenpractico2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Intent intCapt, intMostrar;
    Button btnCapt,btnMostrar,btnSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCapt=findViewById(R.id.btnCapturar);
        btnMostrar=findViewById(R.id.btnMostrar);
        btnSalir=findViewById(R.id.btnSalir);
    }

    public void onClickCapturar(View v){
        intCapt = new Intent(this,CapturarNuevo.class);
        startActivity(intCapt);
    }

    public void onClickSalir(View v){
        onDestroy();
    }

    public void inClickMostrar(View v){
        intMostrar= new Intent(this, ListaDeRestaurantes.class);
        startActivity(intMostrar);
    }
}
