package com.jhorje18.dialogos;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Variables
    Button btnFecha, btnhora, btnColor;
    TextView txtFecha, txtHora, txtColor;

    //Dialogos
    DatePickerDialog dialogoFecha;
    TimePickerDialog dialogoHora;
    AlertDialog.Builder dialogoColores;

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
                txtFecha.setText("Fecha: " + dayOfMonth + "/" + month + "/" + year);
            }
        },0,0,0);

        //Hora
        dialogoHora = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                //Al aceptar la hora
                txtHora.setText("Hora: " + hourOfDay + ":" + minute);
            }
        }, 00,00,false);

        //Añadimos colores
        final String[] colors_array = new String[3];
        colors_array[0] = "Azul";
        colors_array[1] = "Verde";
        colors_array[2] = "Rojo";

        //Colores
        dialogoColores = new AlertDialog.Builder(this);
        dialogoColores.setTitle("Selecciona un color")
                .setItems(colors_array, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Al seleccionar algun elemento
                        txtColor.setText("Color: " + colors_array[which]);
                    }
                });
        dialogoColores.create();


        //Botones
        btnFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogoFecha.show();
            }
        });

        btnhora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogoHora.show();
            }
        });

        btnColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogoColores.show();
            }
        });
    }
}
