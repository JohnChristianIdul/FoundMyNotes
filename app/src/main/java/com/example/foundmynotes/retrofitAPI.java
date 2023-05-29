package com.example.foundmynotes;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface retrofitAPI {

    @GET
    Call<msgModal> getMessage(@Url String url);
}
