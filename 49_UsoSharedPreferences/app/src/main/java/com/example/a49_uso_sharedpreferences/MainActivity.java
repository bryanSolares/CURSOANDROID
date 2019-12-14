package com.example.a49_uso_sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static android.content.Context.MODE_PRIVATE;

public class MainActivity extends AppCompatActivity {

    private EditText campousuario, campocontra;
    private TextView textousuario, textocontra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campousuario = findViewById(R.id.campoUsuario);
        campocontra = findViewById(R.id.campoContra);
        textousuario = findViewById(R.id.textUsurio);
        textocontra = findViewById(R.id.txtContra);

        cargarPreferencias();
    }



    public void evento(View view) {

        switch(view.getId()){
            case R.id.guardar:
                guardarPreferencias();
                break;
            case R.id.cargar:
                Intent intencion = new Intent(this, Resultado.class);
                startActivity(intencion);
                break;
        }

    }

    private void cargarPreferencias() {
        SharedPreferences preferences = getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        String usuario = preferences.getString("user","No existe la información");
        String pass = preferences.getString("pass","No existe la información");

        textousuario.setText(usuario);
        textocontra.setText(pass);
    }

    private void guardarPreferencias(){
        SharedPreferences preferencias = getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        String usuario = campousuario.getText().toString();
        String pass = campocontra.getText().toString();

        SharedPreferences.Editor editor = preferencias.edit();
        editor.putString("user",usuario);
        editor.putString("pass", pass);

        textousuario.setText(usuario);
        textocontra.setText(pass);

        editor.commit();

    }
}
