package com.example.a50_bdsqliteenandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a50_bdsqliteenandroid.Utilidades.Utilidades;

public class RegistrarUsuario extends AppCompatActivity {

    private EditText idUsuario, nombreUsuario, telefonoUsuario;
    private ConexionSQLiteHelper conexion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrarusuario_activity);

        idUsuario = findViewById(R.id.idUsuario);
        nombreUsuario = findViewById(R.id.nombreUsuario);
        telefonoUsuario = findViewById(R.id.telefonoUsuario);

    }

    public void EventoRegistrar(View view) {
        switch (view.getId()){
            case R.id.registrar:
                registrarUsuarios();
                break;
            case R.id.salir:
                finish();
                break;
        }
    }

    private void registrarUsuarios() {
        conexion = new ConexionSQLiteHelper(this,"bd_usuario",null,1);

        SQLiteDatabase db = conexion.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put(Utilidades.CAMPO_ID,idUsuario.getText().toString());
        valores.put(Utilidades.CAMPO_NOMBRE,nombreUsuario.getText().toString());
        valores.put(Utilidades.CAMPO_TELEFONO,telefonoUsuario.getText().toString());

        Long idResultante = db.insert(Utilidades.TABLA_USUARIO,Utilidades.CAMPO_ID,valores);

        Toast.makeText(this,"Id Registro: " + idResultante,Toast.LENGTH_LONG).show();

        db.close();
    }
}
