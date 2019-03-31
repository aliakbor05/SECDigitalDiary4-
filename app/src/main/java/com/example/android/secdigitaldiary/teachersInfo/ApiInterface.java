package com.example.android.secdigitaldiary.teachersInfo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("getinfo.php")
    Call<List<Info>> getInfo();
}
