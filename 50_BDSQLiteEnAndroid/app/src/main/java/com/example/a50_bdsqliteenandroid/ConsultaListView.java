package com.example.a50_bdsqliteenandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.a50_bdsqliteenandroid.Entidades.Usuario;
import com.example.a50_bdsqliteenandroid.Utilidades.Utilidades;

import java.util.ArrayList;

public class ConsultaListView extends AppCompatActivity {

    private ListView listaUsuarioView;
    private ArrayList<String> listaInformacion;
    private ArrayList<Usuario> listaUsuarios;
    private ConexionSQLiteHelper conexion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.consulta_list_view_activity);

        listaUsuarioView = findViewById(R.id.listaUsuarioView);

        conexion = new ConexionSQLiteHelper(getApplicationContext(),"bd_usuario",null,1);

        consultarListaUsuario();
    }

    private void consultarListaUsuario() {

        SQLiteDatabase db = conexion.getReadableDatabase();
        Usuario usuario = null;
        listaUsuarios = new ArrayList<>();

        Cursor cursor = db.rawQuery("SELECT * FROM " + Utilidades.TABLA_USUARIO,null);

        while(cursor.moveToNext()){
            usuario = new Usuario();
            usuario.setIdUsuario(cursor.getInt(0));
            usuario.setNombre(cursor.getString(1));
            usuario.setTelefono(cursor.getString(2));

            listaUsuarios.add(usuario);
        }

        obtenerLista();

    }

    private void obtenerLista() {

        Intent intencion = new Intent(this,DetalleUsuario.class);
        Bundle bundle = new Bundle();

        listaInformacion = new ArrayList<>();

        for (Usuario elemento : listaUsuarios) {
            listaInformacion.add(elemento.toString());
        }

        ArrayAdapter adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1,listaInformacion);

        listaUsuarioView.setAdapter(adaptador);

        listaUsuarioView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String informacion = "Id: " + listaUsuarios.get(position).getIdUsuario();
                informacion += " Nombre: " + listaUsuarios.get(position).getNombre();
                informacion += " Telefono: " + listaUsuarios.get(position).getTelefono();

                //Toast.makeText(getApplicationContext(),informacion,Toast.LENGTH_LONG).show();
                Usuario user = listaUsuarios.get(position);
                bundle.putSerializable("usuario",user);
                intencion.putExtras(bundle);
                startActivity(intencion);

            }
        });

    }
}
