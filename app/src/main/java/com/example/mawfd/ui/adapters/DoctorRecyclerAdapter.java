package com.example.mawfd.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mawfd.R;
import com.example.mawfd.data.database.entity.Doctor;
import com.example.mawfd.data.database.entity.Patient;
import com.example.mawfd.databinding.ItemScheduleRecyclerBinding;

import java.util.ArrayList;
import java.util.List;

public class DoctorRecyclerAdapter extends RecyclerView.Adapter<DoctorRecyclerAdapter.DoctorViewHolder> {
    public OnDoctorListClickListener onDoctorListItemListener = null;
    private List<Doctor> doctors = new ArrayList<>();


    public DoctorRecyclerAdapter(DoctorRecyclerAdapter.OnDoctorListClickListener onDoctorListItemListener) {
        this.onDoctorListItemListener = onDoctorListItemListener;
    }

    @NonNull
    @Override
    public DoctorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DoctorViewHolder(ItemScheduleRecyclerBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false
        ));
    }

    @Override
    public void onBindViewHolder(@NonNull DoctorViewHolder holder, int position) {
        Doctor doctor = doctors.get(position);
        holder.binding.getRoot().setOnClickListener(v -> onDoctorListItemListener.onClick(doctor.getId()));
        holder.binding.doctorName.setText(doctor.getDoctorName());
        holder.binding.doctorSpec.setText(doctor.getDoctorSpec());
        holder.binding.doctorLogo.setImageResource(R.drawable.medical_59_icon_icons_com_73933);
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                onDoctorListItemListener.onDoctorItemListClickListener(holder.getAdapterPosition());
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return doctors.size();
    }

    public void setItems(List<Doctor> doctors) {
        int count = getItemCount();
        this.doctors = new ArrayList<>(doctors);
        notifyItemRangeChanged(0, Math.max(count, getItemCount()));
    }

    public interface OnDoctorListClickListener {
        void onClick(int position);
    }

    static class DoctorViewHolder extends RecyclerView.ViewHolder{
//        TextView textView;
//        TextView textView2;
//        ImageView imageView;
        ItemScheduleRecyclerBinding binding;
        public DoctorViewHolder(@NonNull ItemScheduleRecyclerBinding binding)
        {
//        super(itemView);
//        textView = itemView.findViewById(R.id.doctorName);
//        textView2 = itemView.findViewById(R.id.doctorSpec);
//        imageView = itemView.findViewById(R.id.doctorLogo);
            super(binding.getRoot());
            this.binding = binding;
        }

    }
}
