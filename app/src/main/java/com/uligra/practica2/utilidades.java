package com.uligra.practica2;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;

public class utilidades {
    public static boolean botonesToolBar(MenuItem item, Context context){
        switch (item.getItemId()) {
            case R.id.action_carro:
                Intent intent = new Intent(context, CarroActivity.class);
                context.startActivity(intent);
                return true;
        }
        return false;
    }
}
