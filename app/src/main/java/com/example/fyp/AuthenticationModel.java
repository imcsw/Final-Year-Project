package com.example.fyp;

public class AuthenticationModel
{
    private String username, password;
    private int userID;

    public AuthenticationModel(String username, String password, int userID)
    {
        this.username = username;
        this.password = password;
        this.userID = userID;
    }

    @Override
    public String toString() {
        return "AuthenticationModel{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userID=" + userID +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}
