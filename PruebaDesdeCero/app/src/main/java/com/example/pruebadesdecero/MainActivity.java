package com.example.pruebadesdecero;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText nombre;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = (EditText) findViewById(R.id.nombre);
        resultado = (TextView) findViewById(R.id.resultado);
    }

    public void accionEvento(View view) {
        if(nombre.getText().toString().equals("")){
            Toast.makeText(this,"No puede dejar vacio el campo",Toast.LENGTH_LONG).show();
        }else{
            resultado.setText("Bienvenido: " + nombre.getText().toString());
        }
    }
}
