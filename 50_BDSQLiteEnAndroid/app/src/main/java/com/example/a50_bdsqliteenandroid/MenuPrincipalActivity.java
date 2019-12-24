package com.example.a50_bdsqliteenandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.a50_bdsqliteenandroid.Utilidades.ConsultarListaMascotasActivity;

public class MenuPrincipalActivity extends AppCompatActivity {

    private ConexionSQLiteHelper conexion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        conexion = new ConexionSQLiteHelper(this,"bd_usuario",null,1);
    }

    public void Evento(View view) {

        Intent intencion = null;

        switch(view.getId()){
            case R.id.registrar:
                intencion = new Intent(this, RegistrarUsuarioActivity.class);
                break;

            case R.id.registrarMascota:
                intencion = new Intent(this,RegistrarMascotaActivity.class);
                break;

            case R.id.consultar1:
                intencion = new Intent(this, ConsultarUsuarioActivity.class);
                break;

            case R.id.consultar2:
                intencion = new Intent(this, ConsultaComboUsuarioActivity.class);
                break;

            case R.id.consultar3:
                intencion = new Intent(this, ConsultaListViewActivity.class);
                break;

            case R.id.consultar4:
                intencion = new Intent(this, ConsultarListaMascotasActivity.class);
                break;
        }

        if (intencion !=null) {
            startActivity(intencion);
        }

    }
}
