package com.kei.tliaswebmanagement1.pojo;


/* 封装登录结果*/
public class LoginInfo {
    private Integer id;
    private String username;
    private String name;
    private String token;
    private String image;

    public LoginInfo(Integer id, String username, String name, String token, String image) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.token = token;
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "LoginInfo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", token='" + token + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
