package com.uligra.practica2;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.widget.ImageView;
import android.widget.ResourceCursorAdapter;
import android.widget.TextView;

public class CarritoAdapter extends ResourceCursorAdapter {
    public CarritoAdapter(Context context, int layout, Cursor cursor, int flags) {
        super(context, layout, cursor, flags);
    }
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView name = (TextView) view.findViewById(R.id.Nombre);
        name.setText(cursor.getString(cursor.getColumnIndex("NAME")));

        TextView price = (TextView) view.findViewById(R.id.Precio);
        price.setText(cursor.getString(cursor.getColumnIndex("PRICE"))+"€");


    }

}
