package com.example.joans.timetracker;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.*;
import android.support.design.widget.*;
import android.widget.AdapterView.*;

public class ActivitatPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        FloatingActionButton afegirTasca = (FloatingActionButton) findViewById(R.id.addTask);
        afegirTasca.setOnClickListener(addTaskListener);
    }

    private View.OnClickListener addTaskListener = new View.OnClickListener() {
        public void onClick(View v) {
            Intent intent = new Intent(ActivitatPrincipal.this, AfegirTasca.class);
            startActivity(intent);
        }
    };


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.accions_principals, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /*@Override
    public boolean onContextItemSelected(MenuItem item) {
        //AdapterContextMenuInfo info = (AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.informe:
                Intent intent = new Intent(ActivitatPrincipal.this, Informe.class);
                startActivity(intent);
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }*/

}
