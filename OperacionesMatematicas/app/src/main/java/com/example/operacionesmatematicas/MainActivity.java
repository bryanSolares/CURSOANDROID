package com.example.operacionesmatematicas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText campo1, campo2;
    private TextView resultado;
    private int numero1, numero2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campo1 = (EditText)findViewById(R.id.campo1);
        campo2 = (EditText)findViewById(R.id.campo2);
        resultado = (TextView)findViewById(R.id.resultado);
    }



    public void operacionMatematica(View view) {

        numero1 = Integer.parseInt(campo1.getText().toString());
        numero2 = Integer.parseInt(campo2.getText().toString());

        switch (view.getId()){
            case R.id.boton_suma: sumar();
                break;
            case R.id.boton_resta: restar();
                break;
            case R.id.boton_multipli: multiplicar();
                break;
            case R.id.boton_division: dividir();
                break;
        }
    }

    private void sumar() {
        int suma = numero1 + numero2;
        resultado.setText("El resultado de la suma es: " + suma);
    }

    private void restar() {
        int resta = numero1 - numero2;
        resultado.setText("El resultado de la resta es: " + resta);
    }

    private void multiplicar() {
        int multiplicacion = numero1 * numero2;
        resultado.setText("El resultado de la multiplicacion es: " + multiplicacion);
    }

    private void dividir() {
        try {
            int division = numero1 / numero2;
            resultado.setText("El resultado de la division es: " + division);
        }catch (ArithmeticException e){
            Toast.makeText(this,"Advertencia",Toast.LENGTH_LONG).show();
            resultado.setText("No se permite dividir por cero");
        }

    }

}
