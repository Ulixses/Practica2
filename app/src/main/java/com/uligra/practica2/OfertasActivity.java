package com.uligra.practica2;

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

public class OfertasActivity extends Fragment {

    public OfertasActivity(){
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.activity_ofertas, container, false);
        ListView ofertas = view.findViewById(R.id.ofertaslist);
        SQLiteOpenHelper gameDbHelper = new GameDataHelper(getContext()) ;
        SQLiteDatabase db = gameDbHelper.getReadableDatabase();
        Cursor cursor = db.query("GAMES",
                new String[] {"_id", "DEAL", "NAME", "PRICE"},
                "DEAL = 1",
                null,
                null, null, null);
        GameCursorAdapter listAdapter = new GameCursorAdapter(
                getContext(),
                R.layout.game_item,
                cursor,0);
        ofertas.setAdapter(listAdapter);
        return view;
    }
}