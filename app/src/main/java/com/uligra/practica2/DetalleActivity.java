package com.uligra.practica2;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetalleActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.activity_detalle, frameLayout);
        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("NAME");

        SQLiteOpenHelper gameDbHelper = new GameDataHelper(this) ;
        SQLiteDatabase db = gameDbHelper.getReadableDatabase();
        //relleno novedades

        Cursor cursor = db.query("GAMES",
                new String[] { "DESCRIPTION", "NAME", "PRICE","IMAGE_ID"},
                "NAME='" + name + "'",
                null,
                null, null,null,"1");
        cursor.moveToFirst();

        String decripcion = cursor.getString( cursor.getColumnIndex("DESCRIPTION") );
        String nombre = cursor.getString( cursor.getColumnIndex("NAME") );
        float precio = cursor.getFloat( cursor.getColumnIndex("PRICE") );
        int image_id = cursor.getInt( cursor.getColumnIndex("IMAGE_ID") );

        TextView nombreV = findViewById(R.id.titulo);
        nombreV.setText(nombre);

        TextView descipcionV = findViewById(R.id.descripcion);
        descipcionV.setText(decripcion);

        TextView precioV = findViewById(R.id.precio);
        precioV.setText(String.valueOf(precio)+" €");

        ImageView imageV = findViewById(R.id.foto);
        imageV.setImageDrawable(getResources().getDrawable(image_id));
    }

}