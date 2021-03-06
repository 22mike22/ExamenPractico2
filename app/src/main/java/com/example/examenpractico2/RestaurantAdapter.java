package com.example.examenpractico2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RestaurantAdapter extends ArrayAdapter<Restaurantes> {
    private ArrayList<Restaurantes> objects;
    private Context context;
    private int resource;

    public RestaurantAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Restaurantes> objects) {
        super(context, resource, objects);
        this.objects = objects;
        this.context = context;
        this.resource = resource;
    }


    @NonNull
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) { //PRIMERA VEZ QUE SE EJECUTA LA APLICACION, HAY QUE CREAR EL LAYOUT
            convertView = ((Activity) context).getLayoutInflater().inflate(resource, parent, false);
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


        Picasso.get().load(objects.get(position).getImagen()).resize(255,255).into(imgRestlyt);
        txtNombreLyt.setText(objects.get(position).getNomRest());
        txtDescrlyt.setText(objects.get(position).getDesc());
        txtDirecclyt.setText("" + objects.get(position).getDircyTel());
        Picasso.get().load(objects.get(position).getEstrellas()).resize(255,255).into(imgEstrellas);
        convertView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(context, detallado.class);
                intent.putExtra("posicion", position);
                context.startActivity(intent);
            }
        });

        return convertView;
    }


}
