package model;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Santi on 26/02/2017.
 */

public class User {
    private String userMail;
    private String userName;
    private int actualPoints;
    private String id;

    public User(String userMail, String userName) {
        this.userMail = userMail;
        this.userName = userName;
        this.id = prepareId(userMail);

    }

    public User(GoogleSignInAccount signInAccount) {
        this.userMail = signInAccount.getEmail();
        this.userName = signInAccount.getDisplayName();
        this.id = prepareId(userMail);

    }

    private String prepareId(String userMail) {
        String direccion = userMail.split("@")[0];
        direccion = direccion.replace(".", "");
        direccion = direccion.replace(",", "");
        direccion = direccion.replace(":", "");
        direccion = direccion.replace("_", "");
        direccion = direccion.replace("-", "");
        return direccion;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("userMail", userMail);
        result.put("userName", userName);
        result.put("actualPoints", actualPoints);
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

    public int getActualPoints() {
        return actualPoints;
    }

    public void setActualPoints(int actualPoints) {
        this.actualPoints = actualPoints;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
