package com.yn_1.novello_app.chat;

import android.graphics.Bitmap;

public interface ChatContract {
    interface Model {
        enum ChatType {
            NULL(""),
            PUBLIC("public"),
            PRIVATE("private");

            private String string;

            ChatType(String string) {
                this.string = string;
            }

            @Override
            public String toString() {
                return string;
            }
        };

        void fetchChats(ChatType type);
        void fetchProfileImagesOfChat(Chat[] chats, int[] profileImageSize,
                                      ChatContract.VolleyListener listener);
    }
    interface View {

    }
    interface Presenter {

    }
    interface VolleyListener {
        void onImageRecieved(Bitmap image);
    }
}
