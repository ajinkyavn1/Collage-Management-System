package com.gpj.govermentpolytechnicjalgaon.Comman_Class;

import java.util.HashMap;
import java.util.Map;

public class User
{
    private String url;
    private String name;
    private String login;
    private String avatarUrl;

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


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
