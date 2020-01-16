package com.example.patromaestrodetalle.Adaptadores;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.patromaestrodetalle.Entidades.PersonajeVO;
import com.example.patromaestrodetalle.R;

import java.util.List;

public class AdaptadorPersonaje extends RecyclerView.Adapter<AdaptadorPersonaje.PersonajeViewHolder> implements View.OnClickListener {

    private List<PersonajeVO> lista;
    private View.OnClickListener listener;

    public AdaptadorPersonaje(@NonNull List<PersonajeVO> lista) {
        this.lista = lista;
    }

    @NonNull
    @Override
    public PersonajeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,null,false);
        view.setOnClickListener(this);
        return new PersonajeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonajeViewHolder holder, int position) {
        Log.e("Error: " ,lista.get(position).getNombre());
        holder.itemNombre.setText(lista.get(position).getNombre());
        holder.itemDescripcion.setText(lista.get(position).getDescripcion());
        holder.itemImagen.setImageResource(lista.get(position).getImagen());
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if(listener != null)
            listener.onClick(v);
    }

    public class PersonajeViewHolder extends RecyclerView.ViewHolder {

        TextView itemNombre, itemDescripcion;
        ImageView itemImagen;

        public PersonajeViewHolder(@NonNull View itemView) {
            super(itemView);
            itemNombre =itemView.findViewById(R.id.itemNombre);
            itemDescripcion =itemView.findViewById(R.id.itemDescripcion);
            itemImagen =itemView.findViewById(R.id.itemImagen);
        }
    }
}
