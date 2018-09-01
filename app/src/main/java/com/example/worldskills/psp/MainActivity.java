package com.example.worldskills.psp;

import android.net.Uri;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements ListaFragment.OnFragmentInteractionListener{

    FloatingActionButton fabAgregar;
    ListaFragment fragmentLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentLista = new ListaFragment();
        fabAgregar = findViewById(R.id.fab_Agregar);

        fabAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Prueba", Snackbar.LENGTH_SHORT).show();
                recargarLista();
            }
        });

        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor_Lista,fragmentLista).commit();
    }

    /**
     * Metodo para Recargar la Lista Cuando se Agrega un Nuevo Proyecto
     */
    private void recargarLista() {
        getSupportFragmentManager().beginTransaction().remove(fragmentLista).commit();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                getSupportFragmentManager().beginTransaction().replace(R.id.contenedor_Lista,fragmentLista).commit();
            }
        },100);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
