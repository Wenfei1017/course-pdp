package edu.neu.ccs.cs5010;

/**
 * The type Users.
 */
public class Users {
    private int usersID;
    private String createdDate;
    private String gender;
    private String age;
    private String city;
    private int follows;
    private int recommendTimes;

    /**
     * Instantiates a new Users.
     *
     * @param userId     the id
     * @param date   the date
     * @param gender the gender
     * @param age    the age
     * @param city   the city
     */
    public Users(int userId, String date, String gender, String age, String city){
        this.usersID = userId;
        this.createdDate = date;
        this.gender = gender;
        this.age = age;
        this.city = city;
        this.recommendTimes = 0;
    }

    /**
     * Increase recommend times.
     */
    public void increaseRecommendTimes() {
        this.recommendTimes++;
    }

    /**
     * Gets recommend times.
     *
     * @return the recommend times
     */
    public int getRecommendTimes() {
        return this.recommendTimes;
    }

    /**
     * Gets users id.
     *
     * @return the users id
     */
    public int getUsersID() {
        return usersID;
    }

    /**
     * Gets created date.
     *
     * @return the created date
     */
    public String getCreatedDate() {
        return createdDate;
    }

    /**
     * Gets gender.
     *
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * Gets age.
     *
     * @return the age
     */
    public String getAge() {
        return age;
    }

    /**
     * Gets city.
     *
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * Get user users.
     *
     * @param userId the id
     * @return the users
     */
    public Users getUser(int userId){
        return this;
    }

    /**
     * Gets follows.
     *
     * @return the follows
     */
    public int getFollows() {
        return follows;
    }
}


