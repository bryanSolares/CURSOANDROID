package com.example.a50_bdsqliteenandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a50_bdsqliteenandroid.Utilidades.Utilidades;

public class ConsultarUsuario extends AppCompatActivity {

    private EditText idUsuario, nombreUsuario, telefonoUsuario;
    private ConexionSQLiteHelper conexion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.consultar_usuario_activity);

        conexion = new ConexionSQLiteHelper(this,"bd_usuario",null,1);

        idUsuario = findViewById(R.id.consulta_id);
        nombreUsuario = findViewById(R.id.nombreUsuario);
        telefonoUsuario = findViewById(R.id.telefonoUsuario);

    }
    public void Consultar_Evento(View view) {


        switch (view.getId()){
            case R.id.consulta_btnBuscar:
                consultarUsuario();
                break;

            case R.id.consulta_btnActualizar:

                break;

            case R.id.consulta_btnEliminar:

                break;
        }

    }

    private void consultarUsuario() {

        SQLiteDatabase db = conexion.getReadableDatabase();
        String [] parametros = {idUsuario.getText().toString()};
        String [] campos = {Utilidades.CAMPO_NOMBRE,Utilidades.CAMPO_TELEFONO};

        try{
            Cursor cursor = db.query(Utilidades.TABLA_USUARIO, campos, Utilidades.CAMPO_ID + "=?",parametros,null,null,null);
            cursor.moveToFirst();

            nombreUsuario.setText(cursor.getString(0));
            telefonoUsuario.setText(cursor.getString(1));

            cursor.close();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"El dato solicitado no existe",Toast.LENGTH_LONG).show();
            //limpiarCampos();
        }

    }

    private void limpiarCampos(){
        idUsuario.setText(" ");
        nombreUsuario.setText(" ");
        telefonoUsuario.setText(" ");
    }
}
