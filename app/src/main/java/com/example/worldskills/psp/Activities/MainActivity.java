package com.example.worldskills.psp.Activities;

import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.worldskills.psp.ConexionDB;
import com.example.worldskills.psp.Fragments.ListaFragment;
import com.example.worldskills.psp.R;

public class MainActivity extends AppCompatActivity implements ListaFragment.OnFragmentInteractionListener{

    FloatingActionButton fabAgregar;
    ListaFragment fragmentLista;
    ConexionDB conexionDB;
    SQLiteDatabase db;

    EditText et_NombreProyecto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        conexionDB = new ConexionDB(getApplicationContext(), "PSP",null, 1);
        db = conexionDB.getWritableDatabase();

        et_NombreProyecto = findViewById(R.id.et_nombre);

        fragmentLista = new ListaFragment();
        fabAgregar = findViewById(R.id.fab_Agregar);

        asignarListener();
        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor_Lista,fragmentLista).commit();
    }

    /**
     * Metodo Para Asignar el On Click al FAB
     */
    private void asignarListener(){
        fabAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (et_NombreProyecto.getText().length() == 0){
                    Snackbar.make(v, "INGRESE UN NOMBRE VALIDO", Snackbar.LENGTH_SHORT).show();
                }else {
                    agregarProyecto(v);
                    recargarLista();
                }
            }
        });
    }

    /**
     * Metodo que me ayuda a agregar Un Nuevo Proyecto
     */
    private void agregarProyecto(View v) {
        String nombre = et_NombreProyecto.getText().toString();
        Snackbar.make(v, "Proyecto Agregado!", Snackbar.LENGTH_SHORT).show();
        conexionDB.agregarProyecto(db, nombre);
        et_NombreProyecto.setText("");
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
        },50);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
