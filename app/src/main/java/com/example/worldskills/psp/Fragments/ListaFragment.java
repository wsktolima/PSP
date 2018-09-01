package com.example.worldskills.psp.Fragments;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.worldskills.psp.Activities.MenuActivity;
import com.example.worldskills.psp.Clases.AdaptadorLista;
import com.example.worldskills.psp.Clases.Proyecto;
import com.example.worldskills.psp.ConexionDB;
import com.example.worldskills.psp.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ListaFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ListaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListaFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    RecyclerView lista_Proyectos;
    AdaptadorLista adapter;
    ArrayList<Proyecto> proyectos;
    ConexionDB conexionDB;
    SQLiteDatabase db;

    private OnFragmentInteractionListener mListener;

    public ListaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListaFragment newInstance(String param1, String param2) {
        ListaFragment fragment = new ListaFragment();
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
        View lista = inflater.inflate(R.layout.fragment_lista, container, false);
        proyectos = new ArrayList<>();
        llenarLista();

        lista_Proyectos = lista.findViewById(R.id.recycler);
        lista_Proyectos.setLayoutManager(new LinearLayoutManager(null));
        adapter = new AdaptadorLista(proyectos);
        lista_Proyectos.setAdapter(adapter);
        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), MenuActivity.class);
                i.putExtra("Nombre", proyectos.get(lista_Proyectos.getChildAdapterPosition(v)).getNombreProyecto());
                startActivity(i);
            }
        });

        return lista;
    }

    public void  llenarLista(){

        conexionDB = new ConexionDB(getContext(), "PSP",null, 1);
        db = conexionDB.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT nombreProyecto FROM Proyectos", null);

        while (cursor.moveToNext()){
            proyectos.add(new Proyecto(cursor.getString(0)));
        }
        cursor.close();
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
