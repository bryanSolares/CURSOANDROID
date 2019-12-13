package com.example.a46_landscapeyportrait;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class saludos extends AppCompatActivity {

    TextView recepcionRespuesta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saludos);

        recepcionRespuesta = findViewById(R.id.recepcionRespuesta);

        Bundle bundle = this.getIntent().getExtras();

        if (bundle!=null){
            recepcionRespuesta.setText("Hola Bienvenido un Saludo: " + bundle.getString("saludo"));
        }
    }

    public void Evento(View view) {
        finish();
    }
}
