package com.yn_1.novello_app.create_chat;

import com.yn_1.novello_app.account.User;

import java.util.List;

public class CreateChatModel implements CreateChatContract.Model {

    User currentUser;
    List<User> friends;

    public CreateChatModel(User currentUser) {
        this.currentUser = currentUser;
    }

    @Override
    public void fetchFriends() {

    }

    @Override
    public void sendChat() {

    }

    @Override
    public List<User> getFriends() {
        return friends;
    }
}
