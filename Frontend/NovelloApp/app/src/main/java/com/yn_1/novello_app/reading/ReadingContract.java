package com.yn_1.novello_app.reading;

import com.yn_1.novello_app.account.User;

public interface ReadingContract {
    interface Model {
        void fetchProgress(User user, int bookID, View view);
        void saveProgress(User user, int bookID, int progress);
        int getBookId();
        String getUrl();
    }
    interface View {
        int getProgress();
        double getProgressPercentage();
        void jumpToProgress(int progress);
    }
    interface Presenter {
        void onPageLoad(User user);
        void onEscape(User user);
    }
}
