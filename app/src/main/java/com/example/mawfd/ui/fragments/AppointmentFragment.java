package com.example.mawfd.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.mawfd.R;
import com.example.mawfd.databinding.FragmentAppointmentsBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AppointmentFragment extends Fragment {

    private FragmentAppointmentsBinding binding;

    public AppointmentFragment(){
        super(R.layout.fragment_appointments);
}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentAppointmentsBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.BottomNavigation.setSelectedItemId(R.id.navigation_item2);
        binding.BottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_item0:
                        Navigation.findNavController(view).navigate(R.id.action_appointments_to_menu);
                        return true;
                    case R.id.navigation_item1:
                        Navigation.findNavController(view).navigate(R.id.action_appointments_to_doctorlist);
                        return true;
                    case R.id.navigation_item3:
                        Navigation.findNavController(view).navigate(R.id.action_appointments_to_library);
                        return true;
                    default:
                        return false;
                }
            }
        });
    }
}
