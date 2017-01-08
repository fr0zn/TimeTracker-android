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
import android.app.*;
import java.util.Calendar;
import android.text.format.DateFormat;
import android.widget.TimePicker;
import android.support.v4.app.DialogFragment;

import java.util.ArrayList;

import nucli.Activitat;
import nucli.Projecte;
import nucli.Tasca;

public class AfegirTascaActivity extends AppCompatActivity {

    public static class TimePickerFragment extends DialogFragment
            implements TimePickerDialog.OnTimeSetListener {

        private Integer viewID;

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current time as the default values for the picker
            final Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);

            Bundle args = getArguments();
            viewID = args.getInt("id", 0);

            // Create a new instance of TimePickerDialog and return it
            return new TimePickerDialog(getActivity(), this, hour, minute,
                    DateFormat.is24HourFormat(getActivity()));
        }

        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            String timeString = hourOfDay+":"+minute;
            TextView e1 = (TextView)getActivity().findViewById(viewID);
            e1.setText(timeString);
        }
    }

    public void showTimePickerDialog(View v) {
        DialogFragment newFragment = new TimePickerFragment();
        Bundle args = new Bundle();
        args.putInt("id", v.getId());
        newFragment.setArguments(args);
        newFragment.show(getSupportFragmentManager(), "timePicker");
    }

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






