package com.izv.usolista;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AdaptadorArrayList extends ArrayAdapter<String>{

    private Context contexto;
    private ArrayList<String> lista;
    private int recurso;
    private Random r = new Random();
    private static LayoutInflater i;

    public AdaptadorArrayList(Context context, int resource, ArrayList<String> objects) {
        super(context, resource, objects);
        this.contexto = context;
        this.lista = objects;
        this.recurso = resource;
        this.i  = (LayoutInflater) contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.v("LOG",""+lista.size());
        ViewHolder vh = null;
        if(convertView == null){
            convertView = i.inflate(recurso, null);
            vh = new ViewHolder();
            vh.tv1 = (TextView) convertView.findViewById(R.id.tvTexto1);
            vh.tv2 = (TextView) convertView.findViewById(R.id.tvTexto2);
            convertView.setTag(vh);
        }
        else{
            vh = (ViewHolder)convertView.getTag();
        }
        vh.tv1.setText(lista.get((lista.size()-1)-position));
        vh.tv2.setText(position+"");
        return convertView;
    }

    public static class ViewHolder {
        public TextView tv1, tv2;
    }
}