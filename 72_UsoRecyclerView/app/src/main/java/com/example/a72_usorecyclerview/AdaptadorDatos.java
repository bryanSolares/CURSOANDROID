package com.example.a72_usorecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

//ViewHolder representa cada elemento que se encuentra en un RecyclerView
public class AdaptadorDatos extends RecyclerView.Adapter<AdaptadorDatos.viewHolderDatos> {


    public static class viewHolderDatos extends RecyclerView.ViewHolder {

        public TextView vista;

        public viewHolderDatos(@NonNull View itemView) {
            super(itemView);
            vista = itemView.findViewById(R.id.dato);
        }
    }




    private ArrayList<String> datos;

    public AdaptadorDatos(ArrayList<String> datos) {
        this.datos = datos;
    }

    //Enzala adaptador con archivo item_list
    @NonNull
    @Override
    public viewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
        return new viewHolderDatos(view);
    }

    //comunicación entre adaptador y clase viewholderdatos
    @Override
    public void onBindViewHolder(@NonNull viewHolderDatos holder, int position) {
        holder.vista.setText(datos.get(position));

    }


    @Override
    public int getItemCount() {
        return datos.size();
    }


}
