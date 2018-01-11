package com.jhorje18.dialogos;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    //Variables
    int dia, mes, año, hora, minutos;
    Button btnFecha, btnhora, btnColor;
    TextView txtFecha, txtHora, txtColor;

    DatePickerDialog dialogoFecha;
    TimePickerDialog dialogoHora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Vista
        btnFecha = (Button) findViewById(R.id.btnFecha);
        btnhora = (Button) findViewById(R.id.btnHora);
        btnColor = (Button) findViewById(R.id.btnColor);
        txtFecha = (TextView) findViewById(R.id.txtFecha);
        txtHora = (TextView) findViewById(R.id.txtHora);
        txtColor = (TextView) findViewById(R.id.txtColor);

        //Fecha
        dialogoFecha = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                dia = dayOfMonth;
                mes = month;
                año = year;

                recargar();
            }
        },0,0,0);


        //Hora
        dialogoHora = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                //Al aceptar la hora
                hora = hourOfDay;
                minutos = minute;

                recargar();
            }
        }, 00,00,false);

        //Botones
        btnFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogoFecha.show();
            }
        });
    }

    private void recargar() {
        //Recargamos elementos
        txtFecha.setText("Fecha: " + dia + "/" + mes + "/" + año);
        txtHora.setText("Hora: " + hora + ":" + minutos);
    }
}
