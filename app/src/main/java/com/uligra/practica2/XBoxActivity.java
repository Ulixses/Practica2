package com.uligra.practica2;

import android.os.Bundle;

public class XBoxActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.activity_x_box, frameLayout);
    }

}