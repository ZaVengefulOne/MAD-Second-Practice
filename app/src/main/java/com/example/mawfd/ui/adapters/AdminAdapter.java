package com.example.mawfd.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.mawfd.R;

public class AdminAdapter extends RecyclerView.Adapter<AdminAdapter.ViewHolder> {

    private String[] mData;
    private String[] pData;

    public AdminAdapter(String[] data, String[] passwords) {
        mData = data;
        pData = passwords;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Создание нового View
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_admin, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // Заполнение данных в элемент View
        holder.mTextView.setText(mData[position]);
        holder.passwordView.setText(pData[position]);
    }

    @Override
    public int getItemCount() {
        return mData.length;
    }

    // Класс ViewHolder, хранящий ссылки на элементы View
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;
        public TextView passwordView;
        public ViewHolder(View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.name);
            passwordView = itemView.findViewById(R.id.password);
        }
    }
}