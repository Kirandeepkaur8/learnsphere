package com.cpan228.learnsphere.model;

public enum CourseCategory {

    PROGRAMMING("Programming"),
    WEB_DEVELOPMENT("Web Development"),
    DATA_SCIENCE("Data Science"),
    DATABASES("Databases"),
    CYBERSECURITY("Cybersecurity"),
    BUSINESS("Business");

    private final String displayName;

    CourseCategory(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}