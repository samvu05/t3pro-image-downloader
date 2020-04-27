package com.sam.t3pro_image_downloader;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class EditActivity extends AppCompatActivity{
    private Button btnSubmit;
    private EditText edt1;
    private EditText edt2;
    private EditText edt3;
    private EditText edt4;
    private EditText edt5;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit);
        getWidget();
        setEvent();
    }
    protected void getWidget() {
        edt1 = findViewById(R.id.edt_1);
        edt2 = findViewById(R.id.edt_2);
        edt3 = findViewById(R.id.edt_3);
        edt4 = findViewById(R.id.edt_4);
        edt5 = findViewById(R.id.edt_5);
        btn1 = findViewById(R.id.btn_clear1);
        btn2 = findViewById(R.id.btn_clear2);
        btn3 = findViewById(R.id.btn_clear3);
        btn4 = findViewById(R.id.btn_clear4);
        btn5 = findViewById(R.id.btn_clear5);
        btnSubmit = findViewById(R.id.btn_submit);
    }
    protected void setEvent() {
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText("");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt2.setText("");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt3.setText("");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt4.setText("");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt5.setText("");
            }
        });
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passLinkData();
            }
        });
    }

    private void passLinkData() {
        Intent resultIntent = new Intent();
        resultIntent.putExtra("edt1",edt1.getText().toString());
        resultIntent.putExtra("edt2",edt2.getText().toString());
        resultIntent.putExtra("edt3",edt3.getText().toString());
        resultIntent.putExtra("edt4",edt4.getText().toString());
        resultIntent.putExtra("edt5",edt5.getText().toString());
        setResult(RESULT_OK,resultIntent);
        finish();
    }

}
