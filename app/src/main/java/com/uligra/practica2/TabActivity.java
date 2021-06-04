package com.uligra.practica2;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class TabActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        getLayoutInflater().inflate(R.layout.activity_tab, frameLayout);

        CategoriesAdapter adapter = new CategoriesAdapter(getSupportFragmentManager(), this);

        ViewPager pager = findViewById(R.id.viewpager);
        pager.setAdapter(adapter);

        TabLayout tab = (TabLayout) findViewById(R.id.tablayout);
        tab.setupWithViewPager(pager);
        Bundle bundle = getIntent().getExtras();
        int tabID = bundle.getInt("TAB");
        pager.setCurrentItem(tabID);
    }

    public void aniadirJuegoACarrito(View view) {
        LinearLayout parent = (LinearLayout) view.getParent();
        String name = ((TextView)parent.findViewById(R.id.Nombre)).getText().toString();
        SQLiteOpenHelper gameDbHelper = new GameDataHelper(this) ;
        SQLiteDatabase db = gameDbHelper.getReadableDatabase();
        try{
            db.execSQL("UPDATE GAMES SET CART = 1 WHERE NAME = '"+ name + "';");
        }
        catch (Exception e){
            String error =  e.getMessage().toString();
            Log.e(error, error);
        }
    }
}