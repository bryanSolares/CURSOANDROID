package com.example.recyclerviewpersonalizado;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<PersonajeVO> listaPersonajes;
    private RecyclerView recyclerPersonajes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        construirRecycler();
    }

    private void llenarPersonajes() {

        listaPersonajes.add(new PersonajeVO("Krusty", "Información.........................", R.drawable.ic_launcher_background));
        listaPersonajes.add(new PersonajeVO("Lissa", "Información.........................", R.drawable.ic_launcher_background));
        listaPersonajes.add(new PersonajeVO("Homero", "Información.........................", R.drawable.ic_launcher_background));
        listaPersonajes.add(new PersonajeVO("Bart", "Información.........................", R.drawable.ic_launcher_background));
        listaPersonajes.add(new PersonajeVO("Smmiders", "Información.........................", R.drawable.ic_launcher_background));
        listaPersonajes.add(new PersonajeVO("Burns", "Información.........................", R.drawable.ic_launcher_background));
        listaPersonajes.add(new PersonajeVO("Krusty", "Información.........................", R.drawable.ic_launcher_background));
        listaPersonajes.add(new PersonajeVO("Lissa", "Información.........................", R.drawable.ic_launcher_background));
        listaPersonajes.add(new PersonajeVO("Homero", "Información.........................", R.drawable.ic_launcher_background));
        listaPersonajes.add(new PersonajeVO("Bart", "Información.........................", R.drawable.ic_launcher_background));
        listaPersonajes.add(new PersonajeVO("Smmiders", "Información.........................", R.drawable.ic_launcher_background));
        listaPersonajes.add(new PersonajeVO("Burns", "Información.........................", R.drawable.ic_launcher_background));

    }

    public void Accion(View view) {

        switch (view.getId()) {
            case R.id.btnList:
                Utilidades.visualizacion = Utilidades.LIST;
                break;
            case R.id.btnGrid:
                Utilidades.visualizacion = Utilidades.GRID;
                break;
        }

        construirRecycler();

    }

    private void construirRecycler() {
        listaPersonajes = new ArrayList<>();
        recyclerPersonajes = findViewById(R.id.RecyclerId);

        if (Utilidades.visualizacion == Utilidades.LIST) {
            recyclerPersonajes.setLayoutManager(new LinearLayoutManager(this));
        } else {
            recyclerPersonajes.setLayoutManager(new GridLayoutManager(this, 2));
        }

        llenarPersonajes();
        AdaptadorPersonajes adapter = new AdaptadorPersonajes(listaPersonajes);
        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Selección: " + listaPersonajes.get(recyclerPersonajes.getChildAdapterPosition(v)).getNombre(),Toast.LENGTH_LONG).show();
            }
        });
        recyclerPersonajes.setAdapter(adapter);
    }
}
