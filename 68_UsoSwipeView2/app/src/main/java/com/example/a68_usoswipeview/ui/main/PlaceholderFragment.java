package com.example.a68_usoswipeview.ui.main;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.a68_usoswipeview.Amarillo;
import com.example.a68_usoswipeview.Azul;
import com.example.a68_usoswipeview.R;
import com.example.a68_usoswipeview.Rojo;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment implements Amarillo.OnFragmentInteractionListener, Azul.OnFragmentInteractionListener,Rojo.OnFragmentInteractionListener{

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;

    public static Fragment newInstance(int index) {
       /* PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);*/

       Fragment fragment = null;

       switch (index){
           case 1:
               fragment = new Amarillo();
               break;
           case 2:
               fragment = new Rojo();
               break;
           case 3:
               fragment = new Azul();
               break;
       }

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        pageViewModel.setIndex(index);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        final TextView textView = root.findViewById(R.id.section_label);
        pageViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}