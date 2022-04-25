package com.yn_1.novello_app.create_chat;

import com.yn_1.novello_app.account.User;

import java.util.List;

public class CreateChatPresenter implements CreateChatContract.Presenter, CreateChatContract.VolleyListener {

    CreateChatContract.Model model;
    CreateChatContract.View view;

    public CreateChatPresenter(CreateChatContract.Model model, CreateChatContract.View view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void onFragmentCreated() {

    }

    @Override
    public void onCreateChatButtonPressed() {

    }

    @Override
    public void onFriendFetched(List<User> friends) {

    }
}
