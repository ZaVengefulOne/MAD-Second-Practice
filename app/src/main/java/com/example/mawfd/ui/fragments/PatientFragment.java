package com.example.mawfd.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.mawfd.R;
import com.example.mawfd.databinding.FragmentPatientBinding;
import com.example.mawfd.ui.stateholder.viewModels.PatientFragmentViewModel;

public class PatientFragment extends Fragment {

    private PatientFragmentViewModel viewModel;
    private PatientFragmentArgs args;
    private FragmentPatientBinding binding;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        args = PatientFragmentArgs.fromBundle(getArguments());
        binding = FragmentPatientBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(this).get(PatientFragmentViewModel.class);
        viewModel.getPatientItem(args.getId());
        viewModel.patientLiveData.observe(getViewLifecycleOwner(), Patient -> {
            binding.namePatient.setText(Patient.getName());
            binding.agePatient.setText(String.valueOf(Patient.getAge()));
            binding.diagnosisPatient.setText(Patient.getDiagnosis());
        });

        binding.deleteButton.setOnClickListener(v -> {
            viewModel.deletePatient(args.getId());
            Navigation.findNavController(requireView()).navigateUp();
        });
        binding.saveButton.setOnClickListener(v -> viewModel.updatePatient(
                args.getId(),
                binding.namePatient.getText().toString(),
                binding.diagnosisPatient.getText().toString(),
                Integer.parseInt(binding.agePatient.getText().toString())
        ));

        binding.buttonBack.setOnClickListener(view1 ->
                Navigation.findNavController(requireView()).navigate(R.id.action_patient_to_library)
        );
    }
}
