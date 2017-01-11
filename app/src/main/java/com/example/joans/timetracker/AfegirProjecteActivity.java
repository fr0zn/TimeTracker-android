package com.example.joans.timetracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AfegirProjecteActivity extends AppCompatActivity {
    public static final String CREAR_PROJECTE = "Info_Crear_projecte";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afegir_projecte);
        Button afegirProjecteOK = (Button) findViewById(R.id.addTaskOK);
        afegirProjecteOK.setOnClickListener(butoStartListener);
    }

    private View.OnClickListener butoStartListener = new View.OnClickListener() {
        public void onClick(View v) {

            // Recopilació de dades per enviar per broadcast l'intent
            Intent nouProjecte = new Intent(AfegirProjecteActivity.CREAR_PROJECTE);
            EditText titolEntrada = (EditText) findViewById(R.id.titol);
            EditText descripcioEntrada = (EditText) findViewById(R.id.descripcio);
            nouProjecte.putExtra("titol", titolEntrada.getText().toString());
            nouProjecte.putExtra("descripcio", descripcioEntrada.getText().toString());
            nouProjecte.putExtra("opcio", CREAR_PROJECTE);
            sendBroadcast(nouProjecte);


            //Desde aqui el gestor lo recibe wtf
            Intent intent2 = new Intent(AfegirProjecteActivity.this, LlistaActivitatsActivity.class);
            startActivity(intent2);
        }
    };
}


