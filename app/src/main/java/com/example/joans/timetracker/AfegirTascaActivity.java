package com.example.joans.timetracker;

import android.util.Log;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class AfegirTascaActivity extends AppCompatActivity {

    // Acció de crear tasca
    public static final String CREAR_TASCA = "Crear_tasca";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afegir_tasca);
        Button afegirTascaOK = (Button) findViewById(R.id.addTaskOK);
        afegirTascaOK.setOnClickListener(butoStartListener);
    }

    private View.OnClickListener butoStartListener = new View.OnClickListener() {
        public void onClick(View v) {
            // Recopilació de dades per enviar per broadcast l'intent
            Intent novaTasca = new Intent(AfegirTascaActivity.CREAR_TASCA);
            EditText titolEntrada = (EditText)findViewById(R.id.titol);
            EditText descripcioEntrada = (EditText)findViewById(R.id.titol);
            novaTasca.putExtra("titol", titolEntrada.getText().toString());
            novaTasca.putExtra("descripcio", descripcioEntrada.getText().toString());
            sendBroadcast(novaTasca);
            Log.d("tag", "entra11");
            Intent intent = new Intent(AfegirTascaActivity.this, LlistaActivitatsActivity.class);
            startActivity(intent);
        }
    };



}


