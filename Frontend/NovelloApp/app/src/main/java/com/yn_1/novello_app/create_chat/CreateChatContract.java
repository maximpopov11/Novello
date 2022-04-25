package com.yn_1.novello_app.create_chat;

import com.yn_1.novello_app.account.User;
import com.yn_1.novello_app.chat.Chat;

import java.util.List;

public interface CreateChatContract {
    interface Model {
        void fetchFriends();
        void sendChat();
        List<User> getFriends();
    }

    interface View {
        void navigateToMessageScreen(User user, Chat chat);
    }

    interface Presenter {
        void onFragmentCreated();
        void onCreateChatButtonPressed();
    }

    interface VolleyListener {
        void onFriendFetched(List<User> friends);
    }
}
