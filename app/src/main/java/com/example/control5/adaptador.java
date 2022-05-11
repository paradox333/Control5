package com.example.control5;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class adaptador extends BaseAdapter {
    private static LayoutInflater inflater = null;
    Context contexto;
    String [][] datos;
    int[] datosImg;

    static class ViewHolder{
        private TextView Text_1;
        private TextView Text_2;
        private TextView Text_3;
        private ImageView autos;

        public ViewHolder(View vista){
            Text_1 = (TextView) vista.findViewById(R.id.marca);
            Text_2 = (TextView) vista.findViewById(R.id.modelo);
            Text_3 = (TextView) vista.findViewById(R.id.año);
            autos = (ImageView) vista.findViewById(R.id.auto);
        }



    }

    public adaptador (Context contexto, String[][] datos, int[] imagenes){
        this.contexto = contexto;
        this.datos = datos;
        this.datosImg = imagenes;
        inflater = (LayoutInflater)  contexto.getSystemService(contexto.LAYOUT_INFLATER_SERVICE);
    }

    public View getView(int i, View convertView, ViewGroup viewGroup) {
        ViewHolder holder;
        View vista = convertView;
        if(vista == null){
            LayoutInflater inflate = LayoutInflater.from(contexto);
            vista = inflate.inflate(R.layout.elementos_lista,null);
            holder = new ViewHolder(vista);
            vista.setTag(holder);
        }
        else{
            holder = (ViewHolder) vista.getTag();
        }

        holder.Text_1.setText(datos[i][0]);
        holder.Text_2.setText(datos[i][1]);
        holder.Text_3.setText(datos[i][2]);
        holder.autos.setImageResource(datosImg[i]);

        return vista;
    }

    public int getCount(){return datosImg.length;
    }

    public Object getItem(int i){
        final View vista = inflater.inflate(R.layout.elementos_lista, null);
        ImageView autos = (ImageView) vista.findViewById(R.id.auto);
        autos.setImageResource(datosImg[i]);
        return datosImg[i];
    }

    @Override
    public long getItemId(int i){return 0;}

}
