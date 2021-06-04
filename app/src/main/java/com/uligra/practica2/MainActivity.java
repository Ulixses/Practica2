package com.uligra.practica2;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.cursoradapter.widget.SimpleCursorAdapter;

import java.util.zip.Inflater;


public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.activity_main, frameLayout);
        LinearLayout novedades = findViewById(R.id.novedades);
        LinearLayout ofertas = findViewById(R.id.ofertas);
        LinearLayout ps5 = findViewById(R.id.ps4);
        LinearLayout xbox = findViewById(R.id.xbox);
        SQLiteOpenHelper gameDbHelper = new GameDataHelper(this) ;
        SQLiteDatabase db = gameDbHelper.getReadableDatabase();
        //relleno novedades
        Cursor cursor = db.query("GAMES",
                new String[] {"_id", "Cast( DATE as date ) as date_", "NAME", "PRICE"},
                null,
                null,
                null, null, "DATE", "3");
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            LayoutInflater inflater = LayoutInflater.from(this);
            View inflate = inflater.inflate(R.layout.spinner_item, null);
            TextView nombre = (TextView)  inflate.findViewById(R.id.Nombre);
            nombre.setText( cursor.getString(cursor.getColumnIndex("NAME")));
            TextView precio = (TextView)  inflate.findViewById(R.id.Precio);
            precio.setText( String.valueOf(cursor.getInt(cursor.getColumnIndex("PRICE")))+"€");
            novedades.addView(inflate);
            cursor.moveToNext();
        }
        //relleno ofertas
        cursor = db.query("GAMES",
                new String[] {"_id", "DEAL", "NAME", "PRICE"},
                "DEAL = 1",
                null,
                null, null, null, "3");
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            LayoutInflater inflater = LayoutInflater.from(this);
            View inflate = inflater.inflate(R.layout.spinner_item, null);
            TextView nombre = (TextView)  inflate.findViewById(R.id.Nombre);
            nombre.setText( cursor.getString(cursor.getColumnIndex("NAME")));
            TextView precio = (TextView)  inflate.findViewById(R.id.Precio);
            precio.setText( String.valueOf(cursor.getInt(cursor.getColumnIndex("PRICE")))+"€");
            ofertas.addView(inflate);
            cursor.moveToNext();
        }
        cursor = db.query("GAMES",
                new String[] {"_id", "COMPANY", "NAME", "PRICE"},
                "COMPANY = 'PS5'",
                null,
                null, null, "date(DATE)", "3");
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            LayoutInflater inflater = LayoutInflater.from(this);
            View inflate = inflater.inflate(R.layout.spinner_item, null);
            TextView nombre = (TextView)  inflate.findViewById(R.id.Nombre);
            nombre.setText( cursor.getString(cursor.getColumnIndex("NAME")));
            TextView precio = (TextView)  inflate.findViewById(R.id.Precio);
            precio.setText( String.valueOf(cursor.getInt(cursor.getColumnIndex("PRICE")))+"€");
            ps5.addView(inflate);
            cursor.moveToNext();
        }
        //relleno xbox
        cursor = db.query("GAMES",
                new String[] {"_id", "COMPANY", "NAME", "PRICE"},
                "COMPANY = 'XBOX'",
                null,
                null, null, "DATE","3");
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            LayoutInflater inflater = LayoutInflater.from(this);
            View inflate = inflater.inflate(R.layout.spinner_item, null);
            TextView nombre = (TextView)  inflate.findViewById(R.id.Nombre);
            nombre.setText( cursor.getString(cursor.getColumnIndex("NAME")));
            TextView precio = (TextView)  inflate.findViewById(R.id.Precio);
            precio.setText( String.valueOf(cursor.getInt(cursor.getColumnIndex("PRICE")))+"€");
            xbox.addView(inflate);
            cursor.moveToNext();
        }
    }

    public void clickNovedades(View view) {
        LinearLayout novedades = findViewById(R.id.novedades);
        if(novedades.getVisibility() == View.GONE) {
            novedades.setVisibility(View.VISIBLE);
        }else{
            novedades.setVisibility(View.GONE);
        }
    }

    public void clickOfertas(View view) {
        LinearLayout ofertas = findViewById(R.id.ofertas);
        if(ofertas.getVisibility() == View.GONE) {
            ofertas.setVisibility(View.VISIBLE);
        }else{
            ofertas.setVisibility(View.GONE);
        }
    }

    public void clickPs4(View view) {
        LinearLayout ps5 = findViewById(R.id.ps4);
        if(ps5.getVisibility() == View.GONE) {
            ps5.setVisibility(View.VISIBLE);
        }else{
            ps5.setVisibility(View.GONE);
        }
    }

    public void clickXbox(View view) {
        LinearLayout xbox = findViewById(R.id.xbox);
        if(xbox.getVisibility() == View.GONE) {
            xbox.setVisibility(View.VISIBLE);
        }else{
            xbox.setVisibility(View.GONE);
        }
    }

}