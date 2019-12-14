package com.example.a44_usolistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listaDias;
    TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaDias = (ListView) findViewById(R.id.listView);
        resultado = (TextView) findViewById(R.id.resultado);

        List<String> lista = new ArrayList<>();
        lista.add("Opción 1");
        lista.add("Opción 2");
        lista.add("Opción 3");

        //ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.arrayDias,android.R.layout.simple_list_item_1);
        ArrayAdapter<String> adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,lista);
        listaDias.setAdapter(adapter);

        listaDias.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                resultado.setText("Resultado: " + parent.getItemAtPosition(position).toString());
                Toast.makeText(parent.getContext(), "Selección: " + parent.getItemAtPosition(position).toString(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
