package com.example.mawfd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {
    public static final String TAG = "AWFD";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Button buttonBack = (Button)findViewById(R.id.button2);
        buttonBack.setOnClickListener(this::OnClick);
    }
    public void OnClick(View view){
        Intent intent = new Intent(this, SecondActivity.class);
        Log.i(TAG,"Logs are here!");
        startActivity(intent);
    }

}