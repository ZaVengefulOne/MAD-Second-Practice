package com.example.mawfd.ui.stateholder.viewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.mawfd.data.database.entity.Doctor;
import com.example.mawfd.data.models.DoctorListItem;
import com.example.mawfd.data.models.PlaceholderPost;
import com.example.mawfd.data.repositories.DoctorsRepository;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StartFrameViewModel extends AndroidViewModel {
    private final DoctorsRepository repository = new DoctorsRepository(getApplication());

    public LiveData<List<Doctor>> listLiveData = repository.getDoctorList();

    public StartFrameViewModel(@NonNull Application application) {

        super(application);

    }
    public LiveData<PlaceholderPost> postLD = repository.getPost();
    public LiveData<PlaceholderPost> pushLD = repository.pushPost();
    public LiveData<List<PlaceholderPost>> getLD = repository.getAllPosts();

}
