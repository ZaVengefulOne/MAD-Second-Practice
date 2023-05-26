package com.example.mawfd.data.API;

import com.example.mawfd.data.models.PlaceholderPost;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface TypeCodeAPI {
    @GET("posts/99")
    Call<PlaceholderPost> getPost();

    @POST("posts")
    Call<PlaceholderPost> pushPost(@Body PlaceholderPost post);

    @GET("posts")
    Call<List<PlaceholderPost>> getAllPosts();
}