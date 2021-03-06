package com.example.patromaestrodetalle.Fragments;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.patromaestrodetalle.Adaptadores.AdaptadorPersonaje;
import com.example.patromaestrodetalle.Entidades.PersonajeVO;
import com.example.patromaestrodetalle.Interfaces.IComunicaFragments;
import com.example.patromaestrodetalle.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ListaPersonajesFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ListaPersonajesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListaPersonajesFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private List<PersonajeVO> listaPersonajes;
    private RecyclerView recyclerPersonajes;
    private IComunicaFragments comunicaFragments;
    private Activity actividad;

    public ListaPersonajesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListaPersonajesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListaPersonajesFragment newInstance(String param1, String param2) {
        ListaPersonajesFragment fragment = new ListaPersonajesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_lista_personajes, container, false);
        listaPersonajes = new ArrayList<>();
        recyclerPersonajes = vista.findViewById(R.id.recyclerId);
        recyclerPersonajes.setLayoutManager(new LinearLayoutManager(getContext()));
        llenarListaPersonajes();
        AdaptadorPersonaje adaptadorPersonaje = new AdaptadorPersonaje(listaPersonajes);
        recyclerPersonajes.setAdapter(adaptadorPersonaje);

        adaptadorPersonaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),
                        "Seleccionado: " + listaPersonajes.get(recyclerPersonajes.getChildAdapterPosition(v)).getNombre(),Toast.LENGTH_LONG).show();
<<<<<<< HEAD

=======
>>>>>>> 1570c0ba35b0460ddde5b2f5d9d9bd935e6d3485
                comunicaFragments.enviarPersonaje(listaPersonajes.get(recyclerPersonajes.getChildAdapterPosition(v)));
            }
        });
        return vista;
    }

    private void llenarListaPersonajes(){
        listaPersonajes.add(new PersonajeVO(getString(R.string.nombre),getString(R.string.descripcion),R.drawable.ic_launcher_background,getString(R.string.informacion),R.drawable.ic_launcher_background));
        listaPersonajes.add(new PersonajeVO(getString(R.string.nombre),getString(R.string.descripcion),R.drawable.ic_launcher_background,getString(R.string.informacion),R.drawable.ic_launcher_background));
        listaPersonajes.add(new PersonajeVO(getString(R.string.nombre),getString(R.string.descripcion),R.drawable.ic_launcher_background,getString(R.string.informacion),R.drawable.ic_launcher_background));
        listaPersonajes.add(new PersonajeVO(getString(R.string.nombre),getString(R.string.descripcion),R.drawable.ic_launcher_background,getString(R.string.informacion),R.drawable.ic_launcher_background));
        listaPersonajes.add(new PersonajeVO(getString(R.string.nombre),getString(R.string.descripcion),R.drawable.ic_launcher_background,getString(R.string.informacion),R.drawable.ic_launcher_background));
        listaPersonajes.add(new PersonajeVO(getString(R.string.nombre),getString(R.string.descripcion),R.drawable.ic_launcher_background,getString(R.string.informacion),R.drawable.ic_launcher_background));
        listaPersonajes.add(new PersonajeVO(getString(R.string.nombre),getString(R.string.descripcion),R.drawable.ic_launcher_background,getString(R.string.informacion),R.drawable.ic_launcher_background));
        listaPersonajes.add(new PersonajeVO(getString(R.string.nombre),getString(R.string.descripcion),R.drawable.ic_launcher_background,getString(R.string.informacion),R.drawable.ic_launcher_background));
        listaPersonajes.add(new PersonajeVO(getString(R.string.nombre),getString(R.string.descripcion),R.drawable.ic_launcher_background,getString(R.string.informacion),R.drawable.ic_launcher_background));
        listaPersonajes.add(new PersonajeVO(getString(R.string.nombre),getString(R.string.descripcion),R.drawable.ic_launcher_background,getString(R.string.informacion),R.drawable.ic_launcher_background));
        listaPersonajes.add(new PersonajeVO(getString(R.string.nombre),getString(R.string.descripcion),R.drawable.ic_launcher_background,getString(R.string.informacion),R.drawable.ic_launcher_background));
        listaPersonajes.add(new PersonajeVO(getString(R.string.nombre),getString(R.string.descripcion),R.drawable.ic_launcher_background,getString(R.string.informacion),R.drawable.ic_launcher_background));
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof Activity){
            this.actividad = (Activity) context;
            comunicaFragments = (IComunicaFragments) this.actividad;
        }

        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
