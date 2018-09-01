package com.example.worldskills.psp.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


import com.example.worldskills.psp.R;

import java.io.Serializable;
import java.util.Calendar;


public class MenuActivity extends AppCompatActivity {

    private String nombre;
    TextView t;
    Calendar c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        t = findViewById(R.id.texto);

        Intent i = getIntent();
        nombre = i.getStringExtra("Nombre");
        t.setText(getNombre());
    }

    /**
     * Metodo Para Obtener el Nombre del Proyecto
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo para dirigirse a Alguna Actividad
     * @param view
     */
    public void irA(View view){
        Intent i = null;

        if(view.getId() == R.id.btn_TimeLog){
            i = new Intent(getApplicationContext(), Formulariotimelog.class);
        }if(view.getId() == R.id.btn_DefectLog){
            i = new Intent(getApplicationContext(), DefectLog.class);
        }if(view.getId() == R.id.btn_ProjectPS){
            i = null;
        }

        startActivity(i);
    }
}
