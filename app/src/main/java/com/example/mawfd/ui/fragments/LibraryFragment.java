package com.example.mawfd.ui.fragments;

import static androidx.navigation.Navigation.findNavController;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.mawfd.FirstService;
import com.example.mawfd.R;
import com.example.mawfd.databinding.FragmentLibraryBinding;
import com.example.mawfd.databinding.FragmentMenuBinding;
import com.example.mawfd.ui.adapters.PatientAdapter;
import com.example.mawfd.ui.stateholder.viewModels.LibraryViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class LibraryFragment extends Fragment {
    private FragmentLibraryBinding binding;
    private LibraryViewModel model;
    private PatientAdapter adapter;

    public LibraryFragment()
    {
        super(R.layout.fragment_library);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentLibraryBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        model = new ViewModelProvider(this).get(LibraryViewModel.class);
        adapter = new PatientAdapter(this::openProfile);
        binding.PatientRecycler.setAdapter(adapter);
        binding.PatientRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        model.listLiveData.observe(getViewLifecycleOwner(), adapter::setItems);
        binding.AddPatient.setOnClickListener(v -> model.addPatient());
        binding.BottomNavigation.setSelectedItemId(R.id.navigation_item3);
        binding.BottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_item0:
                        findNavController(view).navigate(R.id.action_library_to_menu);
                        return true;
                    case R.id.navigation_item1:
                        findNavController(view).navigate(R.id.action_library_to_doctorlist);
                        return true;
                    case R.id.navigation_item2:
                        findNavController(view).navigate(R.id.action_library_to_appointments);
                        return true;
                    default:
                        return false;
                }
            }
        });
    }
    private void openProfile(int id) {
        findNavController(requireView()).navigate(LibraryFragmentDirections.actionLibraryToPatient(id));
    }
}
