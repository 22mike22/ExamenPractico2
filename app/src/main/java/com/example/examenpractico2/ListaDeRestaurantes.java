package com.example.examenpractico2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

public class ListaDeRestaurantes extends AppCompatActivity {

    ListView lstRes;
    Restaurantes[] rest={
            new Restaurantes("La Junta", "Antojería informal y sencilla que se especializa en tacos y montados, con amplia barra de verduras y salsas."
                    , "5542661", R.drawable.lajunta,R.drawable.dose),
            new Restaurantes("Poeta", ""
                    , "5542661", R.drawable.poeta,R.drawable.dose),
            new Restaurantes("El Papalote", ""
                    , "5542661", R.drawable.elpapalote,R.drawable.trese),
            new Restaurantes("El Rodeo", ""
                    , "5542661", R.drawable.rodeo,R.drawable.unae),
            new Restaurantes("Chihua tacos", ""
                    , "5542661", R.drawable.chihuas,R.drawable.trese)
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_de_restaurantes);
        lstRes=findViewById(R.id.lstRes);
        lstRes.setAdapter((ListAdapter) new RestaurantAdapter(this, R.layout.activity_lista_de_restaurantes,rest));
    }




}
