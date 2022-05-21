package com.geteatwithme.geteatwithme.model;

public class Post {
    String id;
    String restaurant;
    double longitude;
    double latitude;
    String meeting_place;
    int category;
    int max_people;
    int cur_people;
    int gender;
    String meeting_date;
    String meeting_time;
    String contents;
    int age;
    double meet_x;
    double meet_y;
    int restaurant_id;
    int visible;
    int post_id;

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public double getMeet_x() {
        return meet_x;
    }

    public void setMeet_x(double meet_x) {
        this.meet_x = meet_x;
    }

    public double getMeet_y() {
        return meet_y;
    }

    public void setMeet_y(double meet_y) {
        this.meet_y = meet_y;
    }

    public int getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(int restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    public int getVisible() {
        return visible;
    }

    public void setVisible(int visible) {
        this.visible = visible;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(String restaurant) {
        this.restaurant = restaurant;
    }

    public double getLongitude() {return longitude; }

    public void setLongitude(double longitude){ this.longitude = longitude;}

    public double getLatitude() { return latitude; }

    public void setLatitude(double latitude) { this.latitude = latitude; }

    public String getMeeting_date() { return meeting_date; }

    public void setMeeting_date(String meeting_date) { this.meeting_date = meeting_date;}

    public String getMeeting_place() {return meeting_place;}

    public void setMeeting_place(String meeting_place) {
        this.meeting_place = meeting_place;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getMax_people() {
        return max_people;
    }

    public void setMax_people(int max_people) {
        this.max_people = max_people;
    }

    public int getCur_people() {
        return cur_people;
    }

    public void setCur_people(int cur_people) {
        this.cur_people = cur_people;
    }

    public String getMeeting_time() {
        return meeting_time;
    }

    public void setMeeting_time(String meeting_time) {
        this.meeting_time = meeting_time;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public int getGender(){ return gender;}

    public void setGender(int gender){ this.gender = gender;}
}
