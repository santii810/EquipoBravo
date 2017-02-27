package model;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Santi on 26/02/2017.
 */

public class User {
    private String userMail;
    private String userName;
    private int points;

    public User(String userMail, String userName) {
        this.userMail = userMail;
        this.userName = userName;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("userMail", userMail);
        result.put("userName", userName);
        result.put("points", points);
        return result;
    }


    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }


}
