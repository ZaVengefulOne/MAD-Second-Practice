package com.example.mawfd.ui.fragments;


import android.Manifest;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.pm.PackageManager;
//import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;

//import android.content.Context;
//import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
//import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.mawfd.FirstService;
import com.example.mawfd.R;
import com.example.mawfd.databinding.FragmentStartframeBinding;
import com.example.mawfd.ui.stateholder.viewModels.StartFrameViewModel;

//import java.util.ArrayList;
//import java.util.List;


public class StartFrameFragment extends Fragment {
    private StartFrameViewModel model;
    private FragmentStartframeBinding binding;
    private static final String TAG = "mafwd";
//    public static final String KEY = "key";
    public static final String PRIKOL = "example";

    private final String CHANNEL_ID = "Channel1";
    public final int notificationId = 1;
    //    public boolean isNotiGranted = false;

    public StartFrameFragment() {
        super(R.layout.fragment_startframe);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentStartframeBinding.inflate(getLayoutInflater());
        getActivity().stopService(new Intent(getContext(), FirstService.class));
        return binding.getRoot();
    }

    private void createNotificationChannel() {
            NotificationChannel channel1 = new NotificationChannel(
                    CHANNEL_ID, "Channel 1", NotificationManager.IMPORTANCE_HIGH
            );
            channel1.setDescription("This is Channel 1");
            NotificationManager manager = (NotificationManager) getActivity().getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel1);
    }

    private void showNotification() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(requireContext(), CHANNEL_ID)
                .setSmallIcon(R.drawable.awfd_logo_foreground)
                .setContentTitle(getString(R.string.notification_title))
                .setContentText(getString(R.string.notification_text))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(requireContext());
        if (ActivityCompat.checkSelfPermission(requireContext(), android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
            int requestCode = 2;
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.POST_NOTIFICATIONS}, requestCode);
        }
        notificationManager.notify(
                notificationId, builder.build()
        );
    }



    @Override
        public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
            model = new ViewModelProvider(this).get(StartFrameViewModel.class);
            createNotificationChannel();
            super.onViewCreated(view, savedInstanceState);
            binding.button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_startfragment_to_doctorlist);
                }

            });
            binding.button3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                        showNotification();

                }
            });
            binding.button4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    getActivity().startForegroundService(new Intent(getContext(), FirstService.class));
                }
            });
            binding.shareButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent textIntent = new Intent(Intent.ACTION_SEND);
                    textIntent.setType("text/plain");
                    textIntent.putExtra(Intent.EXTRA_SUBJECT, "Doctor info");
                    textIntent.putExtra(Intent.EXTRA_TEXT, "Bla-bla-bla");
                    requireActivity().startActivity(textIntent);
                }
            });
        }
    }