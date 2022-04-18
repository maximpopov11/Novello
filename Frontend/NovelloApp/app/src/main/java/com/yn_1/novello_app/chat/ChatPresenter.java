package com.yn_1.novello_app.chat;

import java.util.List;

public class ChatPresenter implements ChatContract.Presenter, ChatContract.VolleyListener {

    ChatContract.Model model;
    ChatContract.View view;

    public ChatPresenter(ChatContract.Model model, ChatContract.View view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void onFragmentCreated() {
        model.fetchChats(ChatContract.Model.ChatType.PRIVATE, this);
        model.fetchChats(ChatContract.Model.ChatType.PUBLIC, this);
    }

    @Override
    public List<Chat>[] transferChatsToView() {
        return new List[]{model.getPrivateChats(), model.getPublicChats()};
    }

    @Override
    public void onChatsReceived() {
        view.initializeTabListener();
    }
}
