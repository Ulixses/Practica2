package com.uligra.practica2;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TableLayout;

import androidx.cursoradapter.widget.SimpleCursorAdapter;


public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.activity_main, frameLayout);
        Spinner novedades = findViewById(R.id.novedades);
        Spinner ofertas = findViewById(R.id.ofertas);
        Spinner ps5 = findViewById(R.id.ps4);
        Spinner xbox = findViewById(R.id.xbox);
        SQLiteOpenHelper gameDbHelper = new GameDataHelper(this) ;
        SQLiteDatabase db = gameDbHelper.getReadableDatabase();
        //relleno novedades
        Cursor cursor = db.query("GAMES",
                new String[] {"_id", "DATE", "NAME", "PRICE"},
                null,
                null,
                null, null, "DATE");
        SimpleCursorAdapter listAdapter = new SimpleCursorAdapter(
                this,
                android.R.layout.simple_list_item_1,
                cursor,
                new String[]{"NAME","PRICE"},
                new int[] {android.R.id.text1});
        novedades.setAdapter(listAdapter);
        //relleno ofertas
        cursor = db.query("GAMES",
                new String[] {"_id", "DEAL", "NAME", "PRICE"},
                "DEAL = 1",
                null,
                null, null, null);
        listAdapter = new SimpleCursorAdapter(
                this,
                android.R.layout.simple_list_item_1,
                cursor,
                new String[]{"NAME","PRICE"},
                new int[] {android.R.id.text1});
        ofertas.setAdapter(listAdapter);
        //relleno ps4
        cursor = db.query("GAMES",
                new String[] {"_id", "COMPANY", "NAME", "PRICE"},
                "COMPANY = PS5",
                null,
                null, null, "DATE");
        listAdapter = new SimpleCursorAdapter(
                this,
                android.R.layout.simple_list_item_1,
                cursor,
                new String[]{"NAME","PRICE"},
                new int[] {android.R.id.text1});
        ps5.setAdapter(listAdapter);
        cursor = db.query("GAMES",
                new String[] {"_id", "COMPANY", "NAME", "PRICE"},
                "COMPANY = XBOX",
                null,
                null, null, "DATE");
        listAdapter = new SimpleCursorAdapter(
                this,
                android.R.layout.simple_list_item_1,
                cursor,
                new String[]{"NAME","PRICE"},
                new int[] {android.R.id.text1});
        ps5.setAdapter(listAdapter);
    }

}