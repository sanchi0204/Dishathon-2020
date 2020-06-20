package com.example.watcho.Model;

public class Review {
    private String name;
    private String rating;
    private String review;
    private String time;

    public Review(String name, String rating, String review, String time) {
        this.name = name;
        this.rating = rating;
        this.review = review;
        this.time = time;
    }

    public Review() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
