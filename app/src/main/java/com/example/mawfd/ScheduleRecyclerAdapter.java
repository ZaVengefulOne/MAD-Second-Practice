package com.example.mawfd;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
public class ScheduleRecyclerAdapter extends RecyclerView.Adapter<ScheduleRecyclerAdapter.ViewHolder> {

    private final LayoutInflater inflater;
    private final List<ScheduleRecyclerItem> items;

    public ScheduleRecyclerAdapter(Context context, List<ScheduleRecyclerItem> items){
        this.inflater = LayoutInflater.from(context);
        this.items = items;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_schedule_recycler, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ScheduleRecyclerItem item = items.get(position);
        holder.textView.setText(item.getSpecialityName());
        holder.imageView.setImageResource(item.getResource());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Profile " + (holder.getAdapterPosition() + 1), Toast.LENGTH_SHORT).show();
                Log.d("recyclerView", "Profile" + (holder.getAdapterPosition() + 1));
            }
        });
    }


    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView textView;
        final ImageView imageView;
        ViewHolder(View view){
            super(view);
            textView = view.findViewById(R.id.doctorProfile);
            imageView = view.findViewById(R.id.doctorLogo);
        }
    }

}
