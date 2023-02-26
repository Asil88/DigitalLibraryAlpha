package com.digital_library.exception;

public class UserNotFoundException extends Exception {
    private int id;

    public UserNotFoundException(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User with id=" + id + " not found!";
    }
}