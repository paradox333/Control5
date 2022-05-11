package com.example.control5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class MasVendidosActivity extends AppCompatActivity {
    ListView Lista;
    String [][] autos={
            {"Testa", "Model 3", "2021"},
            {"Hummer", "H2", "2020"},
            {"Camaro SS", "Chevrolet", "2022"},
            {""},
    };

    int[] fotos={R.drawable.tesla_model3, R.drawable.hummer_h2, R.drawable.chevrolet_camaross};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mas_vendidos);
        Lista = (ListView) findViewById(R.id.principal);
        Lista.setAdapter(new adaptador(this, autos, fotos));
    }
}