package com.uligra.practica2;

import android.os.Bundle;
import android.widget.LinearLayout;

public class
OfertasActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.activity_ofertas, frameLayout);
        LinearLayout linearLayout = findViewById(R.id.drawerlayout);
    }
}