package com.example.mawfd;


import android.Manifest;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.Nullable;

import android.content.Context;
import android.provider.Settings;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import com.example.mawfd.databinding.FragmentStartframeBinding;


public class StartFrameFragment extends Fragment {
    private FragmentStartframeBinding binding;
    private static final String TAG = "mafwd";
    public static final String KEY = "key";
    public static final String PRIKOL = "example";
    private final String CHANNEL_ID = "Channel1";
    public final int notificationId = 1;
    private final int requestCode = 2;

    public StartFrameFragment() {
        super(R.layout.fragment_startframe);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "OnCreateView");
        Log.d(TAG, "View Lifecycle = " + getViewLifecycleOwner().getLifecycle().getCurrentState().toString());
        Log.d(TAG, "Fragment Lifecycle = " + getLifecycle().getCurrentState().toString());
//            Toast.makeText(getContext(), "onCreateView", Toast.LENGTH_SHORT).show();
        binding = FragmentStartframeBinding.inflate(getLayoutInflater());
//        Intent notificationTransfer = new Intent(getContext(), FirstService.class);
//        notificationTransfer.putExtra("notificationId", notificationId);
//        startActivity(notificationTransfer);
        getActivity().startForegroundService(new Intent(getContext(), FirstService.class));
        Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:" + getActivity().getPackageName()));
        startActivityForResult(intent, 2);
        return binding.getRoot();
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel1 = new NotificationChannel(
                    CHANNEL_ID, "Channel 1", NotificationManager.IMPORTANCE_HIGH
            );
            channel1.setDescription("This is Channel 1");
            NotificationManager manager = (NotificationManager) getActivity().getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel1);
        }
    }

    private void showNotification() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(requireContext(), CHANNEL_ID)
                .setSmallIcon(R.drawable.awfd_logo_foreground)
                .setContentTitle(getString(R.string.notification_title))
                .setContentText(getString(R.string.notification_text))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(requireContext());
        if (ActivityCompat.checkSelfPermission(requireContext(), android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.POST_NOTIFICATIONS}, requestCode );
            return;
        }
        notificationManager.notify(
                notificationId, builder.build()
        );
    }

        @Override
        public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
            createNotificationChannel();
            Log.d(TAG, "OnViewCreated");
            Log.d(TAG, "View Lifecycle = " + getViewLifecycleOwner().getLifecycle().getCurrentState().toString());
            Log.d(TAG, "Fragment Lifecycle = " + getLifecycle().getCurrentState().toString());
//            Toast.makeText(getContext(), "onViewCreated", Toast.LENGTH_SHORT).show();
            super.onViewCreated(view, savedInstanceState);
            binding.button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    requireActivity().getSupportFragmentManager().beginTransaction()
//                            .addToBackStack(null)
//                            .replace(R.id.fragment_container, new SignInFragment())
//                            .commit();
                    Navigation.findNavController(view).navigate(R.id.action_startfragment_to_signinfragment);
                }
            });
            binding.button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    requireActivity().getSupportFragmentManager().beginTransaction()
//                            .addToBackStack(null)
//                            .replace(R.id.fragment_container, new TestFragment())
//                            .commit();
                    Bundle bundle = new Bundle();
                    bundle.putString(PRIKOL, "some data");
                    Toast.makeText(getContext(), "Bundle sent!", Toast.LENGTH_SHORT).show();
                    Navigation.findNavController(view).navigate(R.id.action_startfragment_to_testfragment, bundle);

                }

            });
            binding.button3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getContext(), "UVEDOMLENIE", Toast.LENGTH_SHORT).show();
                    showNotification();
                }
            });
        }

//        public void onClick(View v) {
//            Bundle result = new Bundle();
//            result.putString("bundleKey", "result");
//            getParentFragmentManager().setFragmentResult("requestKey", result);
//        }


