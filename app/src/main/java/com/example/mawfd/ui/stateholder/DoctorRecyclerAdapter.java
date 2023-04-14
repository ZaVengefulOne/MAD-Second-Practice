package com.example.mawfd.ui.stateholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mawfd.R;
import com.example.mawfd.data.database.entity.DoctorListItem;

import java.util.List;

public class DoctorRecyclerAdapter extends RecyclerView.Adapter<DoctorRecyclerAdapter.DoctorViewHolder> {
    public OnDoctorListClickListener onDoctorListItemListener = null;
    private List<DoctorListItem> items;

    public DoctorRecyclerAdapter(List<DoctorListItem> items){
        this.items = items;

    }
    @NonNull
    @Override
    public DoctorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_schedule_recycler, parent, false);

        return new DoctorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DoctorViewHolder holder, int position) {
        DoctorListItem item = items.get(position);
        holder.textView.setText(DoctorListItem.getDoctorName());
        holder.textView2.setText(DoctorListItem.getDoctorSpec());
        holder.imageView.setImageResource(R.drawable.medical_59_icon_icons_com_73933);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onDoctorListItemListener.onDoctorItemListClickListener(holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class DoctorViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        TextView textView2;
        ImageView imageView;
        public DoctorViewHolder(@NonNull View itemView)
        {
        super(itemView);
        textView = itemView.findViewById(R.id.doctorName);
        textView2 = itemView.findViewById(R.id.doctorSpec);
        imageView = itemView.findViewById(R.id.doctorLogo);
        }

    }
    public interface OnDoctorListClickListener {
        void onDoctorItemListClickListener(int position);
    }
}
