package com.example.mawfd.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.mawfd.R;
import com.example.mawfd.databinding.FragmentAdminBinding;
import com.example.mawfd.ui.adapters.AdminAdapter;

public class AdminFragment extends Fragment {
    private FragmentAdminBinding binding;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentAdminBinding.inflate(inflater, container, false);
        String[] data = {"Vengeful", "Nakarat", "Korpalo1337"};
        String[] passwords = {"123456", "Tarakan", "ilovearabic"};
        AdminAdapter adapter = new AdminAdapter(data, passwords);
        binding.adminRecycler.setAdapter(adapter);
        binding.adminRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_admin_to_startfragment);
            }
        });
    }
}
