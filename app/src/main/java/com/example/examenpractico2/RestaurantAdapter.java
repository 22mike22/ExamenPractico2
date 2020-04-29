package com.example.examenpractico2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class RestaurantAdapter extends ArrayAdapter<Restaurantes> {
    private ArrayList<Restaurantes> objects;
    private Context context;
    private int resource;
    public RestaurantAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Restaurantes> objects) {
        super(context,resource,objects);
        this.objects=objects;
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){ //PRIMERA VEZ QUE SE EJECUTA LA APLICACION, HAY QUE CREAR EL LAYOUT
            convertView = ((Activity)context).getLayoutInflater().inflate(resource,parent,false);
        }
        //HAY QUE RECUPERAR LOS COMPONENTES
        ImageView imgRestlyt;
        TextView txtNombreLyt;
        TextView txtDescrlyt;
        TextView txtDirecclyt;
        ImageView imgEstrellas;

        imgRestlyt = convertView.findViewById(R.id.imgRestlyt);
        txtNombreLyt = convertView.findViewById(R.id.txtNombreLyt);
        txtDescrlyt = convertView.findViewById(R.id.txtDescrlyt);
        txtDirecclyt = convertView.findViewById(R.id.txtDirecclyt);
        imgEstrellas = convertView.findViewById(R.id.imgEstrellas);


        imgRestlyt.setImageResource(objects.get(position).getImagen());
        txtNombreLyt.setText(objects.get(position).getNomRest());
        txtDescrlyt.setText(objects.get(position).getDesc());
        txtDirecclyt.setText("" + objects.get(position).getDircyTel());
        imgEstrellas.setImageResource(objects .get(position).getEstrellas());
        convertView.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent=new Intent(this,)
            }
        });

        return convertView;
    }


}
