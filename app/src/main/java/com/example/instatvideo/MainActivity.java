package com.example.instatvideo;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.example.instatvideo.request_match.RequestMatch;
import com.example.instatvideo.request_video.RequestVideo;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.List;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private TextView tvDate, tvTeam1, tvTeam2, tvTournament, tvScore1, tvScore2;
    private ListView lvListButtons;
    private List<RequestVideo> videoList;
    private List<String> listButtons;
    private List<String> listUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        //JSON BODY для Match
        JsonObject jsonParams = new JsonObject ();
            jsonParams.addProperty("_p_sport", 1);
            jsonParams.addProperty("_p_match_id", 1724836);

        JsonObject jsonBody = new JsonObject();
            jsonBody.addProperty("proc", "get_match_info");
            jsonBody.add("params", jsonParams);

        //JSON BODY для Video
        JsonObject jsonVideoParams = new JsonObject();
            jsonVideoParams.addProperty("match_id" , 1724836);
            jsonVideoParams.addProperty("sport_id", 1);

        //RETROFIT MATCH
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RequestApi requestApi = retrofit.create(RequestApi.class);
        Call<RequestMatch> requestMatchCall = requestApi.getMatch(jsonBody);
        requestMatchCall.enqueue(new Callback<RequestMatch>() {
            @Override
            public void onResponse(Call<RequestMatch> call, Response<RequestMatch> response) {
                if (response.isSuccessful()) {
                    Log.w("MY", "Успешно MATCH");
                    interceptor.level(HttpLoggingInterceptor.Level.BODY);

                    //заполняем данные по текущему матчу
                    String date = response.body().getDate().replace("T", "\nTime: ");
                    tvDate.setText(date);
                    tvTeam1.setText(response.body().getTeam1().getNameEng());
                    tvTeam2.setText(response.body().getTeam2().getNameEng());
                    int score_1 = response.body().getTeam1().getScore();
                    int score_2 = response.body().getTeam2().getScore();
                    tvScore1.setText(String.valueOf(score_1));
                    tvScore2.setText(String.valueOf(score_2));
                    tvTournament.setText(response.body().getTournament().getNameEng());
                }

                else {
                    Log.w("MY", "else retrofit = " + response.raw().toString());
                    interceptor.level(HttpLoggingInterceptor.Level.BODY);
                }
            }

            @Override
            public void onFailure(Call<RequestMatch> call, Throwable t) {
                Log.w("MY","onFailure RequestMatch " + t);
            }
        });

        //RETROFIT VIDEO
        HttpLoggingInterceptor interceptor2 = new HttpLoggingInterceptor();
        interceptor2.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client2 = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofitVideo = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .client(client2)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RequestApi requestApiVideo = retrofitVideo.create(RequestApi.class);
        Call<List<RequestVideo>> requestVideoCall = requestApiVideo.getVideo(jsonVideoParams);
        requestVideoCall.enqueue(new Callback<List<RequestVideo>>() {
            @Override
            public void onResponse(Call<List<RequestVideo>> call, Response<List<RequestVideo>> response) {
                if (response.isSuccessful()) {
                    Log.w("MY", "Успешно VIDEO");
                    videoList.addAll(response.body());

                    //устанавливаем наименования кнопок и записываем URLs в отдельный массив
                    for (int i = 0; i < videoList.size(); i++) {
                        RequestVideo requestVideoObject = videoList.get(i);
                        listButtons.add(requestVideoObject.getName() + "\n Quality: " + requestVideoObject.getQuality());
                        listUrl.add(requestVideoObject.getUrl());
                    }
                    // инициализируем адаптер
                    initAdapter();
                }
                else {
                    Log.w("MY", "else retrofitVideo = " + response.code());
                    interceptor2.level(HttpLoggingInterceptor.Level.BODY);
                }
            }

            @Override
            public void onFailure(Call<List<RequestVideo>> call, Throwable t) {
                Log.w("MY","onFailure RequestVideo " + t);
            }
        });

        //инициализируем кликер кнопок
        setOnClickItem();
    }


    //инициализируем переменные
    private void init() {
        tvDate = findViewById(R.id.tvDate);
        tvTeam1 = findViewById(R.id.tvTeam1);
        tvTeam2 = findViewById(R.id.tvTeam2);
        tvTournament = findViewById(R.id.tvTournament);
        tvScore1 = findViewById(R.id.tvScore1);
        tvScore2 = findViewById(R.id.tvScore2);
        videoList = new ArrayList<>();
        listButtons = new ArrayList<>();
        listUrl = new ArrayList<>();
        lvListButtons = findViewById(R.id.lvListButtons);
    }

    //инициализация адаптера
    private void initAdapter() {
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                R.layout.item_video, R.id.btVideo, listButtons);
        lvListButtons.setAdapter(arrayAdapter);
    }
        //кликер
        private void setOnClickItem() {
        lvListButtons.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, VideoActivity.class);
                intent.putExtra(Constant.INTENT, listUrl.get(position));
                startActivity(intent);
            }
        });
    }


}