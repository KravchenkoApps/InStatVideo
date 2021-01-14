package com.example.instatvideo.request_video;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RequestVideo {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("match_id")
    @Expose
    private Integer matchId;
    @SerializedName("period")
    @Expose
    private Integer period;
    @SerializedName("server_id")
    @Expose
    private Integer serverId;
    @SerializedName("quality")
    @Expose
    private String quality;
    @SerializedName("folder")
    @Expose
    private String folder;
    @SerializedName("video_type")
    @Expose
    private String videoType;
    @SerializedName("abc")
    @Expose
    private String abc;
    @SerializedName("start_ms")
    @Expose
    private Integer startMs;
    @SerializedName("checksum")
    @Expose
    private long checksum;
    @SerializedName("size")
    @Expose
    private Integer size;
    @SerializedName("abc_type")
    @Expose
    private String abcType;
    @SerializedName("duration")
    @Expose
    private Integer duration;
    @SerializedName("fps")
    @Expose
    private Integer fps;
    @SerializedName("url_root")
    @Expose
    private String urlRoot;
    @SerializedName("url")
    @Expose
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMatchId() {
        return matchId;
    }

    public void setMatchId(Integer matchId) {
        this.matchId = matchId;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public Integer getServerId() {
        return serverId;
    }

    public void setServerId(Integer serverId) {
        this.serverId = serverId;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }

    public String getVideoType() {
        return videoType;
    }

    public void setVideoType(String videoType) {
        this.videoType = videoType;
    }

    public String getAbc() {
        return abc;
    }

    public void setAbc(String abc) {
        this.abc = abc;
    }

    public Integer getStartMs() {
        return startMs;
    }

    public void setStartMs(Integer startMs) {
        this.startMs = startMs;
    }

    public long getChecksum() {
        return checksum;
    }

    public void setChecksum(long checksum) {
        this.checksum = checksum;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getAbcType() {
        return abcType;
    }

    public void setAbcType(String abcType) {
        this.abcType = abcType;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getFps() {
        return fps;
    }

    public void setFps(Integer fps) {
        this.fps = fps;
    }

    public String getUrlRoot() {
        return urlRoot;
    }

    public void setUrlRoot(String urlRoot) {
        this.urlRoot = urlRoot;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
