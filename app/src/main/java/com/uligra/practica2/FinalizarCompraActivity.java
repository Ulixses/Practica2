package com.uligra.practica2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FinalizarCompraActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.activity_finalizar_compra, frameLayout);
        //TODO: Extraer de BBDD el carro
    }

    public void comprar(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        TextView nombre = findViewById(R.id.nombre);
        TextView correo = findViewById(R.id.correo);
        TextView telefono = findViewById(R.id.telefono);
        TextView direccion = findViewById(R.id.direccion);
        intent.setType("text/plain");
        String extra = "Compra de: " + nombre.getText().toString() + '(' + telefono.getText().toString() + ") \n";
        extra+= "Dirección: " + direccion.getText().toString() + "\n";
        extra+= "Correo: " + correo.getText().toString() + "\n";
        intent.putExtra(Intent.EXTRA_SUBJECT, "Compra de: " + correo.getText().toString());
        intent.putExtra(Intent.EXTRA_TEXT, extra);
        intent.putExtra(Intent.EXTRA_EMAIL, R.string.correo);
        Intent intentChooser = Intent.createChooser(intent, "Selecciona la app para enviar:");
        startActivity(intentChooser);
    }
}