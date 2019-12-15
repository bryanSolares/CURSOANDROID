package com.example.a50_bdsqliteenandroid;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.a50_bdsqliteenandroid.Entidades.Usuario;
import com.example.a50_bdsqliteenandroid.Utilidades.Utilidades;

import java.util.ArrayList;

public class ConsultaComboUsuario extends AppCompatActivity {

    private Spinner comboUsuarios;
    private TextView usuarioDocumento, usuarioNombre, usuarioTelefono;
    private ArrayList<String> comboPersonas;
    private ArrayList<Usuario> listaPersonas;
    private ConexionSQLiteHelper conexion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.consulta_combo_usuario_activity);

        comboUsuarios = findViewById(R.id.comboUsuarios);
        usuarioDocumento = findViewById(R.id.usuarioDocumento);
        usuarioNombre = findViewById(R.id.usuarioNombre);
        usuarioTelefono = findViewById(R.id.usuarioTelefono);

        conexion = new ConexionSQLiteHelper(getApplicationContext(),"bd_usuario",null,1);

        consultarListaPersonas();
    }

    private void consultarListaPersonas() {

        SQLiteDatabase db = conexion.getReadableDatabase();
        Usuario usuario = null;
        listaPersonas = new ArrayList<>();

        Cursor cursor = db.rawQuery("SELECT * FROM " + Utilidades.TABLA_USUARIO,null);

        while(cursor.moveToNext()){
            usuario = new Usuario();
            usuario.setIdUsuario(cursor.getInt(0));
            usuario.setNombre(cursor.getString(1));
            usuario.setTelefono(cursor.getString(2));

            listaPersonas.add(usuario);
        }

        obtenerLista();

    }

    private void obtenerLista() {
        comboPersonas = new ArrayList<>();
        comboPersonas.add("Seleccione: ");

        for (Usuario elemento : listaPersonas) {
            comboPersonas.add(elemento.getIdUsuario() + " " +elemento.getNombre());
        }

        ArrayAdapter<CharSequence> adaptador = new ArrayAdapter(this,android.R.layout.simple_spinner_item,comboPersonas);

        comboUsuarios.setAdapter(adaptador);

        comboUsuarios.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (position!=0){
                    usuarioDocumento.setText(listaPersonas.get(position-1).getIdUsuario().toString());
                    usuarioNombre.setText(listaPersonas.get(position-1).getNombre().toString());
                    usuarioTelefono.setText(listaPersonas.get(position-1).getTelefono().toString());
                }else{
                    usuarioDocumento.setText("");
                    usuarioNombre.setText("");
                    usuarioTelefono.setText("");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


}
