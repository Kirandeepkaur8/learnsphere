package com.cpan228.learnsphere.model;

public enum Role {

    STUDENT("Student"),
    INSTRUCTOR("Instructor"),
    ADMIN("Administrator");

    private final String displayName;

    Role(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getAuthority() {
        return "ROLE_" + name();
    }
}