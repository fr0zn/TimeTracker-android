package com.example.joans.timetracker;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static com.example.joans.timetracker.R.id.button;

public class NouInformeActivity extends AppCompatActivity {

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
        final Spinner spinnerInformePeriode = (Spinner) findViewById(R.id.period);
        spinnerInformePeriode.setSelection(3);
        DialogFragment newFragment = new NouInformeActivity.TimePickerFragment();
        Bundle args = new Bundle();
        args.putInt("id", v.getId());
        newFragment.setArguments(args);
        newFragment.show(getSupportFragmentManager(), "timePicker");
    }
    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener{

        private Integer viewID;

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current time as the default values for the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH)+1;//Because Month start at 0 index
            int day = c.get(Calendar.DAY_OF_MONTH);

            Bundle args = getArguments();
            viewID = args.getInt("id", 0);

            // Create a new instance of TimePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year,month,day);
        }
        @Override
        public void onDateSet(DatePicker view, int year, int month,int day) {
            String timeString = day+"/"+month+"/"+year;
            TextView e1 = (TextView)getActivity().findViewById(viewID);
            e1.setText(timeString);
        }
    }

    public void showDatePickerDialog(View v) {
        final Spinner spinnerInformePeriode = (Spinner) findViewById(R.id.period);
        spinnerInformePeriode.setSelection(3);
        DialogFragment newFragment = new NouInformeActivity.DatePickerFragment();
        Bundle args = new Bundle();
        args.putInt("id", v.getId());
        newFragment.setArguments(args);
        newFragment.show(getSupportFragmentManager(), "timePicker");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nou_informe);
        final Spinner spinnerInformePeriode = (Spinner) findViewById(R.id.period);
        ArrayAdapter<String> spinnerInformePeriodeArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.periods));
        spinnerInformePeriode.setAdapter(spinnerInformePeriodeArrayAdapter);

        spinnerInformePeriode.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                Button buttonDesHora = (Button) findViewById(R.id.button2);
                Button buttonDesData = (Button) findViewById(R.id.button5);
                Button buttonFinsHora = (Button) findViewById(R.id.button6);
                Button buttonFinsData = (Button) findViewById(R.id.button7);
                Calendar calendar = Calendar.getInstance();

                SimpleDateFormat hora = new SimpleDateFormat("HH:mm");
                SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
                Date actualData = new Date();
                Date dataPrevia;

                switch (spinnerInformePeriode.getSelectedItem().toString()){
                    case "Setmana passada":
                        calendar.add(Calendar.WEEK_OF_YEAR,-1);
                        dataPrevia=calendar.getTime();
                        buttonFinsHora.setText(hora.format(actualData));
                        buttonFinsData.setText(data.format(actualData));
                        buttonDesHora.setText(hora.format(dataPrevia));
                        buttonDesData.setText(data.format(dataPrevia));
                        break;
                    case "Mes passat":
                        calendar.add(Calendar.MONTH,-1);
                        dataPrevia=calendar.getTime();;
                        buttonFinsHora.setText(hora.format(actualData));
                        buttonFinsData.setText(data.format(actualData));
                        buttonDesHora.setText(hora.format(dataPrevia));
                        buttonDesData.setText(data.format(dataPrevia));
                        break;
                    case "Any passat":
                        calendar.add(Calendar.YEAR,-1);
                        dataPrevia=calendar.getTime();
                        buttonFinsHora.setText(hora.format(actualData));
                        buttonFinsData.setText(data.format(actualData));
                        buttonDesHora.setText(hora.format(dataPrevia));
                        buttonDesData.setText(data.format(dataPrevia));
                        break;
                    case "Personalitzat":
                        buttonFinsHora.setText(hora.format(actualData));
                        buttonFinsData.setText(data.format(actualData));
                        buttonDesHora.setText(hora.format(actualData));
                        buttonDesData.setText(data.format(actualData));
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }
        });

        Spinner spinnerInformeLong = (Spinner) findViewById(R.id.tipus);
        ArrayAdapter<String> spinnerInformeLongArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.info_long));
        spinnerInformeLong.setAdapter(spinnerInformeLongArrayAdapter);

        Spinner spinnerInformeType = (Spinner) findViewById(R.id.format);
        ArrayAdapter<String> spinnerInformeTypeArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.info_types));
        spinnerInformeType.setAdapter(spinnerInformeTypeArrayAdapter);
    }


}