package com.example.day06okhttp03.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.day06okhttp03.R;
import com.example.day06okhttp03.di.icontract;
import com.example.day06okhttp03.di.presentimp;

public class MainActivity extends AppCompatActivity implements icontract.iview {

    private EditText edit_name;
    private EditText edit_pwd;
    private Button zc;
    private presentimp presentimp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化
        edit_name = findViewById(R.id.edit_name);
        edit_pwd = findViewById(R.id.edit_pwd);
        //创建presenter层
        presentimp = new presentimp();
        presentimp.attachview(this );
        zc = findViewById(R.id.zc);
        //监听事件
        zc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edit_name.getText().toString();
                String pwd = edit_pwd.getText().toString();
                presentimp.requestinfo(name,pwd);

            }
        });
    }

    @Override
    public void showdata(final String message) {
         runOnUiThread(new Runnable() {
             @Override
             public void run() {
                 Toast.makeText(MainActivity.this,message,Toast.LENGTH_LONG).show();
                 if (message.equals("注册成功")){
                     Intent intent = new Intent(MainActivity.this, Three.class);
                     startActivity(intent);
                     finish();
                 }
             }
         });

    }
    //销毁
    @Override
    protected void onDestroy() {
        super.onDestroy();
        presentimp.detachview(this);

    }
}
