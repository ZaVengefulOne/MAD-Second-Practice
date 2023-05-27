package com.example.mawfd.data.repositories;


import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.mawfd.data.API.RetrofitFactory;
import com.example.mawfd.data.API.TypeCodeAPI;
import com.example.mawfd.data.models.PlaceholderPost;
import com.example.mawfd.data.database.entity.Doctor;
import com.example.mawfd.data.protocols.DoctorsProtocol;
import com.example.mawfd.data.datasource.DoctorsDataSource;
import com.example.mawfd.data.models.DoctorListItem;

import retrofit2.Callback;
import retrofit2.Response;
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
    public LiveData<PlaceholderPost> getPost() {
        Retrofit retrofit = RetrofitFactory.getRetrofit();
        TypeCodeAPI typeCodeAPI = retrofit.create(TypeCodeAPI.class);
        Call<PlaceholderPost> call = typeCodeAPI.getPost();
        MutableLiveData<PlaceholderPost> postLD = new MutableLiveData<>();
        call.enqueue(new Callback<PlaceholderPost>() {
            @Override
            public void onResponse(Call<PlaceholderPost> call, Response<PlaceholderPost> response) {
                if (response.isSuccessful()){
                    PlaceholderPost post = response.body();
                    postLD.setValue(post);
                }
            }

            @Override
            public void onFailure(Call<PlaceholderPost> call, Throwable t) {

            }
        });
        return postLD;
    }

    @Override
    public LiveData<PlaceholderPost> pushPost() {
        Retrofit retrofit = RetrofitFactory.getRetrofit();
        TypeCodeAPI typeCodeAPI = retrofit.create(TypeCodeAPI.class);
        Call<PlaceholderPost> call = typeCodeAPI.pushPost(new PlaceholderPost(42, 69, "Korega requiem da", "RU"));
        MutableLiveData<PlaceholderPost> pushLD = new MutableLiveData<>();
        call.enqueue(new Callback<PlaceholderPost>() {
            @Override
            public void onResponse(Call<PlaceholderPost> call, Response<PlaceholderPost> response) {
                if (response.isSuccessful()){
                    PlaceholderPost post = response.body();
                    pushLD.setValue(post);
                }
            }

            @Override
            public void onFailure(Call<PlaceholderPost> call, Throwable t) {

            }
        });
        return pushLD;
    }

    @Override
    public LiveData<List<PlaceholderPost>> getAllPosts() {
        Retrofit retrofit = RetrofitFactory.getRetrofit();
        TypeCodeAPI typeCodeAPI = retrofit.create(TypeCodeAPI.class);
        Call<List<PlaceholderPost>> call = typeCodeAPI.getAllPosts();
        MutableLiveData<List<PlaceholderPost>> getLD = new MutableLiveData<>();
        call.enqueue(new Callback<List<PlaceholderPost>>() {
            @Override
            public void onResponse(Call<List<PlaceholderPost>> call, Response<List<PlaceholderPost>> response) {
                if (response.isSuccessful()){
                    List<PlaceholderPost> post = response.body();
                    getLD.setValue(post);
                }
            }

            @Override
            public void onFailure(Call<List<PlaceholderPost>> call, Throwable t) {

            }
        });
        return getLD;
    }

}