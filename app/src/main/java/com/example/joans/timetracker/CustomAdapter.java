package com.example.joans.timetracker;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.*;
import android.widget.*;
import java.util.*;
import android.app.Activity;
import android.content.Context;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import java.util.ArrayList;
import java.util.List;
import android.view.View.OnClickListener;




public class CustomAdapter extends ArrayAdapter<DadesActivitat> {
    CustomAdapter(Context context, int layoutID, List<DadesActivitat> row){
        super(context, layoutID, row);
        this.customContext = context;
        inflater = LayoutInflater.from(context);
        llistaDadesActivitats = row;
    }
    private Context customContext;
    private LayoutInflater inflater;
    private List<DadesActivitat> llistaDadesActivitats;
    @Override
    public View getView(int position, final View convertView, ViewGroup parent) {
        LayoutInflater customInflater= (LayoutInflater) customContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View customView = customInflater.inflate(R.layout.custom_listview, null);
        DadesActivitat  singleItem = getItem(position);
        ImageView iconaProjecte = (ImageView) customView.findViewById(R.id.carpeta_projecte);
        TextView dadesProjecte = (TextView) customView.findViewById(R.id.dades_activitat);
        final ImageButton switcher = (ImageButton) customView.findViewById(R.id.switch1);
        switcher.setTag(position);
        switcher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                int position=(Integer)arg0.getTag();
                Log.d("ADAPTER","pos"+position);
                ((LlistaActivitatsActivity) customContext).start_task_at_position(switcher, position);
            }});

        if (singleItem.isTasca()){
            iconaProjecte.setVisibility(customView.INVISIBLE);

            if (!llistaDadesActivitats.get(position).isCronometreEngegat()) {
                switcher.setImageResource(R.drawable.play);
            } else {
                switcher.setImageResource(R.drawable.stop);
            }

        }else if (singleItem.isProjecte()){
            switcher.setVisibility(customView.INVISIBLE);
        }
        //iconaProjecte.setImageResource(R.drawable.folder_black);
        dadesProjecte.setText(singleItem.toString());
        return customView;
    }

    public long getItemId(int position) {
        return position;
    }

}
