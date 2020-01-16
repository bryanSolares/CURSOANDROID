package com.example.patromaestrodetalle;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;

import com.example.patromaestrodetalle.Fragments.DetallePersonajesFragment;
import com.example.patromaestrodetalle.Fragments.ListaPersonajesFragment;

public class MainActivity extends AppCompatActivity implements ListaPersonajesFragment.OnFragmentInteractionListener, DetallePersonajesFragment.OnFragmentInteractionListener{

    private ListaPersonajesFragment listaPersonajesFragment;
    private DetallePersonajesFragment detallePersonajesFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaPersonajesFragment = new ListaPersonajesFragment();
        detallePersonajesFragment = new DetallePersonajesFragment();

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.contenedorFragment,listaPersonajesFragment)
                .commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
