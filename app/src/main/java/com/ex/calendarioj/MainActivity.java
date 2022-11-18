package com.ex.calendarioj;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText etFecha=(EditText) findViewById(R.id.etFecha);
        etFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId()==R.id.etFecha)
                {
                    mostrarCalendario();
                }
            }
        });
    }

    private void mostrarCalendario() {

        DatePickerFragment nuevoFragment=DatePickerFragment.instancia(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                final String fecha= i2 +"/" + (i1+1) + "/" + i;
                EditText etFecha=(EditText) findViewById(R.id.etFecha);
                etFecha.setText(fecha);
            }
        });
        nuevoFragment.show(getSupportFragmentManager(),"datepicker");
    }
}