package com.uligra.practica2;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.cursoradapter.widget.SimpleCursorAdapter;

public class PS4Activity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.activity_p_s4, frameLayout);
        ListView ps5 = findViewById(R.id.ps4list);
        SQLiteOpenHelper gameDbHelper = new GameDataHelper(this) ;
        SQLiteDatabase db = gameDbHelper.getReadableDatabase();
        Cursor cursor = db.query("GAMES",
                new String[] {"_id", "COMPANY", "NAME", "PRICE"},
                "COMPANY = 'PS5'",
                null,
                null, null, "DATE");
        GameCursorAdapter listAdapter = new GameCursorAdapter(
                this,
                R.layout.game_item,
                cursor,0);
        ps5.setAdapter(listAdapter);
    }
    public void aniadirJuegoACarrito(View view) {
        LinearLayout parent = (LinearLayout) view.getParent();
        String name = ((TextView)parent.findViewById(R.id.Nombre)).getText().toString();
        SQLiteOpenHelper gameDbHelper = new GameDataHelper(this) ;
        SQLiteDatabase db = gameDbHelper.getReadableDatabase();
        try{
            //db.update("GAMES", cv, "NAME = "+ name, null);
            db.execSQL("UPDATE GAMES SET CART = 1 WHERE NAME = '"+ name + "';");
        }
        catch (Exception e){
            String error =  e.getMessage().toString();
            Log.e(error, error);
        }
    }
    public void clickGame(View view) {
        Intent intent = new Intent(this, DetalleActivity.class);
        LinearLayout parent = (LinearLayout) view.getParent();
        String name = ((TextView)parent.findViewById(R.id.Nombre)).getText().toString();
        intent.putExtra("NAME", name);
        startActivity(intent);
    }

}