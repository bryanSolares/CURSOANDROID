package com.example.a50_bdsqliteenandroid.Utilidades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.a50_bdsqliteenandroid.ConexionSQLiteHelper;
import com.example.a50_bdsqliteenandroid.DetalleMascotasActivity;
import com.example.a50_bdsqliteenandroid.Entidades.Mascota;
import com.example.a50_bdsqliteenandroid.R;

import java.util.ArrayList;

public class ConsultarListaMascotasActivity extends AppCompatActivity {

    private ListView listaGeneral;
    private ArrayList<String> listaInformacion;
    private ArrayList<Mascota> listaMascotas;
    private ConexionSQLiteHelper conexion;
    private Intent intencion;
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_lista_mascotas);

        conexion = new ConexionSQLiteHelper(getApplicationContext(),"bd_usuario",null,1);

        listaGeneral = findViewById(R.id.listaMasc);

        cargarLista();

        ArrayAdapter adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1,listaInformacion);
        listaGeneral.setAdapter(adaptador);

        listaGeneral.setOnItemClickListener((parent, view, position, id) -> {

            Mascota mascota = listaMascotas.get(position);
            intencion = new Intent(ConsultarListaMascotasActivity.this, DetalleMascotasActivity.class);
            bundle = new Bundle();
            bundle.putSerializable("mascota",mascota);
            intencion.putExtras(bundle);
            startActivity(intencion);
        });
    }

    private void cargarLista(){
        SQLiteDatabase db = conexion.getReadableDatabase();
        Mascota mascota = null;
        listaMascotas = new ArrayList<>();

        Cursor cursor = db.rawQuery("SELECT * FROM " + Utilidades.TABLA_MASCOTA,null);

        while(cursor.moveToNext()){
            mascota = new Mascota();
            mascota.setIdMascota(cursor.getInt(0));
            mascota.setNombreMascota(cursor.getString(1));
            mascota.setRaza(cursor.getString(2));
            mascota.setIdDuenio(cursor.getInt(3));

            listaMascotas.add(mascota);
        }

        cargarListaView();
    }

    private void cargarListaView(){
        listaInformacion = new ArrayList<>();

        for (Mascota listaMascota : listaMascotas) {
            listaInformacion.add(listaMascota.getNombreMascota() + " - " + listaMascota.getRaza());
        }
    }
}
