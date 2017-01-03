package com.example.joans.timetracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class InfoProjecteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_projecte);
        Button tornarOK = (Button) findViewById(R.id.addTaskOK);
        tornarOK.setOnClickListener(butoStartListener);
    }

    private View.OnClickListener butoStartListener = new View.OnClickListener() {
        public void onClick(View v) {
            Intent intent = new Intent(InfoProjecteActivity.this, LlistaActivitatsActivity.class);
            startActivity(intent);
        }
    };

}


