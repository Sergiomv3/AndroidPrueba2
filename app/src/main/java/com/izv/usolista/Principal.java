package com.izv.usolista;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;


public class Principal extends Activity {

    private ArrayList<String> datosv2;
    private AdaptadorArrayList aal;

    /*************************************************/
    /*                                               */
    /*                 métodos on...                 */
    /*                                               */
    /*************************************************/

    /* al seleccionar opción del menú contextual */
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.action_anadir){
            return anadir();
        }
        return super.onContextItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_principal);
        initComponents();
    }

    /* al hacer long clic sobre item del listview */
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.principal, menu);
    }

    /* al pulsar la tecla menú */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.principal, menu);
        return true;
    }

    /* al seleccionar opción del menú */
    /* si yo proceso el clic: true */
    /* si no super */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return settings();
        } else if(id == R.id.action_anadir){
            return anadir();
        }
        return super.onOptionsItemSelected(item);
    }

    /*************************************************/
    /*                                               */
    /*                   auxiliares                  */
    /*                                               */
    /*************************************************/

    private void initComponents(){
        String datos[] = {"uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve", "diez", "once", "doce", "trece", "catorce", "quince", "dieciseis"};
        datosv2 = new ArrayList<String>();
        for(String s: datos){
            datosv2.add(s);
        }
        aal = new AdaptadorArrayList(this, R.layout.lista_detalle, datosv2);
        final ListView lv = (ListView) findViewById(R.id.lvLista);
        lv.setAdapter(aal);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView,
                                    View view, int i, long l) {
                Object o=view.getTag();
                AdaptadorArrayList.ViewHolder vh;
                vh=(AdaptadorArrayList.ViewHolder)o;
                tostada(vh.tv1.getText().toString());
                /*TextView tv = (TextView)view.findViewById(R.id.tvTexto1);
                if(tv==null){
                    tostada("no sirve");
                } else{
                    tostada(tv.getText().toString());
                }*/
                tostada(datosv2.get(i)+" "+lv.getItemAtPosition(i));
            }
        });
        /*lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                tostada("posicion: "+i);
                return true;
            }
        });*/
        registerForContextMenu(lv);

    }

    private void tostada(String s){
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    /*************************************************/
    /*                                               */
    /*                   clic                        */
    /*                                               */
    /*************************************************/

    private boolean anadir(){
        datosv2.add("ultimo");
        aal.notifyDataSetChanged();
        tostada("elemento añadido");
        return true;
    }

    private boolean settings(){
        return true;
    }

    /*************************************************/
    /*                                               */
    /*                   menu                        */
    /*                                               */
    /*************************************************/



    /*************************************************/
    /*                                               */
    /*               clases internas                 */
    /*                                               */
    /*************************************************/
}