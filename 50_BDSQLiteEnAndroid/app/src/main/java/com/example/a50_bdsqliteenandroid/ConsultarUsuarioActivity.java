package com.example.a50_bdsqliteenandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a50_bdsqliteenandroid.Utilidades.Utilidades;

public class ConsultarUsuarioActivity extends AppCompatActivity {

    private EditText idUsuario, nombreUsuario, telefonoUsuario;
    private ConexionSQLiteHelper conexion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.consultar_usuario_activity);

        conexion = new ConexionSQLiteHelper(getApplicationContext(),"bd_usuario",null,1);

        idUsuario = findViewById(R.id.consulta_id);
        nombreUsuario = findViewById(R.id.consulta_nombre);
        telefonoUsuario = findViewById(R.id.consulta_telefono);

    }
    public void Consultar_Evento(View view) {


        switch (view.getId()){
            case R.id.consulta_btnBuscar:
                consultarUsuario(1);
                break;

            case R.id.consulta_btnActualizar:
                actualizarUsuario();
                limpiarCampos();
                break;

            case R.id.consulta_btnEliminar:
                eliminarUsuario();
                limpiarCampos();
                break;
        }

    }

    private void consultarUsuario(int opcion) {
        SQLiteDatabase db = conexion.getReadableDatabase();
        String [] parametros;
        Cursor cursor;

        switch (opcion){
            case 1:

                parametros = new String[]{idUsuario.getText().toString()};
                String [] campos = {Utilidades.CAMPO_NOMBRE,Utilidades.CAMPO_TELEFONO};

                try{
                    cursor = db.query(Utilidades.TABLA_USUARIO, campos, Utilidades.CAMPO_ID + "=?",parametros,null,null,null);
                    cursor.moveToFirst();

                    nombreUsuario.setText(cursor.getString(0));
                    telefonoUsuario.setText(cursor.getString(1));

                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"El dato solicitado no existe",Toast.LENGTH_LONG).show();
                    //limpiarCampos();
                }

                break;

            case 2:

                parametros = new String[]{idUsuario.getText().toString()};

                try {
                    cursor = db.rawQuery("SELECT " +Utilidades.CAMPO_NOMBRE + "," + Utilidades.CAMPO_TELEFONO+" FROM " + Utilidades.TABLA_USUARIO+
                            " WHERE "+ Utilidades.CAMPO_ID + "= ? ", parametros);

                    cursor.moveToFirst();

                    nombreUsuario.setText(cursor.getString(0));
                    telefonoUsuario.setText(cursor.getString(1));
                }catch (Exception ex){
                    Toast.makeText(getApplicationContext(), ex.getMessage(), Toast.LENGTH_LONG).show();
                    //limpiarCampos();
                }

                break;
        }

        db.close();

    }

    private void actualizarUsuario() {

        SQLiteDatabase db = conexion.getWritableDatabase();
        String [] parametros = {idUsuario.getText().toString()};
        ContentValues valores = new ContentValues();

        valores.put(Utilidades.CAMPO_NOMBRE,nombreUsuario.getText().toString());
        valores.put(Utilidades.CAMPO_TELEFONO, telefonoUsuario.getText().toString());

        db.update(Utilidades.TABLA_USUARIO,valores,Utilidades.CAMPO_ID + "=?",parametros);

        Toast.makeText(getBaseContext(),"Usuario actualizado",Toast.LENGTH_LONG).show();
        db.close();

    }

    private void eliminarUsuario(){
        SQLiteDatabase db = conexion.getWritableDatabase();
        String [] parametros = {idUsuario.getText().toString()};

        db.delete(Utilidades.TABLA_USUARIO,Utilidades.CAMPO_ID+"=?",parametros);

        Toast.makeText(getBaseContext(),"Registro eliminado",Toast.LENGTH_LONG).show();

        db.close();
    }

    private void limpiarCampos(){
        idUsuario.setText("");
        nombreUsuario.setText("");
        telefonoUsuario.setText("");
    }
}
