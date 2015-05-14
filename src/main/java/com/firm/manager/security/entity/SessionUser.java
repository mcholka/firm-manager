package com.firm.manager.security.entity;

public class SessionUser {

    private final String username;

    public SessionUser(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return getUsername();
    }
}
