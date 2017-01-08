package com.example.joans.timetracker;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.*;

public class NouInformeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nou_informe);
        Spinner spinnerInformePeriode = (Spinner) findViewById(R.id.period);
        ArrayAdapter<String> spinnerInformePeriodeArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.periods));
        spinnerInformePeriode.setAdapter(spinnerInformePeriodeArrayAdapter);

        Spinner spinnerInformeLong = (Spinner) findViewById(R.id.tipus);
        ArrayAdapter<String> spinnerInformeLongArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.info_long));
        spinnerInformeLong.setAdapter(spinnerInformeLongArrayAdapter);

        Spinner spinnerInformeType = (Spinner) findViewById(R.id.format);
        ArrayAdapter<String> spinnerInformeTypeArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.info_types));
        spinnerInformeType.setAdapter(spinnerInformeTypeArrayAdapter);
    }


}