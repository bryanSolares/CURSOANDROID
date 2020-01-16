package com.example.patromaestrodetalle;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;

import com.example.patromaestrodetalle.Entidades.PersonajeVO;
import com.example.patromaestrodetalle.Fragments.DetallePersonajesFragment;
import com.example.patromaestrodetalle.Fragments.ListaPersonajesFragment;
import com.example.patromaestrodetalle.Interfaces.IComunicaFragments;

public class MainActivity extends AppCompatActivity implements ListaPersonajesFragment.OnFragmentInteractionListener, DetallePersonajesFragment.OnFragmentInteractionListener, IComunicaFragments {

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

    @Override
    public void enviarPersonaje(PersonajeVO personaje) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("personaje",personaje);
        detallePersonajesFragment.setArguments(bundle);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.contenedorFragment,detallePersonajesFragment)
                .addToBackStack(null)
                .commit();

    }
}
