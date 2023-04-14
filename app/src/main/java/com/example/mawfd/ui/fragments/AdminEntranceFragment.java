package com.example.mawfd.ui.fragments;

import static androidx.core.content.PermissionChecker.checkSelfPermission;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.core.app.ActivityCompat;
import androidx.core.content.PermissionChecker;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.mawfd.R;
import com.example.mawfd.databinding.FragmentAdminEntranceBinding;
import com.example.mawfd.ui.stateholder.viewModels.AdminEntranceViewModel;

public class AdminEntranceFragment extends Fragment {
    private FragmentAdminEntranceBinding binding;
    private AdminEntranceViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentAdminEntranceBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(AdminEntranceViewModel.class);
        super.onViewCreated(view, savedInstanceState);
        binding.enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (viewModel.loginAccount(
                        binding.AdminPassword.getText().toString(),
                        binding.AdminLogin.getText().toString(),
                        allowedPermission()
                ))
                    Navigation.findNavController(v).navigate(R.id.action_adminentrance_to_adminfragment);
            }
        });
    }
    private boolean allowedPermission() {
        if (checkSelfPermission(requireContext(), android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                == PermissionChecker.PERMISSION_GRANTED) {
            return true;
        } else {
            ActivityCompat.requestPermissions(requireActivity(), new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
            return false;
        }
    }
}
