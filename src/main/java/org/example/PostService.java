package org.example;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostService {
    @GET("/posts/1")
    Call<String> getPostString();
}
