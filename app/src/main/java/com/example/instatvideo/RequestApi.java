package com.example.instatvideo;

import com.example.instatvideo.request_match.RequestMatch;
import com.example.instatvideo.request_video.RequestVideo;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.OPTIONS;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RequestApi {

    @POST("data")
    @Headers("Content-Type: application/json")
    Call<RequestMatch> getMatch(@Body JsonObject body);

    @POST("video-urls")
    @Headers("Content-Type: application/json")
    Call<List<RequestVideo>> getVideo(@Body JsonObject body);

}


