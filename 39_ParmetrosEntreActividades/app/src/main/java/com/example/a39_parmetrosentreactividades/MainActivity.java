package com.example.a39_parmetrosentreactividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

    public void Accion(View view) {

        String nom;
        Intent intencion;
        Bundle bundle;

        switch (view.getId()){
            case R.id.ingresar:
                nom = nombre.getText().toString();
                resultado.setText(getString(R.string.mensajeGlobal) + nom);
                Toast.makeText(this, "El nombre ingresado es: " + nom, Toast.LENGTH_LONG).show();
                break;

            case R.id.enviar:
                intencion = new Intent(MainActivity.this,MensajeActivity.class);
                bundle = new Bundle();
                bundle.putString("nombre",nombre.getText().toString());
                intencion.putExtras(bundle);
                startActivity(intencion);

                break;
        }
    }
}
