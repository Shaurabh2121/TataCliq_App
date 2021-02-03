package com.example.tatacliq;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private TextView mTvV1, mTvV2, mTvV3;
    private View mIvCliq;
    private Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTvV1 = findViewById(R.id.v1);
        mTvV2 = findViewById(R.id.v2);
        mTvV3 = findViewById(R.id.v3);
        mIvCliq = findViewById(R.id.ivClick);
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
                finish();
            }
        }, 1000);

    }
}
