package com.example.a50_bdsqliteenandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a50_bdsqliteenandroid.Entidades.Mascota;
import com.example.a50_bdsqliteenandroid.Utilidades.Utilidades;

public class DetalleMascotasActivity extends AppCompatActivity {

    private TextView idMascotaVista, nombreMascotaVista, razaMascotaVista, idDuenioVista, nombreDuenioVista, telefonoDuenioVista;
    private Bundle bundle;
    private ConexionSQLiteHelper conexion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_mascotas);

        idMascotaVista = findViewById(R.id.idMascotaVista);
        nombreMascotaVista = findViewById(R.id.nombreMascotaVista);
        razaMascotaVista = findViewById(R.id.razaMascotaVista);
        idDuenioVista = findViewById(R.id.idDuenioVista);
        nombreDuenioVista = findViewById(R.id.nombreDuenioVista);
        telefonoDuenioVista = findViewById(R.id.telefonoDuenioVista);

        conexion = new ConexionSQLiteHelper(getApplicationContext(),"bd_usuario",null,1);

        bundle = getIntent().getExtras();
        Mascota mascota = null;

        if (bundle != null){
            mascota = (Mascota) bundle.getSerializable("mascota");
            idMascotaVista.setText(mascota.getIdDuenio().toString());
            nombreMascotaVista.setText(mascota.getNombreMascota());
            razaMascotaVista.setText(mascota.getRaza());
            consultarDuenio(mascota.getIdDuenio());
        }

    }

    private void consultarDuenio(Integer id){
        SQLiteDatabase db = conexion.getReadableDatabase();
        String[] parametros = {id.toString()};
        String [] campos = {Utilidades.CAMPO_NOMBRE, Utilidades.CAMPO_TELEFONO};

        try{
            Cursor cursor = db.query(Utilidades.TABLA_USUARIO,campos,Utilidades.CAMPO_ID + " = ?",parametros,null,null,null);
            cursor.moveToFirst();
            idDuenioVista.setText(id.toString());
            nombreDuenioVista.setText(cursor.getString(0));
            telefonoDuenioVista.setText(cursor.getString(1));
            cursor.close();

        }catch (Exception ex){
            Toast.makeText(this,"No existen datos para lo que se desea buscar",Toast.LENGTH_LONG).show();
        }

    }
}
