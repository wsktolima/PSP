package com.example.worldskills.psp.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.worldskills.psp.R;

import java.util.Calendar;


public class DefectLog extends AppCompatActivity {

    EditText et_fecha;
    ImageButton btn_getHora;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_defect_log);

        et_fecha = findViewById(R.id.et_Fecha);
        btn_getHora = findViewById(R.id.btn_DateHour);

        btn_getHora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_fecha.setText(getHora());
            }
        });
    }

    /**
     * Metodo para obtener la fecha y Hora Actual
     * @return la hora y fecha del dispositivo
     */
    public String getHora(){
        Calendar c = Calendar.getInstance();

        int dia = c.get(Calendar.DAY_OF_MONTH),
                mes = c.get(Calendar.MONTH),
                ano = c.get(Calendar.YEAR),
                hora = c.get(Calendar.HOUR),
                min = c.get(Calendar.MINUTE);

        return dia +"/" + mes + "/" + ano + " " + hora + ":" + min;
    }
}
