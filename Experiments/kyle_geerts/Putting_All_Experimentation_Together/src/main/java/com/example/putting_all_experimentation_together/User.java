package com.example.putting_all_experimentation_together;

public class User {

    private String userId;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String genre;

    public User(){

    }
    public User(String firstName, String lastName, String userName, String password, String genre){
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.genre = genre;
    }

    public String getFirstName(){return this.firstName;}

    public void setFirstName(String firstName){this.firstName = firstName;}

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return  userId + " "
                + firstName + " "
                + lastName + " "
                + userName + " "
                + password + " "
                + genre;
    }

}
