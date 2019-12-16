package com.example.a50_bdsqliteenandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.a50_bdsqliteenandroid.Entidades.Usuario;
import com.example.a50_bdsqliteenandroid.Utilidades.Utilidades;

import java.util.ArrayList;

public class RegistrarMascotaActivity extends AppCompatActivity {

    private EditText nombreMascota, razaMascota;
    private Spinner listaDuenio;
    private ArrayList<String> listaPersonas;
    private ArrayList<Usuario> listaUsuarios;
    private ConexionSQLiteHelper conexion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrar_mascota_activity);

        conexion = new ConexionSQLiteHelper(getApplicationContext(),"bd_usuario",null,1);

        nombreMascota = findViewById(R.id.nombreMascota);
        razaMascota = findViewById(R.id.razaMascota);
        listaDuenio = findViewById(R.id.listaDuenio);

        consultarListaPersonas();

        ArrayAdapter<CharSequence> adaptador = new ArrayAdapter(this,android.R.layout.simple_spinner_item,listaPersonas);
        listaDuenio.setAdapter(adaptador);

       /* listaDuenio.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });*/

    }

    private void consultarListaPersonas(){
        SQLiteDatabase bd = conexion.getReadableDatabase();

        Usuario persona = null;

        listaUsuarios = new ArrayList<>();

        Cursor cursor = bd.rawQuery("SELECT * FROM " + Utilidades.TABLA_USUARIO,null);

        while(cursor.moveToNext()){
            persona = new Usuario();
            persona.setIdUsuario(cursor.getInt(0));
            persona.setNombre(cursor.getString(1));
            persona.setTelefono(cursor.getString(2));

            listaUsuarios.add(persona);
        }

        obtenerListaPersona();
    }

    private void obtenerListaPersona(){
        listaPersonas = new ArrayList<>();
        listaPersonas.add("Seleccione una Opcion");
        for (Usuario elemento : listaUsuarios) {
            listaPersonas.add(elemento.getNombre());
        }
    }

    public void Evento(View view) {
        int idCombo = (int)listaDuenio.getSelectedItemId();

        if(idCombo!= 0){
            SQLiteDatabase db = conexion.getWritableDatabase();
            ContentValues valores = new ContentValues();
            valores.put(Utilidades.CAMPO_NOMBRE_MASCOTA,nombreMascota.getText().toString());
            valores.put(Utilidades.CAMPO_RAZA, razaMascota.getText().toString());

            int duenio = listaUsuarios.get(idCombo-1).getIdUsuario();
            valores.put(Utilidades.CAMPO_ID_DUENIO,duenio);

            db.insert(Utilidades.TABLA_MASCOTA,Utilidades.CAMPO_ID_MASCOTA,valores);

        }else{

        }

    }
}
