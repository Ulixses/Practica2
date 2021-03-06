package com.uligra.practica2;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class GameDataHelper extends SQLiteOpenHelper {
    private static final String DBNAME = "gamesdatabase3";
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
                + "DATE TEXT,"
                + "CART INTEGER); ");
        Videojuegos v = new Videojuegos("TLOU2", "Juego de zombies mazo guapo", Videojuegos.Consola.PS5, 10.5, new String("10-2-2020"), 0, R.drawable.tlou);
        addVideogame(db,v);
         v = new Videojuegos("UNCHARTED", "Juego de aventuras mazo guapo", Videojuegos.Consola.PS5, 20.0, new String("11-2-2020"), 1, R.drawable.uncharted);
        addVideogame(db,v);
         v = new Videojuegos("ASSASIN CREED", "Juego de asesinos mazo guapo", Videojuegos.Consola.XBOX, 30.0, new String("10-2-2020"), 1, R.drawable.assassin);
        addVideogame(db,v);
        v = new Videojuegos("FIFA", "Juego de futbol mazo guapo", Videojuegos.Consola.XBOX, 40.0, new String("10-2-2020"), 1, R.drawable.fifa);
        addVideogame(db,v);
         v = new Videojuegos("RACHET AND CLANT", "Juego de ardilla mazo guapo", Videojuegos.Consola.PS5, 50.0, new String("10-2-2020"), 1, R.drawable.rac);
        addVideogame(db,v);
         v = new Videojuegos("ULISES", "Juego de ulises mazo guapo", Videojuegos.Consola.PS5, 60.0, new String("10-2-2020"), 0, R.drawable.uluses);
        addVideogame(db,v);
        v = new Videojuegos("PAPA", "Juego de PAPA mazo guapo", Videojuegos.Consola.PS5, 60.0, new String("9-2-2020"), 0, R.drawable.uluses);
        addVideogame(db,v);
        v = new Videojuegos("TETE", "Juego de TETE mazo guapo", Videojuegos.Consola.PS5, 60.0, new String("9-2-2020"), 0, R.drawable.uluses);
        addVideogame(db,v);
        Log.i("OpenHelper::onCreate()", "Exit");
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
        gamesData.put("DATE", v.fecha);
        gamesData.put("CART", v.cesta);
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
