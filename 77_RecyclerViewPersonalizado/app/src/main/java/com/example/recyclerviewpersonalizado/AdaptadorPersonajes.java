package com.example.recyclerviewpersonalizado;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AdaptadorPersonajes extends RecyclerView.Adapter<AdaptadorPersonajes.HolderPersonajes> implements View.OnClickListener {

    private List<PersonajeVO> listaPersonajes;
    private View.OnClickListener listener;

    public AdaptadorPersonajes(List<PersonajeVO> listaPersonajes) {
        this.listaPersonajes = listaPersonajes;
    }

    @NonNull
    @Override
    public HolderPersonajes onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        int layout = 0;
        if (Utilidades.visualizacion == Utilidades.LIST) {
            layout = R.layout.item_list_personaje;
        } else {
            layout = R.layout.item_grid_personaje;
        }

        View view = LayoutInflater.from(parent.getContext()).inflate(layout, null, false);

        view.setOnClickListener(this);

        return new HolderPersonajes(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderPersonajes holder, int position) {
        holder.nombre.setText(listaPersonajes.get(position).getNombre());

        if (Utilidades.visualizacion == Utilidades.LIST)
            holder.informacion.setText(listaPersonajes.get(position).getInfo());
        holder.foto.setImageResource(listaPersonajes.get(position).getFoto());
    }

    @Override
    public int getItemCount() {
        return listaPersonajes.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if (listener != null)
            listener.onClick(v);
    }

    public class HolderPersonajes extends RecyclerView.ViewHolder {

        TextView nombre, informacion;
        ImageView foto;

        public HolderPersonajes(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.idNombre);
            if (Utilidades.visualizacion == Utilidades.LIST)
                informacion = itemView.findViewById(R.id.idInformacion);
            foto = itemView.findViewById(R.id.idImagen);
        }
    }
}
