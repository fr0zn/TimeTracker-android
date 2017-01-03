package com.example.joans.timetracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AfegirTascaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afegir_tasca);
        Button afegirTascaOK = (Button) findViewById(R.id.addTaskOK);
        afegirTascaOK.setOnClickListener(butoStartListener);
    }

    private View.OnClickListener butoStartListener = new View.OnClickListener() {
        public void onClick(View v) {
            Intent intent = new Intent(AfegirTascaActivity.this, LlistaActivitatsActivity.class);
            startActivity(intent);
        }
    };

}


