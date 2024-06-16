package com.example.calendario;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private CalendarView calendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calendarView= findViewById(R.id.calendarview);


        //obtener la fecha actual

        Calendar today = Calendar.getInstance();
        long currentTimeMillis= today.getTimeInMillis();

        //seleccionar la fecha de hoy en el CalendarView
        calendarView.setDate(currentTimeMillis, false, true);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String date = dayOfMonth + "/" + (month+1) + "/" + year;
                Toast.makeText(MainActivity.this, "Selecciona Fecha:" + date, Toast.LENGTH_SHORT).show();
            }
        });

        //limitar las fechas seleccionables

        calendarView.setMinDate(System.currentTimeMillis()-1000); //desde hoy
        //calendarView.setMaxDate(System.currentTimeMillis() + (1000*60*60*24*7));// hasta una semana desde hoy
    }
}// el archivo no compila