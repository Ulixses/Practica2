package com.uligra.practica2;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.cursoradapter.widget.SimpleCursorAdapter;

public class
OfertasActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.activity_ofertas, frameLayout);
        ListView ofertas = findViewById(R.id.ofertaslist);
        SQLiteOpenHelper gameDbHelper = new GameDataHelper(this) ;
        SQLiteDatabase db = gameDbHelper.getReadableDatabase();
        Cursor cursor = db.query("GAMES",
                new String[] {"_id", "DEAL", "NAME", "PRICE"},
                "DEAL = 1",
                null,
                null, null, null);
        SimpleCursorAdapter listAdapter = new SimpleCursorAdapter(
                this,
                R.layout.spinner_item,
                cursor,
                new String[]{"NAME","PRICE"},
                new int[] {R.id.textView2,R.id.textView});
        ofertas.setAdapter(listAdapter);
    }
}