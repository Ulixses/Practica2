package com.uligra.practica2;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TableLayout;

import androidx.cursoradapter.widget.SimpleCursorAdapter;


public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.activity_main, frameLayout);
        ListView novedades = findViewById(R.id.novedades);
        ListView ofertas = findViewById(R.id.ofertas);
        ListView ps5 = findViewById(R.id.ps4);
        ListView xbox = findViewById(R.id.xbox);
        SQLiteOpenHelper gameDbHelper = new GameDataHelper(this) ;
        SQLiteDatabase db = gameDbHelper.getReadableDatabase();
        //relleno novedades
        Cursor cursor = db.query("GAMES",
                new String[] {"_id", "Cast( DATE as date ) as date_", "NAME", "PRICE"},
                null,
                null,
                null, null, "date_", "5");
        SimpleCursorAdapter listAdapter = new SimpleCursorAdapter(
                this,
                R.layout.spinner_item,
                cursor,
                new String[]{"NAME","PRICE"},
                new int[] {R.id.textView2,R.id.textView});
        novedades.setAdapter(listAdapter);
        //relleno ofertas
        cursor = db.query("GAMES",
                new String[] {"_id", "DEAL", "NAME", "PRICE"},
                "DEAL = 1",
                null,
                null, null, null, "5");
        listAdapter = new SimpleCursorAdapter(
                this,
                R.layout.spinner_item,
                cursor,
                new String[]{"NAME","PRICE"},
                new int[] {R.id.textView2,R.id.textView});
        ofertas.setAdapter(listAdapter);
        //relleno ps5
        cursor = db.query("GAMES",
                new String[] {"_id", "COMPANY", "NAME", "PRICE"},
                "COMPANY = 'PS5'",
                null,
                null, null, "date(DATE)", "5");
        listAdapter = new SimpleCursorAdapter(
                this,
                R.layout.spinner_item,
                cursor,
                new String[]{"NAME","PRICE"},
                new int[] {R.id.textView2,R.id.textView});
        ps5.setAdapter(listAdapter);
        //relleno xbox
        cursor = db.query("GAMES",
                new String[] {"_id", "COMPANY", "NAME", "PRICE"},
                "COMPANY = 'XBOX'",
                null,
                null, null, "DATE","5");
        listAdapter = new SimpleCursorAdapter(
                this,
                R.layout.spinner_item,
                cursor,
                new String[]{"NAME","PRICE"},
                new int[] {R.id.textView2,R.id.textView});
        xbox.setAdapter(listAdapter);
    }

    public void clickNovedades(View view) {
        ListView novedades = findViewById(R.id.novedades);
        if(novedades.getVisibility() == View.GONE) {
            novedades.setVisibility(View.VISIBLE);
        }else{
            novedades.setVisibility(View.GONE);
        }
    }

    public void clickOfertas(View view) {
        ListView ofertas = findViewById(R.id.ofertas);
        if(ofertas.getVisibility() == View.GONE) {
            ofertas.setVisibility(View.VISIBLE);
        }else{
            ofertas.setVisibility(View.GONE);
        }
    }

    public void clickPs4(View view) {
        ListView ps5 = findViewById(R.id.ps4);
        if(ps5.getVisibility() == View.GONE) {
            ps5.setVisibility(View.VISIBLE);
        }else{
            ps5.setVisibility(View.GONE);
        }
    }

    public void clickXbox(View view) {
        ListView xbox = findViewById(R.id.xbox);
        if(xbox.getVisibility() == View.GONE) {
            xbox.setVisibility(View.VISIBLE);
        }else{
            xbox.setVisibility(View.GONE);
        }
    }
}