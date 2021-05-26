package com.uligra.practica2;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.ListView;

import androidx.cursoradapter.widget.SimpleCursorAdapter;

public class XBoxActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.activity_x_box, frameLayout);
        ListView xbox = findViewById(R.id.xboxlist);
        SQLiteOpenHelper gameDbHelper = new GameDataHelper(this) ;
        SQLiteDatabase db = gameDbHelper.getReadableDatabase();
        Cursor cursor = db.query("GAMES",
                new String[] {"_id", "COMPANY", "NAME", "PRICE"},
                "COMPANY = 'XBOX'",
                null,
                null, null, "DATE");
        SimpleCursorAdapter listAdapter = new SimpleCursorAdapter(
                this,
                R.layout.spinner_item,
                cursor,
                new String[]{"NAME","PRICE"},
                new int[] {R.id.textView2,R.id.textView});
        xbox.setAdapter(listAdapter);
    }

}