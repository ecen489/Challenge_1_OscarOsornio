package com.example.cameraapp;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    Button img_capture;
    ImageView img_view;

    //SQLiteDatabase db = (SQLiteDatabase) this.openOrCreateDatabase("Camera");
    //Scanner scan = new Scanner(getResources().openRawResource(R.raw.Camera));

    //String query = "";
    //while (scan.hasNextLine()){
    //    query += scan.nextLine() + "\n";
    //    if (query.trim().endsWith(";")){
    //        db.execSQL(query);
    //        query = "";
    //    }
    //}

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img_capture = findViewById(R.id.button);
        img_view = findViewById(R.id.imageView);

        img_capture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent snapshot = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(snapshot, 0);
            }
        });
    }

    @Override
    protected void onActivityResult(int request, int result, Intent intent){
        super.onActivityResult(request, result, intent);

        Bitmap bitmap = (Bitmap) intent.getExtras().get("data");
        img_view.setImageBitmap(bitmap);
        img_view.setVisibility(View.VISIBLE);
    }


}
