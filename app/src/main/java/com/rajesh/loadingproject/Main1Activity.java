package com.rajesh.loadingproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Main1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((TextView)findViewById(R.id.textView)).setText("页面2");
    }

    public void buttonClick(View view) {
        Toast.makeText(getApplicationContext(), "点击2", Toast.LENGTH_SHORT).show();
    }
}
