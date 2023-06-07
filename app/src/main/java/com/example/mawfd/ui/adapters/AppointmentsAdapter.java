package com.example.mawfd.ui.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mawfd.R;
import com.example.mawfd.data.database.entity.Appointment;
import com.example.mawfd.data.database.entity.Patient;
import com.example.mawfd.databinding.ItemAppointmentBinding;
import com.example.mawfd.databinding.ItemPatientBinding;
import com.example.mawfd.ui.stateholder.viewModels.AppointmentViewModel;

import java.util.ArrayList;
import java.util.List;

public class AppointmentsAdapter extends RecyclerView.Adapter<AppointmentsAdapter.AppointmentViewHolder> {

    public OnAppointmentClickListener onAppointmentClickListener = null;

    private List<Appointment> appointments = new ArrayList<>();

    public AppointmentsAdapter(OnAppointmentClickListener onAppointmentClickListener) {
        this.onAppointmentClickListener = onAppointmentClickListener;
    }


    @NonNull
    @Override
    public AppointmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AppointmentViewHolder(ItemAppointmentBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull AppointmentsAdapter.AppointmentViewHolder holder, int position) {
        Appointment appointment = appointments.get(position);
        holder.binding.getRoot().setOnClickListener(v -> onAppointmentClickListener.onClick(appointment.getId()));
        holder.binding.imageView5.setImageResource(R.drawable.appointment);
        holder.binding.appointmentDoctorName.setText(appointment.getDoctorName());
        holder.binding.appointmentDoctorSpec.setText(appointment.getDoctorSpec());
        holder.binding.appointmentPatientDiagnosis.setText(appointment.getPatientDiagnosis());
        holder.binding.appointmentPatientName.setText(appointment.getPatientName());
    }

    @Override
    public int getItemCount() {
        return appointments.size();
    }

    public void setItems(List<Appointment> appointments) {
        int count = getItemCount();
        this.appointments = new ArrayList<>(appointments);
        notifyItemRangeChanged(0, Math.max(count, getItemCount()));
    }

    public interface OnAppointmentClickListener {
        void onClick(int position);
    }
    static class AppointmentViewHolder extends RecyclerView.ViewHolder{
        public CheckBox checkBox;
        ItemAppointmentBinding binding;

        public AppointmentViewHolder(@NonNull ItemAppointmentBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }


}
