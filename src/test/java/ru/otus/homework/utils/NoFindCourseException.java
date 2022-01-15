package ru.otus.homework.utils;

public class NoFindCourseException extends Exception {
    public void printException(String searchText) {
        System.out.println("!!!...");
        System.out.println("!!! Course " + searchText + " not found...");
        System.out.println("!!!...");
    }
}

