package com.example.a50_bdsqliteenandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.a50_bdsqliteenandroid.Entidades.Usuario;

public class DetalleUsuarioActivity extends AppCompatActivity {

    private TextView txtidUsuario, txtnombreUsuario, txttelefonoUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalle_usuario_activity);

        txtidUsuario = findViewById(R.id.txtidUsuario);
        txtnombreUsuario = findViewById(R.id.txtNombreUsuario);
        txttelefonoUsuario = findViewById(R.id.txtTelefonoUsuario);

        Bundle objetoEnviado= getIntent().getExtras();
        Usuario usuario = null;

        if (objetoEnviado != null){
            usuario = (Usuario)objetoEnviado.getSerializable("usuario");
            txtidUsuario.setText(usuario.getIdUsuario().toString());
            txtnombreUsuario.setText(usuario.getNombre());
            txttelefonoUsuario.setText(usuario.getTelefono());
        }
    }
}
