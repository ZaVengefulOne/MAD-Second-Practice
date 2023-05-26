package com.example.mawfd.data.repositories;


import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.mawfd.data.API.RetrofitFactory;
import com.example.mawfd.data.API.TypeCodeAPI;
import com.example.mawfd.data.models.PlaceholderPost;
import com.example.mawfd.data.database.entity.Doctor;
import com.example.mawfd.data.protocols.DoctorsProtocol;
import com.example.mawfd.data.datasource.DoctorsDataSource;
import com.example.mawfd.data.models.DoctorListItem;
import retrofit2.Retrofit;
import retrofit2.Call;

import java.util.List;

public class DoctorsRepository implements DoctorsProtocol {

    private final Context context;
    private final DoctorsDataSource dataSource;

    public DoctorsRepository(Context context){
        this.context = context;
        dataSource = new DoctorsDataSource(context);
    }

    @Override
    public LiveData<List<Doctor>> getDoctorList() {
        return dataSource.getDoctorList();
    }

    @Override
    public LiveData<Doctor> getDoctorItem(int position) {
        return dataSource.getDoctorItem(position);
    }
    @Override
    public Call<PlaceholderPost> getPost() {
        Retrofit retrofit = RetrofitFactory.getRetrofit();
        TypeCodeAPI typeCodeAPI = retrofit.create(TypeCodeAPI.class);
        Call<PlaceholderPost> call = typeCodeAPI.getPost();
        return call;
    }

    @Override
    public Call<PlaceholderPost> pushPost(PlaceholderPost post) {
        Retrofit retrofit = RetrofitFactory.getRetrofit();
        TypeCodeAPI typeCodeAPI = retrofit.create(TypeCodeAPI.class);
        Call<PlaceholderPost> call = typeCodeAPI.pushPost(post);
        return call;
    }

    @Override
    public Call<List<PlaceholderPost>> getAllPosts() {
        Retrofit retrofit = RetrofitFactory.getRetrofit();
        TypeCodeAPI typeCodeAPI = retrofit.create(TypeCodeAPI.class);
        Call<List<PlaceholderPost>> call = typeCodeAPI.getAllPosts();
        return call;
    }

}