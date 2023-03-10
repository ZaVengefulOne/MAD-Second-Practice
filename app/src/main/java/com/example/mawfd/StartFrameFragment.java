package com.example.mawfd;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.mawfd.databinding.FragmentHomeBinding;
import com.example.mawfd.databinding.FragmentMenuBinding;


    public class StartFrameFragment extends Fragment {
        private static final String TAG = "mafwd";
        public static final String KEY = "key";
        public StartFrameFragment() {
            super(R.layout.fragment_startframe);
            StartFrameFragment startFrameFragment = new StartFrameFragment();
            Bundle bundle = new Bundle();
            bundle.putString(KEY,"123");
            startFrameFragment.setArguments(bundle);
        }

        public void onClick(View v) {
            Bundle result = new Bundle();
            result.putString("bundleKey", "result");
            getParentFragmentManager().setFragmentResult("requestKey", result);
        }

        private FragmentStartFrameBinding binding;
        @Override
        public void onAttach(@NonNull Context context) {
            Log.d(TAG, "onAttach");
            Toast.makeText(getContext(), "onAttach", Toast.LENGTH_SHORT).show();
            super.onAttach(context);
        }

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            Log.d(TAG, "OnCreate");
            Log.d(TAG, "View Lifecycle = null");
            Log.d(TAG, "Fragment Lifecycle = " + getLifecycle().getCurrentState().toString());
            Toast.makeText(getContext(), "onCreate", Toast.LENGTH_SHORT).show();
            super.onCreate(savedInstanceState);
        }

        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            Log.d(TAG, "OnCreateView");
            Log.d(TAG, "View Lifecycle = " + getViewLifecycleOwner().getLifecycle().getCurrentState().toString());
            Log.d(TAG, "Fragment Lifecycle = " + getLifecycle().getCurrentState().toString());
            Toast.makeText(getContext(), "onCreateView", Toast.LENGTH_SHORT).show();

            binding = FragmentHomeBinding.inflate(getLayoutInflater());
            return binding.getRoot();
        }

        @Override
        public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

            Log.d(TAG, "OnViewCreated");
            Log.d(TAG, "View Lifecycle = " + getViewLifecycleOwner().getLifecycle().getCurrentState().toString());
            Log.d(TAG, "Fragment Lifecycle = " + getLifecycle().getCurrentState().toString());
            Toast.makeText(getContext(), "onViewCreated", Toast.LENGTH_SHORT).show();

            super.onViewCreated(view, savedInstanceState);
        }

        @Override
        public void onViewStateRestored(@Nullable Bundle savedInstanceState) {

            Log.d(TAG, "OnViewStateRestored");
            Log.d(TAG, "View Lifecycle = " + getViewLifecycleOwner().getLifecycle().getCurrentState().toString());
            Log.d(TAG, "Fragment Lifecycle = " + getLifecycle().getCurrentState().toString());
            Toast.makeText(getContext(), "onViewStateRestored", Toast.LENGTH_SHORT).show();

            super.onViewStateRestored(savedInstanceState);
        }

        @Override
        public void onStart() {
            Log.d(TAG, "OnStart");
            Log.d(TAG, "View Lifecycle = " + getViewLifecycleOwner().getLifecycle().getCurrentState().toString());
            Log.d(TAG, "Fragment Lifecycle = " + getLifecycle().getCurrentState().toString());
            Toast.makeText(getContext(), "onStart", Toast.LENGTH_SHORT).show();
            super.onStart();
        }

        @Override
        public void onResume() {

            Log.d(TAG, "OnResume");
            Log.d(TAG, "View Lifecycle = " + getViewLifecycleOwner().getLifecycle().getCurrentState().toString());
            Log.d(TAG, "Fragment Lifecycle = " + getLifecycle().getCurrentState().toString());
            Toast.makeText(getContext(), "onResume", Toast.LENGTH_SHORT).show();

            super.onResume();
        }

        @Override
        public void onPause() {

            Log.d(TAG, "OnPause");
            Log.d(TAG, "View Lifecycle = " + getViewLifecycleOwner().getLifecycle().getCurrentState().toString());
            Log.d(TAG, "Fragment Lifecycle = " + getLifecycle().getCurrentState().toString());
            Toast.makeText(getContext(), "onPause", Toast.LENGTH_SHORT).show();

            super.onPause();
        }

        @Override
        public void onStop() {

            Log.d(TAG, "OnStop");
            Log.d(TAG, "View Lifecycle = " + getViewLifecycleOwner().getLifecycle().getCurrentState().toString());
            Log.d(TAG, "Fragment Lifecycle = " + getLifecycle().getCurrentState().toString());
            Toast.makeText(getContext(), "onStop", Toast.LENGTH_SHORT).show();

            super.onStop();
        }

        @Override
        public void onSaveInstanceState(@NonNull Bundle outState) {

            Log.d(TAG, "onSaveInstanceState");
            Log.d(TAG, "View Lifecycle = " + getViewLifecycleOwner().getLifecycle().getCurrentState().toString());
            Log.d(TAG, "Fragment Lifecycle = " + getLifecycle().getCurrentState().toString());
            Toast.makeText(getContext(), "onSaveInstanceState", Toast.LENGTH_SHORT).show();

            super.onSaveInstanceState(outState);
        }

        @Override
        public void onDestroyView() {

            Log.d(TAG, "OnDestroyView");
            Log.d(TAG, "View Lifecycle = " + getViewLifecycleOwner().getLifecycle().getCurrentState().toString());
            Log.d(TAG, "Fragment Lifecycle = " + getLifecycle().getCurrentState().toString());
            Toast.makeText(getContext(), "onDestroyView", Toast.LENGTH_SHORT).show();

            super.onDestroyView();
        }

        @Override
        public void onDestroy() {
            Log.d(TAG, "OnDestroy");
            Log.d(TAG, "View Lifecycle = null");
            Log.d(TAG, "Fragment Lifecycle = " + getLifecycle().getCurrentState().toString());
            Toast.makeText(getContext(), "onDestroy", Toast.LENGTH_SHORT).show();

            super.onDestroy();
        }

        @Override
        public void onDetach() {
            Log.d(TAG, "onDetach");
            Toast.makeText(getContext(), "onDetach", Toast.LENGTH_SHORT).show();

            super.onDetach();
        }
    }