package com.example.tarea_ciclodevidaactivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView contador;
    private static int cont = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contador = findViewById(R.id.contador);

        if (savedInstanceState != null) {
            cont = savedInstanceState.getInt("estado");
            contador.setText("" + cont);
        }
    }

    public void Accion(View view) {
        if (view.getId() == R.id.incrementador) {
            cont = Integer.parseInt(contador.getText().toString());
            cont++;

        } else if (view.getId() == R.id.reseteador) {
            cont = 0;
        }

        contador.setText("" + cont);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        if (cont != 0) {
            outState.putInt("estado", cont);
        }
    }
}
