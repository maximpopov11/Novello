package com.yn_1.novello_app.message;

public class Message {
    private int messageId;
    private int userId;
    private String message;

    public Message(int messageId, int userId, String message) {
        this.messageId = messageId;
        this.userId = userId;
        this.messageId = messageId;
    }

    public int getMessageId() {
        return messageId;
    }

    public int getUserId() {
        return userId;
    }

    public String getMessage() {
        return message;
    }
}
