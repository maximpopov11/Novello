package com.example.ex4bettersb;

public class TestData {

    private String message;
    private int uid;

    public TestData() {}

    public TestData(String message, int uid) {
        this.message = message;
        this.uid = uid;
    }

    public String getMessage() {
        return message;
    }
    public int getUid(){return uid;}
}
