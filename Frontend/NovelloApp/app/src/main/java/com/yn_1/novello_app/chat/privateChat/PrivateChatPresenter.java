package com.yn_1.novello_app.chat.privateChat;

public class PrivateChatPresenter implements PrivateChatContract.Presenter, PrivateChatContract.VolleyListener {

    PrivateChatContract.Model model;
    PrivateChatContract.View view;

    public PrivateChatPresenter(PrivateChatContract.Model model, PrivateChatContract.View view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void onFragmentCreated() {
        model.fetchProfileImagesOfChat(this);
    }

    @Override
    public void onAllProfileImagesFetched() {
        view.displayChatList(model.getChats(), model.getUserProfileImages());
    }
}
