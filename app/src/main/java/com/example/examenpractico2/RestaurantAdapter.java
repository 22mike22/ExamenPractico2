package com.example.examenpractico2;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class RestaurantAdapter extends ArrayAdapter<Restaurantes> {
    private Restaurantes[] objects;
    private Context context;
    private int resource;
    public RestaurantAdapter(@NonNull Context context, int resource, @NonNull Restaurantes[] objects) {
        super(context,resource,objects);
        this.objects=objects;
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
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


        imgRestlyt.setImageResource(objects[position].getImagen());
        txtNombreLyt.setText(objects[position].getNomRest());
        txtDescrlyt.setText(objects[position].getDesc());
        txtDirecclyt.setText("" + objects[position].getDircyTel());
        imgEstrellas.setImageResource(objects [position].getEstrellas());
        return convertView;
    }
}
