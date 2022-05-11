package com.example.control5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView Lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Lista = (ListView) findViewById(R.id.principal);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_en_activity,menu);
        return true;
    }
    public void ejecutar_mas_vistos(View view){
        Intent intent =new Intent(this, MasVendidosActivity.class);
        startActivity(intent);
    }
    public void ejecutar_camara(View view){
        Intent intent =new Intent(this, CamaraActivity.class);
        startActivity(intent);
    }
    public void ejecutar_graficos(View view){
        Intent intent =new Intent(this, GraficosActivity.class);
        startActivity(intent);
    }
    public boolean onOptionsItemSelected(MenuItem opcion){
        int id = opcion.getItemId();
        if(id == R.id.camara){
            ejecutar_camara(null);
            return true;
        }else if(id == R.id.mas_vendidos){
            ejecutar_mas_vistos(null);
            return true;
        }else if(id == R.id.graficas){
            ejecutar_graficos(null);
            return true;
        }
        return super.onOptionsItemSelected(opcion);
    }
}