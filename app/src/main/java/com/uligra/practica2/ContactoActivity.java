package com.uligra.practica2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

public class ContactoActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.activity_contacto, frameLayout);
    }

    public void actionSiguiente(View view) {
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        int checkedRadioButtonId = radioGroup.getCheckedRadioButtonId();
        if (checkedRadioButtonId != -1) {
            if (checkedRadioButtonId == R.id.radio_consulta) {
                Intent intent = new Intent(this, ConsultaActivity.class);
                startActivity(intent);
            }
            else if(checkedRadioButtonId == R.id.radio_reclamacion){
                Intent intent = new Intent(this, ReclamacionActivity.class);
                startActivity(intent);
            }
        }
    }
}