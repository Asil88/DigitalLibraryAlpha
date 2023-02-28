package com.digital_library.exception;

public class ArticleNotFoundException extends Exception {
    private int id;

    public ArticleNotFoundException(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Article with id=" + id + " not found!";
    }
}