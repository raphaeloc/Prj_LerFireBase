package com.example.rolivech.prj_lerfirebase.totem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class VisitantesAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<HMAux> dados;
    private int resource;
    private LayoutInflater layoutInflater;


    public VisitantesAdapter(Context context, ArrayList<HMAux> dados, int resource) {
        this.context = context;
        this.dados = dados;
        this.resource = resource;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return dados.size();
    }

    @Override
    public Object getItem(int position) {
        return dados.get(position);
    }

    @Override
    public long getItemId(int position) {
        HMAux visitante = dados.get(position);

        return Long.parseLong(visitante.get("telefone"));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null){
            convertView = layoutInflater.inflate(resource,parent,false);
        }

        TextView tv_nome = convertView.findViewById(android.R.id.text1);

        HMAux visitante = dados.get(position);


        tv_nome.setText(visitante.get("visitante"));

        return convertView;
    }
}
