package com.example.mawfd.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.mawfd.R;
import com.example.mawfd.data.database.entity.DoctorListItem;
import com.example.mawfd.databinding.FragmentDoctorprofileBinding;
import com.example.mawfd.ui.stateholder.viewModels.DoctorListItemViewModel;

public class DoctorProfile extends Fragment {

    private FragmentDoctorprofileBinding binding;
    private DoctorListItemViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentDoctorprofileBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(DoctorListItemViewModel.class);
        super.onViewCreated(view, savedInstanceState);
        parseArgs();
        viewModel.doctorListItemLiveData.observe(getViewLifecycleOwner(), new Observer<DoctorListItem>() {
            @Override
            public void onChanged(DoctorListItem profileSettingListItem) {
                binding.doctorName.setText(DoctorListItem.getDoctorName());
                binding.doctorSpec.setText(DoctorListItem.getDoctorSpec());
                binding.doctorLogo.setImageResource(R.drawable.medical_59_icon_icons_com_73933);
                binding.backButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Navigation.findNavController(view).navigate(R.id.action_profile_to_list);
                    }
                });
            }
        });
    }

    private void parseArgs() {
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            int position = bundle.getInt(DoctorList.KEY_POS);
            viewModel.getDoctorListItemLiveData(position);
        }
    }
}