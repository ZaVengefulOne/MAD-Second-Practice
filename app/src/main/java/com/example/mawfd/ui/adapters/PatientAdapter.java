package com.example.mawfd.ui.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mawfd.R;
import com.example.mawfd.data.database.entity.Patient;
import com.example.mawfd.databinding.ItemPatientBinding;

import java.util.ArrayList;
import java.util.List;

public class PatientAdapter extends RecyclerView.Adapter<PatientAdapter.PatientViewHolder> {

    public OnPatientClickListener onPatientClickListener = null;

    private List<Patient> patients = new ArrayList<>();

    public PatientAdapter(OnPatientClickListener onPatientClickListener) {
        this.onPatientClickListener = onPatientClickListener;
    }


    @NonNull
    @Override
    public PatientViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PatientViewHolder(ItemPatientBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull PatientViewHolder holder, int position) {
        Patient patient= patients.get(position);
        holder.binding.getRoot().setOnClickListener(v -> onPatientClickListener.onClick(patient.getId()));
        holder.binding.patientImage.setImageResource(R.drawable.patient);
        holder.binding.patientName.setText(patient.getName());
        holder.binding.patientAge.setText(String.valueOf(patient.getAge()));
        holder.binding.patientDiagnosis.setText(patient.getDiagnosis());
    }

    @Override
    public int getItemCount() {
        return patients.size();
    }

    public void setItems(List<Patient> patients) {
        int count = getItemCount();
        this.patients = new ArrayList<>(patients);
        notifyItemRangeChanged(0, Math.max(count, getItemCount()));
    }

    public interface OnPatientClickListener {
        void onClick(int position);
    }
    static class PatientViewHolder extends RecyclerView.ViewHolder{
        public CheckBox checkBox;
        ItemPatientBinding binding;

        public PatientViewHolder(@NonNull ItemPatientBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }


}
