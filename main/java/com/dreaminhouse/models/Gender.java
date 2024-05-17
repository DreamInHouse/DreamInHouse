package com.dreaminhouse.models;

/**
 * Gender
 */
public class Gender {
    public enum GenderType {
        CISGENDER_MALE,
        CISGENDER_FEMALE,
        TRANSGENDER_MALE,
        TRANSGENDER_FEMALE,
        PREFER_NOT_TO_SAY,
        OTHER
    }

    private GenderType type;
    private String customOther;

    public Gender(GenderType genderType, String other) {
        this.type = genderType;
        if (this.type == GenderType.OTHER) {
            this.customOther = other;
        }
    }

    public GenderType getType() {
        return type;
    }

    public void setType(GenderType type) {
        this.type = type;
    }

    public String getCustomOther() {
        return customOther;
    }

    public void setCustomOther(String customOther) {
        this.customOther = customOther;
    }
}
