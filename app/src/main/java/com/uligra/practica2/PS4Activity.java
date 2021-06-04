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

public class PS4Activity extends Fragment {

    public PS4Activity(){
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.activity_p_s4, container, false);
        ListView ps5 = view.findViewById(R.id.ps4list);
        SQLiteOpenHelper gameDbHelper = new GameDataHelper(getContext()) ;
        SQLiteDatabase db = gameDbHelper.getReadableDatabase();
        Cursor cursor = db.query("GAMES",
                new String[] {"_id", "COMPANY", "NAME", "PRICE"},
                "COMPANY = 'PS5'",
                null,
                null, null, "DATE");
        GameCursorAdapter listAdapter = new GameCursorAdapter(
                getContext(),
                R.layout.game_item,
                cursor,0);
        ps5.setAdapter(listAdapter);
        return view;
    }


}