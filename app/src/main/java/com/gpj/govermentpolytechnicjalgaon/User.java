package com.gpj.govermentpolytechnicjalgaon;

import java.util.HashMap;
import java.util.Map;

public class User
{

    private String login;
    private Integer id;
    private String nodeId;
    private String avatarUrl;
    private String gravatarId;
    private String url;
    private String htmlUrl;
    private String followersUrl;
    private String followingUrl;
    private String gistsUrl;
    private String starredUrl;
    private String subscriptionsUrl;
    private String organizationsUrl;
    private String reposUrl;
    private String eventsUrl;
    private String receivedEventsUrl;
    private String type;
    private Boolean siteAdmin;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }


    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

}
