package com.example.instatvideo.request_match;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RequestMatch {

    @SerializedName("tournament")
    @Expose
    private Tournament tournament;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("team1")
    @Expose
    private Team1 team1;
    @SerializedName("team2")
    @Expose
    private Team2 team2;
    @SerializedName("stream_status")
    @Expose
    private Integer streamStatus;

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Team1 getTeam1() {
        return team1;
    }

    public void setTeam1(Team1 team1) {
        this.team1 = team1;
    }

    public Team2 getTeam2() {
        return team2;
    }

    public void setTeam2(Team2 team2) {
        this.team2 = team2;
    }

    public Integer getStreamStatus() {
        return streamStatus;
    }

    public void setStreamStatus(Integer streamStatus) {
        this.streamStatus = streamStatus;
    }

}
