package com.example.mawfd.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.mawfd.FirstService;
import com.example.mawfd.R;
import com.example.mawfd.databinding.FragmentLibraryBinding;
import com.example.mawfd.databinding.FragmentMenuBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class LibraryFragment extends Fragment {
    private FragmentLibraryBinding binding;

    public LibraryFragment()
    {
        super(R.layout.fragment_library);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentLibraryBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        binding.BottomNavigation.setSelectedItemId(R.id.navigation_item3);
        binding.BottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_item0:
                        Navigation.findNavController(view).navigate(R.id.action_library_to_menu);
                        return true;
                    case R.id.navigation_item1:
                        Navigation.findNavController(view).navigate(R.id.action_library_to_doctorlist);
                        return true;
                    case R.id.navigation_item2:
                        Navigation.findNavController(view).navigate(R.id.action_library_to_appointments);
                        return true;
                    default:
                        return false;
                }
            }
        });
    }
}
