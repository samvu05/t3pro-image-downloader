package com.sam.t3pro_image_downloader;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;

public class HomeActivity extends AppCompatActivity {
    private ImageButton btnEdit;
    private ImageView imgv1;
    private ImageView imgv2;
    private ImageView imgv3;
    private ImageView imgv4;
    private ImageView imgv5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        getWidget();
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,EditActivity.class);
                startActivityForResult(intent,1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1){
            if (resultCode == RESULT_OK){

                String url1 = data.getStringExtra("edt1");
                String url2 = data.getStringExtra("edt2");
                String url3 = data.getStringExtra("edt3");
                String url4 = data.getStringExtra("edt4");
                String url5 = data.getStringExtra("edt5");

                LoadImage loadImg1 = new LoadImage(imgv1);
                loadImg1.execute(url1);

                LoadImage loadImg2 = new LoadImage(imgv2);
                loadImg2.execute(url2);

                LoadImage loadImg3 = new LoadImage(imgv3);
                loadImg3.execute(url3);

                LoadImage loadImg4 = new LoadImage(imgv4);
                loadImg4.execute(url4);

                LoadImage loadImg5 = new LoadImage(imgv5);
                loadImg5.execute(url5);
            }
        }
    }

    private void getWidget() {
        imgv1 = findViewById(R.id.iv_img1);
        imgv2 = findViewById(R.id.iv_img2);
        imgv3 = findViewById(R.id.iv_img3);
        imgv4 = findViewById(R.id.iv_img4);
        imgv5 = findViewById(R.id.iv_img5);
        btnEdit = findViewById(R.id.btn_edit);
    }
    private class LoadImage extends AsyncTask<String,Void, Bitmap> {
        ImageView imageView;
        public LoadImage (ImageView ivResult){
            this.imageView = ivResult;
        }
        @Override
        protected Bitmap doInBackground(String... strings) {
            String urlLink = strings[0];
            Bitmap bitmap = null;
            try{
                InputStream inputStream = new java.net.URL(urlLink).openStream();
                bitmap = BitmapFactory.decodeStream(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            this.imageView.setImageBitmap(bitmap);
        }
    }

}
