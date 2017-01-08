package com.example.joans.timetracker;

import android.content.Context;
import android.view.*;
import android.widget.*;
import java.util.*;
import android.app.Activity;



public class CustomAdapter extends ArrayAdapter<DadesActivitat> {
    CustomAdapter(Context context, int layoutID, List<DadesActivitat> row){
        super(context, layoutID, row);
        this.customContext = context;
        inflater = LayoutInflater.from(context);
    }
    private Context customContext;
    private LayoutInflater inflater;
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater customInflater= (LayoutInflater) customContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View customView = customInflater.inflate(R.layout.custom_listview, null);
        DadesActivitat  singleItem = getItem(position);
        ImageView iconaProjecte = (ImageView) customView.findViewById(R.id.carpeta_projecte);
        TextView dadesProjecte = (TextView) customView.findViewById(R.id.dades_activitat);
        Switch switcher = (Switch) customView.findViewById(R.id.switch1);
        if (singleItem.isTasca()){
            iconaProjecte.setVisibility(customView.INVISIBLE);
        }else if (singleItem.isProjecte()){
            switcher.setVisibility(customView.INVISIBLE);
        }
        //iconaProjecte.setImageResource(R.drawable.folder_black);
        dadesProjecte.setText(singleItem.toString());
        return customView;
    }
}
