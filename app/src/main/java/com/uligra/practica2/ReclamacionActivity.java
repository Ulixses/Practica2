package com.uligra.practica2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.FileOutputStream;

public class ReclamacionActivity extends BaseActivity {


    Uri image = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.activity_reclamacion, frameLayout);
    }

    public void send(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);



        TextView nombre = findViewById(R.id.nombre);
        TextView factura = findViewById(R.id.factura);
        TextView consulta = findViewById(R.id.motivo);

        intent.putExtra(Intent.EXTRA_SUBJECT, "Consulta de:" + nombre.getText().toString() + '(' + factura.getText().toString() +')');
        intent.putExtra(Intent.EXTRA_TEXT, consulta.getText().toString());
        intent.putExtra(Intent.EXTRA_EMAIL, R.string.correo);
        if(image != null){
            intent.setType("image/*");
            intent.putExtra(Intent.EXTRA_STREAM, image);
        }
        else {
            intent.setType("text/plain");
        }

        Intent intentChooser = Intent.createChooser(intent, "Selecciona la app para enviar:");
        startActivity(intentChooser);
    }

    public void selectImage(View view) {
        final CharSequence[] options = { "Usar la cámara", "Galeria","Cancelar" };

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Choose your profile picture");
        Activity activity = this;
        builder.setItems(options, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int item) {

                if (options[item].equals(options[0])) {
                    if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.CAMERA}, 1);
                    }
                    else {
                        Intent takePicture = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivityForResult(takePicture, 0);
                    }

                } else if (options[item].equals(options[1])) {
                    Intent pickPhoto = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                    startActivityForResult(pickPhoto , 1);

                } else if (options[item].equals(options[2])) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        ImageView imageView = findViewById(R.id.viewImage);
        if (resultCode != RESULT_CANCELED) {
            switch (requestCode) {
                case 0:
                    if (resultCode == RESULT_OK && data != null) {
                        Bitmap selectedImage = (Bitmap) data.getExtras().get("data");
                        imageView.setImageBitmap(selectedImage);
                    }
                    break;
                case 1:
                    if (resultCode == RESULT_OK && data != null) {
                        image = data.getData();
                        imageView.setImageURI(image);
                        /*String[] filePathColumn = {MediaStore.Images.Media.DATA};
                        if (selectedImage != null) {
                            Cursor cursor = getContentResolver().query(selectedImage,
                                    filePathColumn, null, null, null);
                            if (cursor != null) {
                                cursor.moveToFirst();

                                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                                String picturePath = cursor.getString(columnIndex);
                                imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));
                                cursor.close();
                            }
                        }*/
                    }
                    break;
            }
        }
    }
}