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
        repository.getPost().enqueue(new Callback<PlaceholderPost>() {
            @Override
            public void onResponse(Call<PlaceholderPost> call, Response<PlaceholderPost> response) {
                if (response.isSuccessful()) {
                    PlaceholderPost post = response.body();
                    postLD.setValue(post);
                }
            }

            @Override
            public void onFailure(Call<PlaceholderPost> call, Throwable t) {

            }
        });

        repository.pushPost(new PlaceholderPost(42, 69, "Korega requiem da", "RU")).enqueue(new Callback<PlaceholderPost>() {
            @Override
            public void onResponse(Call<PlaceholderPost> call, Response<PlaceholderPost> response) {
                if (response.isSuccessful()) {
                    PlaceholderPost post = response.body();
                    pushLD.setValue(post);
                }
            }

            @Override
            public void onFailure(Call<PlaceholderPost> call, Throwable t) {

            }
        });
        repository.getAllPosts().enqueue(new Callback<List<PlaceholderPost>>() {
            @Override
            public void onResponse(Call<List<PlaceholderPost>> call, Response<List<PlaceholderPost>> response) {
                if (response.isSuccessful()) {
                    List<PlaceholderPost> post = response.body();
                    getLD.setValue(post);
                }
            }

            @Override
            public void onFailure(Call<List<PlaceholderPost>> call, Throwable t) {

            }
        });
    }
    private static MutableLiveData<PlaceholderPost> postLD = new MutableLiveData<>();

    public static LiveData<PlaceholderPost> getPostLD() {
        return postLD;
    }

    private static MutableLiveData<PlaceholderPost> pushLD = new MutableLiveData<>();

    public static LiveData<PlaceholderPost> getPushLD() {
        return pushLD;
    }

    private static MutableLiveData<List<PlaceholderPost>> getLD = new MutableLiveData<>();

    public static LiveData<List<PlaceholderPost>> getListLD() {
        return getLD;
    }
}
