package com.example.worldskills.psp.Activities;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.worldskills.psp.Clases.Proyecto;
import com.example.worldskills.psp.R;

import java.io.Serializable;
import java.util.Calendar;
import java.util.TimeZone;

import static java.lang.String.valueOf;

public class MenuActivity extends AppCompatActivity {

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
        String nombre = i.getStringExtra("Nombre");
        t.setText(nombre);

        /*
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.set*/
    }
}
