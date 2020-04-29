package com.example.examenpractico2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class CapturarNuevo extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capturar_nuevo);
        ImageView imgSelecionada=findViewById(R.id.imgSelect);
        imgSelecionada.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imgSelect:
                //lansar actividad para elegir imagen;
                break;
        }
    }
}
