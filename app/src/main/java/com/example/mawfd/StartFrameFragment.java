package com.example.mawfd;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class StartFrameFragment extends AppCompatActivity {
    public StartFrameFragment() {
        super(R.layout.fragment_start_frame);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null){
            Bundle bundle = new Bundle();
            bundle.putInt("some_int", 0);
            getSupportFragmentManager().beginTransaction()

                    .commit();
        }

    }
}
