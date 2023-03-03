package com.example.mawfd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.util.Log;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "AWFD";
    private static final String KEY = "key";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonBack = (Button)findViewById(R.id.button1);
        buttonBack.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(KEY, "data");
        Log.i(TAG, "Changed activities!");
        startActivity(intent);
    }
    public void Click2(View view){
        Log.i(TAG, "Вывод лога при нажатии");
    }
    private void parseArgs(){
        String arg1 = getIntent().getStringExtra(MainActivity.KEY);
        Log.d(TAG, arg1);
    }
}