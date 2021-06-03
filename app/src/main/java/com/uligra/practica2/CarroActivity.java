package com.uligra.practica2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class CarroActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.activity_carro, frameLayout);
    }

    public void finalizar(View view) {
        Intent intent = new Intent(this, FinalizarCompraActivity.class);
        startActivity(intent);
    }
}