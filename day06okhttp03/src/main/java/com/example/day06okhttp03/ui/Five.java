package com.example.day06okhttp03.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.day06okhttp03.R;
import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;

public class Five extends AppCompatActivity {

    private Button btn;
    private Button btn01;
    private ImageView img02;
    private EditText sao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five);
       //初始化
        btn = findViewById(R.id.btn);
        btn01 = findViewById(R.id.btn01);
        img02 = findViewById(R.id.img02);
        sao = findViewById(R.id.sao);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               startActivity(new Intent(Five.this, CaptureActivity.class));
            }
        });
        btn01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = sao.toString();
                Bitmap bitmap = CodeUtils.createImage(s, 200, 200, BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
                img02.setImageBitmap(bitmap);
            }
        });

    }
}
