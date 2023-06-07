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
import com.example.mawfd.data.database.entity.Appointment;
import com.example.mawfd.databinding.FragmentAppointmentBinding;
import com.example.mawfd.databinding.FragmentAppointmentsBinding;
import com.example.mawfd.databinding.FragmentPatientBinding;
import com.example.mawfd.ui.stateholder.viewModels.AppointmentViewModel;
import com.example.mawfd.ui.stateholder.viewModels.PatientFragmentViewModel;

public class AppointmentFragment extends Fragment {

    private AppointmentViewModel viewModel;
    private AppointmentFragmentArgs args;
    private FragmentAppointmentBinding binding;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        args = AppointmentFragmentArgs.fromBundle(getArguments());
        binding = FragmentAppointmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(this).get(AppointmentViewModel.class);
        viewModel.getAppointmentItem(args.getId());
        viewModel.appointmentLiveData.observe(getViewLifecycleOwner(), Appointment -> {
            binding.doctorNameApp.setText(Appointment.getDoctorName());
            binding.doctorSpecApp.setText(Appointment.getDoctorSpec());
            binding.namePatientApp.setText(Appointment.getPatientName());
            binding.diagnosisPatientApp.setText(Appointment.getPatientDiagnosis());
        });

        binding.deleteButton.setOnClickListener(v -> {
            viewModel.deleteAppointment(args.getId());
            Navigation.findNavController(requireView()).navigateUp();
        });
        binding.saveButton.setOnClickListener(v -> viewModel.updateAppointment(
                args.getId(),
                binding.doctorNameApp.getText().toString(),
                binding.doctorSpecApp.getText().toString(),
                binding.namePatientApp.getText().toString(),
                binding.diagnosisPatientApp.getText().toString()
        ));

        binding.buttonBack.setOnClickListener(view1 ->
                Navigation.findNavController(requireView()).navigate(R.id.action_appointment_to_appointments)
        );
    }
}
