package com.example.a39_parmetrosentreactividades;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MensajeActivity extends AppCompatActivity {

    private TextView resultadofinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensaje);

        resultadofinal = (TextView) findViewById(R.id.resultadofinal);

        Bundle bundle = this.getIntent().getExtras();

        if(bundle!= null){
            resultadofinal.setText(getString(R.string.mensajeGlobal) + bundle.getString("nombre"));
        }


    }

    public void accion(View view) {
        finish();
    }
}
