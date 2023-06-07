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
import com.example.mawfd.data.database.entity.Doctor;
import com.example.mawfd.data.models.DoctorListItem;
import com.example.mawfd.databinding.FragmentDoctorprofileBinding;
import com.example.mawfd.ui.stateholder.viewModels.DoctorListItemViewModel;

public class DoctorProfile extends Fragment {

    private FragmentDoctorprofileBinding binding;
    private DoctorListItemViewModel viewModel;
    private DoctorProfileArgs args;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        args = DoctorProfileArgs.fromBundle(getArguments());
        binding = FragmentDoctorprofileBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(this).get(DoctorListItemViewModel.class);
//        parseArgs();
        viewModel.getDoctorItem(args.getId());
        viewModel.doctorListItemLiveData.observe(getViewLifecycleOwner(), Doctor -> {
            binding.doctorName.setText(Doctor.getDoctorName());
            binding.doctorSpec.setText(Doctor.getDoctorSpec());
        });
        binding.deleteButton.setOnClickListener(v -> {
            viewModel.deleteDoctor(args.getId());
            Navigation.findNavController(requireView()).navigateUp();
        });
        binding.saveButton.setOnClickListener(v -> viewModel.updatePatient(
                args.getId(),
                binding.doctorName.getText().toString(),
                binding.doctorSpec.getText().toString()
        ));

        binding.buttonBack.setOnClickListener(view1 ->
                Navigation.findNavController(requireView()).navigate(R.id.action_profile_to_list)
        );
    }

//    private void parseArgs() {
//        Bundle bundle = this.getArguments();
//        if (bundle != null) {
//            int position = bundle.getInt(DoctorList.KEY_POS);
//            viewModel.getDoctorListItemLiveData(position);
//        }
//    }
}