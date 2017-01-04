package com.example.joans.timetracker;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.*;

public class NouInformeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nou_informe);
        Spinner spinnerInforme = (Spinner) findViewById(R.id.period);
        ArrayAdapter<String> spinnerInformeArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.periods));
        spinnerInforme.setAdapter(spinnerInformeArrayAdapter);
    }


}