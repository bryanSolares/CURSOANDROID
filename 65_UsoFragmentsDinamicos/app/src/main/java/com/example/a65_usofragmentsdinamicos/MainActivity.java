package com.example.a65_usofragmentsdinamicos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements
        FragmentRojo.OnFragmentInteractionListener,
        FragmentAzul.OnFragmentInteractionListener,
        FragmentVerde.OnFragmentInteractionListener{

    private FragmentRojo fragmentRojo;
    private FragmentAzul fragmentAzul;
    private FragmentVerde fragmentVerde;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentRojo = new FragmentRojo();
        fragmentAzul = new FragmentAzul();
        fragmentVerde = new FragmentVerde();

        getSupportFragmentManager().beginTransaction().add(R.id.conetenedorFragments,fragmentRojo).commit();
    }

    public void Evento(View view) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        switch (view.getId()){
            case R.id.btnRojo:
                    transaction.replace(R.id.conetenedorFragments,fragmentRojo);
                break;
            case R.id.btnAzul:
                    transaction.replace(R.id.conetenedorFragments,fragmentAzul);
                break;
            case R.id.btnVerde:
                    transaction.replace(R.id.conetenedorFragments,fragmentVerde);
                break;
        }

        transaction.commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
