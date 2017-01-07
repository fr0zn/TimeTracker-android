package com.example.joans.timetracker;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.util.Log;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;

import nucli.Activitat;
import nucli.Projecte;
import nucli.Tasca;

public class AfegirTascaActivity extends AppCompatActivity {

    public static final String CREAR_TASCA = "Info_Crear_tasca";
    private AfegirTascaActivity.Receptor receptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afegir_tasca);
        Button afegirTascaOK = (Button) findViewById(R.id.addTaskOK);
        afegirTascaOK.setOnClickListener(AfegirTascaOKListener);
    }

    private View.OnClickListener AfegirTascaOKListener = new View.OnClickListener() {
        public void onClick(View v) {

            // Recopilació de dades per enviar per broadcast l'intent
            /*Intent novaTasca = new Intent(AfegirTascaActivity.CREAR_TASCA);
            EditText titolEntrada = (EditText)findViewById(R.id.titol);
            EditText descripcioEntrada = (EditText)findViewById(R.id.titol);
            novaTasca.putExtra("titol", titolEntrada.getText().toString());
            novaTasca.putExtra("descripcio", descripcioEntrada.getText().toString());
            novaTasca.putExtra("opcio", CREAR_TASCA);
            sendBroadcast(novaTasca);*/


            //Desde aqui el gestor lo recibe wtf
            Intent intent2 = new Intent(AfegirTascaActivity.this, LlistaActivitatsActivity.class);
            startActivity(intent2);
        }
    };

    private class Receptor extends BroadcastReceiver {
        private final String tag = this.getClass().getCanonicalName();
        @Override
        public final void onReceive(final Context context,
                                    final Intent intent) {
            Log.d(tag, "onReceive");
            String accio = intent.getAction();
            if (accio.equals(GestorArbreActivitats.TASCA_CREADA)){
                Log.d(tag,"estoy here");
                Intent novaTasca = new Intent(AfegirTascaActivity.this, LlistaActivitatsActivity.class);
                startActivity(novaTasca);
            }
            Log.d(tag, "accio = " + accio);
        }
    }

    @Override
    public final void onResume() {
        Log.i("tag", "onResume");
        IntentFilter filter;
        filter = new IntentFilter();
        filter.addAction(GestorArbreActivitats.TASCA_CREADA);
        receptor = new AfegirTascaActivity.Receptor();
        registerReceiver(receptor, filter);
        startService(new Intent(this, GestorArbreActivitats.class));
        super.onResume();
        Log.i("tag", "final de onResume");
    }



}






