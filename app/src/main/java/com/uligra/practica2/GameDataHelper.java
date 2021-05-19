package com.uligra.practica2;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class GameDataHelper extends SQLiteOpenHelper {
    private static final String DBNAME = "gamesdatabase";
    private static final int DBVERSION = 1;


    public GameDataHelper(Context context) {
        super(context, DBNAME, null, DBVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE GAMES ("
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "NAME TEXT, "
                + "COMPANY TEXT, "
                + "DESCRIPTION TEXT,"
                + "DEAL INTEGER,"
                + "IMAGE_ID INTEGER, "
                + "PRICE REAL,"
                + "DATE TEXT); ");
        Videojuegos v = new Videojuegos("TLOU2", "Juego de zombies mazo guapo", Videojuegos.Consola.PS5, 10.5, new SimpleDateFormat("10-2-2020"), 0, 1);
        addVideogame(db,v);
    }



    public static void addVideogame (SQLiteDatabase db, Videojuegos v)
    {
        ContentValues gamesData = new ContentValues();
        gamesData.put("NAME", v.titulo);
        gamesData.put("COMPANY", v.plataforma.name());
        gamesData.put("DESCRIPTION", v.descripcion);
        gamesData.put("DEAL", v.oferta);
        gamesData.put("IMAGE_ID", v.img);
        gamesData.put("PRICE", v.precio);
        gamesData.put("DATE", v.fecha.toString());
        db.insert("GAMES", null, gamesData);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        if (oldVersion == 1 && newVersion == 2)
        {
            db.execSQL("ALTER TABLE GAMES ADD COLUMN FAVORITE BIT DEFAULT 0");
        }
    }
}
