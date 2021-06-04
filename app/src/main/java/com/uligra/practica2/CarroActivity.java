package com.uligra.practica2;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextClock;
import android.widget.TextView;

import androidx.cursoradapter.widget.SimpleCursorAdapter;


public class CarroActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.activity_carro, frameLayout);
        ListView carro = findViewById(R.id.carro);
        SQLiteOpenHelper gameDbHelper = new GameDataHelper(this) ;
        SQLiteDatabase db = gameDbHelper.getReadableDatabase();
        //relleno novedades
        Cursor cursor = db.query("GAMES",
                new String[] {"_id", "DEAL", "NAME", "PRICE", "CART"},
                "CART = 1",
                null,
                null, null, "PRICE", null);
        CarritoAdapter listAdapter = new CarritoAdapter(
                this,
                R.layout.cart_item,
                cursor,0);
        carro.setAdapter(listAdapter);
        cursor = db.query("GAMES",
                new String[] {"_id", "DEAL", "NAME", "PRICE", "CART"},
                "CART = 1",
                null,
                null, null, "PRICE", null);
        cursor.moveToFirst();
        TextView precio = (TextView) findViewById(R.id.precio);
        int p = 0;
        while (!cursor.isAfterLast()) {
            p = p + cursor.getInt(cursor.getColumnIndex("PRICE"));
            cursor.moveToNext();
        }
        precio.setText("Precio: "+ String.valueOf(p)+"€");
    }

    public void finalizar(View view) {
        Intent intent = new Intent(this, FinalizarCompraActivity.class);
        startActivity(intent);
    }

    public void quitarJuego(View view) {
        LinearLayout parent = (LinearLayout) view.getParent();
        String name = ((TextView)parent.findViewById(R.id.Nombre)).getText().toString();
        SQLiteOpenHelper gameDbHelper = new GameDataHelper(this) ;
        SQLiteDatabase db = gameDbHelper.getReadableDatabase();
        try{
            //db.update("GAMES", cv, "NAME = "+ name, null);
            db.execSQL("UPDATE GAMES SET CART = 0 WHERE NAME = '"+ name + "';");
        }
        catch (Exception e){
            String error =  e.getMessage().toString();
            Log.e(error, error);
        }
        ListView carro = findViewById(R.id.carro);
        Cursor cursor = db.query("GAMES",
                new String[] {"_id", "DEAL", "NAME", "PRICE", "CART"},
                "CART = 1",
                null,
                null, null, "PRICE", null);
        CarritoAdapter listAdapter = new CarritoAdapter(
                this,
                R.layout.cart_item,
                cursor,0);
        carro.setAdapter(listAdapter);
        cursor = db.query("GAMES",
                new String[] {"_id", "DEAL", "NAME", "PRICE", "CART"},
                "CART = 1",
                null,
                null, null, "PRICE", null);
        cursor.moveToFirst();
        TextView precio = (TextView) findViewById(R.id.precio);
        int p = 0;
        while (!cursor.isAfterLast()) {
            p = p + cursor.getInt(cursor.getColumnIndex("PRICE"));
            cursor.moveToNext();
        }
        precio.setText("Precio: "+ String.valueOf(p)+"€");
    }
    public void clickGame(View view) {
        Intent intent = new Intent(this, DetalleActivity.class);
        LinearLayout parent = (LinearLayout) view.getParent();
        String name = ((TextView)parent.findViewById(R.id.Nombre)).getText().toString();
        intent.putExtra("NAME", name);
        startActivity(intent);
    }
}