package com.jhorje18.dialogos;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.PersistableBundle;
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
import java.util.Date;

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
                txtFecha.setText("Fecha: " + dayOfMonth + "/" + (month+1) + "/" + year);
            }
        },2018,1,1);

        //Hora
        dialogoHora = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                //Al aceptar la hora
                String minutosPantalla = "";
                if (minute < 10){
                    minutosPantalla = "0" + minute;
                } else {
                    minutosPantalla = "" + minute;
                }

                txtHora.setText("Hora: " + hourOfDay + ":" + minutosPantalla);
            }
        }, 00,00,false);

        //Colores
        dialogoColores = new AlertDialog.Builder(this);
        dialogoColores.setTitle("Selecciona un color")
                .setItems(R.array.colores, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Al seleccionar algun elemento
                        String[] colors_array = getResources().getStringArray(R.array.colores);
                        switch (colors_array[which]){
                            case "Azul":
                                txtColor.setTextColor(getResources().getColor(R.color.azul));
                                break;
                            case "Verde":
                                txtColor.setTextColor(getResources().getColor(R.color.verde));
                                break;
                            case "Rojo":
                                txtColor.setTextColor(getResources().getColor(R.color.rojo));
                                break;
                        }

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

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("dialogoFecha", dialogoFecha.isShowing());
        outState.putBoolean("dialogoHora", dialogoHora.isShowing());

        outState.putString("txtFecha",txtFecha.getText().toString());
        outState.putString("txtHora",txtHora.getText().toString());
        outState.putString("txtColor",txtColor.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        //Dialogos
        if (savedInstanceState.getBoolean("dialogoFecha")){
            dialogoFecha.show();
        }
        if (savedInstanceState.getBoolean("dialogoHora")){
            dialogoHora.show();
        }

        //Textos
        txtFecha.setText(savedInstanceState.getString("txtFecha"));
        txtHora.setText(savedInstanceState.getString("txtHora"));
        txtColor.setText(savedInstanceState.getString("txtColor"));
    }
}
