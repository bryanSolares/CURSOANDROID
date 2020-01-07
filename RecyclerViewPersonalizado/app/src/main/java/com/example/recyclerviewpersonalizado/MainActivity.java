package com.example.recyclerviewpersonalizado;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<PersonajeVO> listaPersonajes;
    private RecyclerView recyclerPersonajes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaPersonajes = new ArrayList<>();
        recyclerPersonajes = findViewById(R.id.RecyclerId);
        recyclerPersonajes.setLayoutManager(new LinearLayoutManager(this));

        llenarPersonajes();

        AdaptadorPersonajes adapter = new AdaptadorPersonajes(listaPersonajes);
        recyclerPersonajes.setAdapter(adapter);
    }

    private void llenarPersonajes() {

        listaPersonajes.add(new PersonajeVO("Krusty","Información.........................",R.drawable.ic_launcher_background));
        listaPersonajes.add(new PersonajeVO("Lissa","Información.........................",R.drawable.ic_launcher_background));
        listaPersonajes.add(new PersonajeVO("Homero","Información.........................",R.drawable.ic_launcher_background));
        listaPersonajes.add(new PersonajeVO("Bart","Información.........................",R.drawable.ic_launcher_background));
        listaPersonajes.add(new PersonajeVO("Smmiders","Información.........................",R.drawable.ic_launcher_background));
        listaPersonajes.add(new PersonajeVO("Burns","Información.........................",R.drawable.ic_launcher_background));

    }
}
