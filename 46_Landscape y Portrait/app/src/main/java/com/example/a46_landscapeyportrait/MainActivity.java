package com.example.a46_landscapeyportrait;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView resultado;
    private EditText textoNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultado = findViewById(R.id.resultado);
        textoNombre = findViewById(R.id.textoNombre);
    }

    public void Evento(View view) {
        if(view.getId()==R.id.btnIngresar){
            resultado.setText("Hola Bienvenido " + textoNombre.getText().toString());
        }else if(view.getId()==R.id.btnEnviar){
            Intent intecion = new Intent(MainActivity.this,saludos.class);
            Bundle miBundle = new Bundle();
            miBundle.putString("saludo",textoNombre.getText().toString());
            intecion.putExtras(miBundle);
            startActivity(intecion);
        }
    }
}
