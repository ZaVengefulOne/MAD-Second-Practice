package com.example.mawfd.data.protocols;

import androidx.lifecycle.LiveData;

import com.example.mawfd.data.database.entity.Doctor;
import com.example.mawfd.data.models.DoctorListItem;
import com.example.mawfd.data.models.PlaceholderPost;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface DoctorsProtocol {
    LiveData<List<Doctor>> getDoctorList();

    LiveData<Doctor> getDoctorItem(int position);

    LiveData<PlaceholderPost> getPost();

    LiveData<PlaceholderPost> pushPost();

    LiveData<List<PlaceholderPost>> getAllPosts();

}
