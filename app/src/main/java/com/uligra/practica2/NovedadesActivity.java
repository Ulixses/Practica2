package com.uligra.practica2;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.cursoradapter.widget.SimpleCursorAdapter;
import androidx.fragment.app.Fragment;

public class NovedadesActivity extends Fragment {

    public NovedadesActivity(){
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.activity_novedades, container, false);
        //getLayoutInflater().inflate(R.layout.activity_novedades, frameLayout);
        ListView novedades = view.findViewById(R.id.novedadeslist);
        SQLiteOpenHelper gameDbHelper = new GameDataHelper(getContext());
        SQLiteDatabase db = gameDbHelper.getReadableDatabase();
        Cursor cursor = db.query("GAMES",
                new String[] {"_id", "Cast( DATE as date ) as date_", "NAME", "PRICE"},
                null,
                null,
                null, null, "date_","6");
        GameCursorAdapter listAdapter = new GameCursorAdapter(
                getContext(),
                R.layout.game_item,
                cursor,0);
        novedades.setAdapter(listAdapter);

        return view;
    }
}