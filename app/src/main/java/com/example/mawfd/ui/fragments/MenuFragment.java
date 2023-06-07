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
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
//import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.mawfd.FirstService;
import com.example.mawfd.R;
import com.example.mawfd.data.models.PlaceholderPost;
import com.example.mawfd.databinding.FragmentMenuBinding;
import com.example.mawfd.ui.stateholder.viewModels.StartFrameViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

//import java.util.ArrayList;
//import java.util.List;


public class MenuFragment extends Fragment {
    private FragmentMenuBinding binding;


    private final String CHANNEL_ID = "Channel1";
    public final int notificationId = 1;
    //    public boolean isNotiGranted = false;

    public MenuFragment() {
        super(R.layout.fragment_menu);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentMenuBinding.inflate(getLayoutInflater());
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
        StartFrameViewModel model = new ViewModelProvider(this).get(StartFrameViewModel.class);
            createNotificationChannel();
            super.onViewCreated(view, savedInstanceState);
        model.postLD.observe(getViewLifecycleOwner(), new Observer<PlaceholderPost>() {
            @Override
            public void onChanged(PlaceholderPost placeholderPost) {
                Log.d("MAMA SMOTRI YA SDELAL PLACEHOLDERAPI", placeholderPost.getBody());
            }
        });
        model.pushLD.observe(getViewLifecycleOwner(), new Observer<PlaceholderPost>() {
            @Override
            public void onChanged(PlaceholderPost placeholderPost) {
                binding.APIView.setText(placeholderPost.getTitle());
                Log.d("PAPA SMOTRI YA SDELAL PLACEHOLDERAPI", placeholderPost.getTitle());
            }
        });
        model.getLD.observe(getViewLifecycleOwner(), new Observer<List<PlaceholderPost>>() {
            @Override
            public void onChanged(List<PlaceholderPost> placeholderPosts) {
                Log.d("DYADYA LYONYA SMOTRITE YA SDELAL PLACEHOLDERAPI", placeholderPosts.get(50).getTitle());
            }
        });

//        binding.button2.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                Navigation.findNavController(view).navigate(R.id.action_startfragment_to_doctorlist);
//                }

//            });
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
                    textIntent.putExtra(Intent.EXTRA_TEXT, "I'm sending you all the doctors info");
                    requireActivity().startActivity(textIntent);
                }
            });
            binding.BottomNavigation.setSelectedItemId(R.id.navigation_item0);
            binding.BottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.navigation_item1:
                            Navigation.findNavController(view).navigate(R.id.action_startfragment_to_doctorlist);
                            return true;
                        case R.id.navigation_item2:
                            Navigation.findNavController(view).navigate(R.id.action_menu_to_appointments);
                            return true;
                        case R.id.navigation_item3:
                            Navigation.findNavController(view).navigate(R.id.action_menu_to_library);
                            return true;
                        default:
                            return false;
                    }
                }
            });
        }
    }