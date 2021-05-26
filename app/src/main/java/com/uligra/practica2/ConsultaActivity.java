package com.uligra.practica2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ConsultaActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.activity_consulta, frameLayout);
    }

    public void send(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");


        TextView nombre = findViewById(R.id.nombre);
        TextView consulta = findViewById(R.id.consulta);

        intent.putExtra(Intent.EXTRA_SUBJECT, "Consulta de:" + nombre.getText().toString());
        intent.putExtra(Intent.EXTRA_TEXT, consulta.getText().toString());
        intent.putExtra(Intent.EXTRA_EMAIL, R.string.correo);

        Intent intentChooser = Intent.createChooser(intent, "Selecciona la app para enviar:");
        startActivity(intentChooser);
    }

}