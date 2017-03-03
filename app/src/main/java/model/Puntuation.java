package model;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Santi on 03/03/2017.
 */

public class Puntuation {
    private int id;
    private String author;
    private String user;
    private String details;
    private String category;
    private int points;


    public Puntuation(int id, String author, String user, String details, String category, int points) {
        this.id = id;
        this.author = author;
        this.user = user;
        this.details = details;
        this.category = category;
        this.points = points;
    }


    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("author", author);
        result.put("category", category);
        result.put("details", details);
        result.put("details", points);
        result.put("user", user);
        return result;
    }


    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
