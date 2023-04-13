package com.example.mawfd.ui;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mawfd.R;


public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        if (savedInstanceState == null) {
//            getSupportFragmentManager().beginTransaction()
//                    .setReorderingAllowed(true)
//                    .add(R.id.fragment_container, StartFrameFragment.class, null)
//                    .commit();
//        }
    }
}