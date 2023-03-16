package com.example.mawfd;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ScheduleListAdapter extends ArrayAdapter<ScheduleListItem> {
    private LayoutInflater inflater;
    private int layout;
    private List<ScheduleListItem> items;

    public ScheduleListAdapter(@NonNull Context context, int resource, @NonNull List<ScheduleListItem> objects)
    {
        super(context, resource, objects);
        this.items = objects;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = inflater.inflate(this.layout, parent, false);
        TextView textView = view.findViewById(R.id.doctorProfile);
        ImageView imageView = view.findViewById(R.id.doctorLogo);
        ScheduleListItem item = items.get(position);
        textView.setText(item.getCategoryTitle());
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Profile " + (position + 1), Toast.LENGTH_SHORT).show();
                Log.d("listView", "Profile " + (position + 1));
            }
        });

        return view;
    }
}