//        @Override
//        public void onAttach(@NonNull Context context) {
//            Log.d(TAG, "onAttach");
//            Toast.makeText(getContext(), "onAttach", Toast.LENGTH_SHORT).show();
//            super.onAttach(context);
//        }
//
//        @Override
//        public void onCreate(@Nullable Bundle savedInstanceState) {
//            Log.d(TAG, "OnCreate");
//            Log.d(TAG, "View Lifecycle = null");
//            Log.d(TAG, "Fragment Lifecycle = " + getLifecycle().getCurrentState().toString());
//            Toast.makeText(getContext(), "onCreate", Toast.LENGTH_SHORT).show();
//            super.onCreate(savedInstanceState);
//        }
//
//
//
//
//        @Override
//        public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
//
//            Log.d(TAG, "OnViewStateRestored");
//            Log.d(TAG, "View Lifecycle = " + getViewLifecycleOwner().getLifecycle().getCurrentState().toString());
//            Log.d(TAG, "Fragment Lifecycle = " + getLifecycle().getCurrentState().toString());
//            Toast.makeText(getContext(), "onViewStateRestored", Toast.LENGTH_SHORT).show();
//
//            super.onViewStateRestored(savedInstanceState);
//        }
//        @Override
//        public void onStart() {
//            Log.d(TAG, "OnStart");
//            Log.d(TAG, "View Lifecycle = " + getViewLifecycleOwner().getLifecycle().getCurrentState().toString());
//            Log.d(TAG, "Fragment Lifecycle = " + getLifecycle().getCurrentState().toString());
//            Toast.makeText(getContext(), "onStart", Toast.LENGTH_SHORT).show();
//            super.onStart();
//        }
//        @Override
//        public void onResume() {
//
//            Log.d(TAG, "OnResume");
//            Log.d(TAG, "View Lifecycle = " + getViewLifecycleOwner().getLifecycle().getCurrentState().toString());
//            Log.d(TAG, "Fragment Lifecycle = " + getLifecycle().getCurrentState().toString());
//            Toast.makeText(getContext(), "onResume", Toast.LENGTH_SHORT).show();
//
//            super.onResume();
//        }
//        @Override
//        public void onPause() {
//
//            Log.d(TAG, "OnPause");
//            Log.d(TAG, "View Lifecycle = " + getViewLifecycleOwner().getLifecycle().getCurrentState().toString());
//            Log.d(TAG, "Fragment Lifecycle = " + getLifecycle().getCurrentState().toString());
//            Toast.makeText(getContext(), "onPause", Toast.LENGTH_SHORT).show();
//
//            super.onPause();
//        }
//        @Override
//        public void onStop() {
//
//            Log.d(TAG, "OnStop");
//            Log.d(TAG, "View Lifecycle = " + getViewLifecycleOwner().getLifecycle().getCurrentState().toString());
//            Log.d(TAG, "Fragment Lifecycle = " + getLifecycle().getCurrentState().toString());
//            Toast.makeText(getContext(), "onStop", Toast.LENGTH_SHORT).show();
//
//            super.onStop();
//        }
//        @Override
//        public void onSaveInstanceState(@NonNull Bundle outState) {
//
//            Log.d(TAG, "onSaveInstanceState");
//            Log.d(TAG, "View Lifecycle = " + getViewLifecycleOwner().getLifecycle().getCurrentState().toString());
//            Log.d(TAG, "Fragment Lifecycle = " + getLifecycle().getCurrentState().toString());
//            Toast.makeText(getContext(), "onSaveInstanceState", Toast.LENGTH_SHORT).show();
//
//            super.onSaveInstanceState(outState);
//        }
//        @Override
//        public void onDestroyView() {
//
//            Log.d(TAG, "OnDestroyView");
//            Log.d(TAG, "View Lifecycle = " + getViewLifecycleOwner().getLifecycle().getCurrentState().toString());
//            Log.d(TAG, "Fragment Lifecycle = " + getLifecycle().getCurrentState().toString());
//            Toast.makeText(getContext(), "onDestroyView", Toast.LENGTH_SHORT).show();
//
//            super.onDestroyView();
//        }
//        @Override
//        public void onDestroy() {
//            Log.d(TAG, "OnDestroy");
//            Log.d(TAG, "View Lifecycle = null");
//            Log.d(TAG, "Fragment Lifecycle = " + getLifecycle().getCurrentState().toString());
//            Toast.makeText(getContext(), "onDestroy", Toast.LENGTH_SHORT).show();
//
//            super.onDestroy();
//        }
//        @Override
//        public void onDetach() {
//            Log.d(TAG, "onDetach");
//            Toast.makeText(getContext(), "onDetach", Toast.LENGTH_SHORT).show();
//
//            super.onDetach();
//        }
    }