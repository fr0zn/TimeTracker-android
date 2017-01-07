package com.example.joans.timetracker;

import android.content.IntentFilter;
import android.util.Log;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class AfegirTascaActivity extends AppCompatActivity {

    public static final String INFO_CREAR_TASCA = "Info_Crear_tasca";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afegir_tasca);
        Button afegirTascaOK = (Button) findViewById(R.id.addTaskOK);
        afegirTascaOK.setOnClickListener(AfegirTascaOKListener);
        startService(new Intent(this, GestorArbreActivitats.class));
    }

    private View.OnClickListener AfegirTascaOKListener = new View.OnClickListener() {
        public void onClick(View v) {

            // Recopilació de dades per enviar per broadcast l'intent
           /* Intent novaTasca = new Intent(AfegirTascaActivity.INFO_CREAR_TASCA);
            EditText titolEntrada = (EditText)findViewById(R.id.titol);
            EditText descripcioEntrada = (EditText)findViewById(R.id.titol);
            novaTasca.putExtra("titol", titolEntrada.getText().toString());
            novaTasca.putExtra("descripcio", descripcioEntrada.getText().toString());
            novaTasca.putExtra("opcio", INFO_CREAR_TASCA);
            sendBroadcast(novaTasca);
            */

            //Desde aqui el gestor lo recibe wtf
            Intent intent2 = new Intent(AfegirTascaActivity.this, LlistaActivitatsActivity.class);
            startActivity(intent2);


        }
    };



}


