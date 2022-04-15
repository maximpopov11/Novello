package com.yn_1.novello_app.chat;

import com.yn_1.novello_app.account.User;
import com.yn_1.novello_app.message.Message;

import java.util.List;

public class Chat {
    private int chatId;
    private List<User> users;
    private List<Message> messages;

    public Chat(int chatId, List<User> users, List<Message> messages) {
        this.chatId = chatId;
        this.users = users;
        this.messages = messages;
    }

    public int getChatId() {
        return chatId;
    }

    public List<User> getUsers() {
        return users;
    }

    public List<Message> getMessages() {
        return messages;
    }
}
