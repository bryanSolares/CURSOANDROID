package com.example.a50_bdsqliteenandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Spinner;
import android.widget.TextView;

public class ConsultaComboUsuario extends AppCompatActivity {

    private Spinner comboUsuarios;
    private TextView usuarioDocumento, usuarioNombre, usuarioTelefono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.consulta_combo_usuario_activity);

        comboUsuarios = findViewById(R.id.comboUsuarios);
        usuarioDocumento = findViewById(R.id.usuarioDocumento);
        usuarioNombre = findViewById(R.id.usuarioNombre);
        usuarioTelefono = findViewById(R.id.usuarioTelefono);
    }
 }
