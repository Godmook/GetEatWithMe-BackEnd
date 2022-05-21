package com.geteatwithme.geteatwithme.model;

public class UserProfile {
    private String id;  //아이디
    private String name;    //이름
    private int gender;  //성별   //0 : 남자 1 : 여자
    private String password; //비밀번호
    private int age; //나이
    private String nickname;//닉네임
    private String token_id;

    public String getToken_id() {
        return token_id;
    }

    public void setToken_id(String token_id) {
        this.token_id = token_id;
    }

    public UserProfile(String id, String name, int gender, String password, int age, String nickname, String token_id) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.password = password;
        this.age = age;
        this.nickname = nickname;
        this.token_id = token_id;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getGender() {
        return gender;
    }

    public String getPassword() {
        return password;
    }

    public int getAge() {
        return age;
    }

    public String getNickname() {
        return nickname;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
