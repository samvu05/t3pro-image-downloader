package com.sam.t3pro_image_downloader;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
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
    private LoadImage loadImg1;
    private LoadImage loadImg2;
    private LoadImage loadImg3;
    private LoadImage loadImg4;
    private LoadImage loadImg5;
    private String urlDefault1 ;
    private String urlDefault2 ;
    private String urlDefault3 ;
    private String urlDefault4 ;
    private String urlDefault5 ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        getWidget();
        setAllDefaultURL();
        loadAllDefaulImage();
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,EditActivity.class);
                startActivityForResult(intent,1);
            }
        });
    }

    private void setAllDefaultURL() {
        urlDefault1 = "https://images.pexels.com/photos/3951392/pexels-photo-3951392.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940";
        urlDefault2 = "https://images.pexels.com/photos/3951378/pexels-photo-3951378.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940";
        urlDefault3 = "https://images.pexels.com/photos/3951886/pexels-photo-3951886.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940";
        urlDefault4 = "https://images.pexels.com/photos/3952221/pexels-photo-3952221.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940";
        urlDefault5 = "https://images.pexels.com/photos/3957987/pexels-photo-3957987.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940";
//        urlDefault1 = "https://images.pexels.com/photos/3805983/pexels-photo-3805983.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940";
//        urlDefault2 = "https://images.pexels.com/photos/2925322/pexels-photo-2925322.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940";
//        urlDefault3 = "https://images.pexels.com/photos/3635300/pexels-photo-3635300.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940";
//        urlDefault4 = "https://images.pexels.com/photos/2146042/pexels-photo-2146042.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940";
//        urlDefault5 = "https://images.pexels.com/photos/3856635/pexels-photo-3856635.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940";
    }

    private void loadAllDefaulImage() {
        loadImg1 = new LoadImage(imgv1);
        loadImg1.execute(urlDefault1);

        loadImg2 = new LoadImage(imgv2);
        loadImg2.execute(urlDefault2);

        loadImg3 = new LoadImage(imgv3);
        loadImg3.execute(urlDefault3);
        loadImg4 = new LoadImage(imgv4);
        loadImg4.execute(urlDefault4);
        loadImg5 = new LoadImage(imgv5);
        loadImg5.execute(urlDefault5);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1){
            if (resultCode == RESULT_OK){
                String urlTemp1 = data.getStringExtra("edt1");
                String urlTemp2 = data.getStringExtra("edt2");
                String urlTemp3 = data.getStringExtra("edt3");
                String urlTemp4 = data.getStringExtra("edt4");
                String urlTemp5 = data.getStringExtra("edt5");

                if (!urlTemp1.equals("")){
                    loadImg1.execute(urlTemp1);
                }
                if (!urlTemp2.equals("")) {
                    loadImg2.execute(urlTemp2);
                }
                if (!urlTemp3.equals("")){
                    loadImg3.execute(urlTemp3);
                }
                if (!urlTemp5.equals("")){
                    loadImg4.execute(urlTemp4);
                }
                if (!urlTemp5.equals("")){
                    loadImg5.execute(urlTemp5);
                }
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
            Bitmap resized = null;
            try{
                InputStream inputStream = new java.net.URL(urlLink).openStream();
                bitmap = BitmapFactory.decodeStream(inputStream);
//                resized = Bitmap.createScaledBitmap(bitmap,1000,462,true);
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
