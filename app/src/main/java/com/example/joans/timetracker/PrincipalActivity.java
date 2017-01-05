package com.example.joans.timetracker;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.*;
import android.support.design.widget.*;

public class PrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        FloatingActionButton afegirTasca = (FloatingActionButton) findViewById(R.id.addTask);
        afegirTasca.setOnClickListener(afegirTascaListener);
    }

    private View.OnClickListener afegirTascaListener = new View.OnClickListener() {
        public void onClick(View v) {
            Intent intent = new Intent(PrincipalActivity.this, AfegirTascaActivity.class);
            startActivity(intent);
        }
    };


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.accions_principals, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.informe:
                Intent intent = new Intent(PrincipalActivity.this, NouInformeActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }



}
