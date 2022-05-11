package com.example.control5;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class CamaraActivity extends AppCompatActivity {
    ImageView imagen;
    int requestCode=1;


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camara);
        confirmarCamara();

        Button boton = (Button) findViewById(R.id.boton_foto);
        imagen = (ImageView) findViewById(R.id.imagen_foto);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 0);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap bitmap = (Bitmap) data.getExtras().get("data");
        imagen.setImageBitmap(bitmap);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void confirmarCamara(){
        int permiso = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA);
        if(permiso == PackageManager.PERMISSION_GRANTED){
            Toast.makeText(this, "Permiso concedido", Toast.LENGTH_SHORT).show();
        }else{
            requestPermissions(new String[] {Manifest.permission.CAMERA}, requestCode);
        }
    }
}