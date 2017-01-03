package com.example.joans.timetracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class AfegirProjecteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afegir_projecte);
        Button afegirProjecteOK = (Button) findViewById(R.id.addTaskOK);
        afegirProjecteOK.setOnClickListener(butoStartListener);
    }

    private View.OnClickListener butoStartListener = new View.OnClickListener() {
        public void onClick(View v) {
            Intent intent = new Intent(AfegirProjecteActivity.this, LlistaActivitatsActivity.class);
            startActivity(intent);
        }
    };

}


