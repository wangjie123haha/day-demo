package com.example.day06okhttp03.ui;

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

public class Three extends AppCompatActivity  implements icontract.iview {

    private EditText name1;
    private EditText pwd1;
    private Button dl;
    private com.example.day06okhttp03.di.presentimp presentimp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
        name1 = findViewById(R.id.name1);
        pwd1 = findViewById(R.id.pwd1);
        presentimp = new presentimp();
        presentimp.attachview(this);
        dl = findViewById(R.id.dl);
        dl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 //获取数据
                String sname = name1.getText().toString();
                String spwd = pwd1.getText().toString();
                presentimp.requestdl(sname,spwd);

            }
        });
    }

    @Override
    public void showdata(final String message) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(Three.this,message,Toast.LENGTH_LONG).show();
                    }
                });
                if (message.equals("登录成功")){
                    Intent intent = new Intent(Three.this, Four.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presentimp.detachview(this);
    }
}
