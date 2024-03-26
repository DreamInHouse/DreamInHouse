package com.dreaminhouse.models;

/**
 * Reputation
 */
public class Reputation {
    public static int MAX_RATING = 10;
    public static int MIN_RATING = 1;
    int ratingValue;

    public void setRatingValue(int ratingValue) {
        if (ratingValue > MAX_RATING) {
            this.ratingValue = MAX_RATING;
        } else if (ratingValue < MIN_RATING) {
            this.ratingValue = MIN_RATING;
        } else {
            this.ratingValue = ratingValue;
        }
    }

    public int getRatingValue() {
        return ratingValue;
    }
}
