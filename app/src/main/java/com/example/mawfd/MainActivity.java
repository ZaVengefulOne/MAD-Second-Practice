package com.example.mawfd;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.util.Log;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "AWFD";
    private static final String KEY = "key";

    ActivityResultLauncher<Intent> mStartForResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                Log.i(TAG, String.valueOf(result));
                }
            });





    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonBack = (Button)findViewById(R.id.button1);
        Button buttonLog = (Button)findViewById(R.id.button2);
        buttonBack.setOnClickListener(this);
        buttonLog.setOnClickListener(this::Click2);
    }
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(KEY, "data");
        Log.i(TAG, "Changed activities!");
        mStartForResult.launch(intent);
    }
    public void Click2(View view){
        Log.i(TAG, "Вывод лога при нажатии");
    }
    private void parseArgs(){
        String arg1 = getIntent().getStringExtra(MainActivity.KEY);
        Log.d(TAG, arg1);
    }

}