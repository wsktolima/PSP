package com.example.worldskills.psp.Activities;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
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
        /*c = Calendar.getInstance();
        int hora = c.get(Calendar.HOUR);
        int min = c.get(Calendar.MINUTE);



        String tiempo = valueOf(hora) +  ":" +valueOf(min);
        t.setText(tiempo);*/
        Intent i = getIntent();
        nombre = i.getStringExtra("Nombre");
        t.setText(getNombre());

        /*
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.set*/


    }
    public String getNombre() {
        return nombre;
    }

    public void irA(View view){
        Intent i = null;

        if(view.getId() == R.id.btn_TimeLog){
            i = new Intent(getApplicationContext(), Formulariotimelog.class);
        }if(view.getId() == R.id.btn_DefectLog){

        }if(view.getId() == R.id.btn_ProjectPS){
            i = null;
        }

        startActivity(i);
    }
}
