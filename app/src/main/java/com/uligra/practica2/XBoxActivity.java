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

public class XBoxActivity extends Fragment {

    public XBoxActivity(){
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.activity_x_box, container, false);
        ListView xbox = view.findViewById(R.id.xboxlist);
        SQLiteOpenHelper gameDbHelper = new GameDataHelper(getContext()) ;
        SQLiteDatabase db = gameDbHelper.getReadableDatabase();
        Cursor cursor = db.query("GAMES",
                new String[] {"_id", "COMPANY", "NAME", "PRICE"},
                "COMPANY = 'XBOX'",
                null,
                null, null, "DATE");
        GameCursorAdapter listAdapter = new GameCursorAdapter(
                getContext(),
                R.layout.game_item,
                cursor,0);
        xbox.setAdapter(listAdapter);
        return view;
    }

}