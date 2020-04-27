package com.sam.t3pro_image_downloader;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {
    private ImageButton btnEdit;
    private ImageView imgv1;
    private ImageView imgv2;
    private ImageView imgv3;
    private ImageView imgv4;
    private ImageView imgv5;
    private String linkImg1 = "";
    private String linkImg2 = "";
    private String linkImg3 = "";
    private String linkImg4 = "";
    private String linkImg5 = "";
    private TextView textView;
    private int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        getWidget();
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,EditActivity.class);
                startActivity(intent);
                count++;
            }
        });
        if(count != 0){
            getDataFromEditActivity();
        }
    }

    private void getWidget() {
        imgv1 = findViewById(R.id.iv_img1);
        imgv2 = findViewById(R.id.iv_img2);
        imgv3 = findViewById(R.id.iv_img3);
        imgv4 = findViewById(R.id.iv_img4);
        imgv5 = findViewById(R.id.iv_img5);
        btnEdit = findViewById(R.id.btn_edit);
        textView = findViewById(R.id.tempa);
    }

    private void getDataFromEditActivity() {
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra(EditActivity.BUNDLE);
        String link1 = bundle.getString(EditActivity.LINK1);
        String link2 = bundle.getString(EditActivity.LINK2);
        String link3 = bundle.getString(EditActivity.LINK3);
        String link4 = bundle.getString(EditActivity.LINK4);
        String link5 = bundle.getString(EditActivity.LINK5);

        textView.setText(link1);

//        Toast.makeText(HomeActivity.this,link1,Toast.LENGTH_SHORT).show();
//        Toast.makeText(HomeActivity.this,link2,Toast.LENGTH_SHORT).show();
//        Toast.makeText(HomeActivity.this,link3,Toast.LENGTH_SHORT).show();
//        Toast.makeText(HomeActivity.this,link4,Toast.LENGTH_SHORT).show();
//        Toast.makeText(HomeActivity.this,link5,Toast.LENGTH_SHORT).show();
    }
}
