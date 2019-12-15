package com.example.a50_bdsqliteenandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.a50_bdsqliteenandroid.Entidades.Usuario;

import java.util.ArrayList;

public class RegistrarMascotaActivity extends AppCompatActivity {

    private EditText nombreMascota, razaMascota;
    private Spinner listaDuenio;
    private ArrayList<String> listaPersonas;
    private ArrayList<Usuario> listaUsuarios;
    private ConexionSQLiteHelper conexion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrar_mascota_activity);

        nombreMascota = findViewById(R.id.nombreMascota);
        razaMascota = findViewById(R.id.razaMascota);
        listaDuenio = findViewById(R.id.listaDuenio);

    }

    public void Evento(View view) {

    }
}
