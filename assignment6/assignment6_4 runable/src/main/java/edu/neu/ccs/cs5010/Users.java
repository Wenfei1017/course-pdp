package edu.neu.ccs.cs5010;

import java.time.LocalDateTime;

/**
 *
 */
public class Users {
    private int usersID;
    private String createdDate;
    private String gender;
    private String age;
    private String city;
    private int follows;

    public Users(int ID, String date, String gender, String age, String city){
        this.usersID = ID;
        this.createdDate = date;
        this.gender = gender;
        this.age = age;
        this.city = city;
    }

    public int getUsersID() {
        return usersID;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public String getGender() {
        return gender;
    }

    public String getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    /*public void setFollows(int followNum){
        this.follows = followNum;
    }*/

    public int getFollows() {
        return follows;
    }
}


