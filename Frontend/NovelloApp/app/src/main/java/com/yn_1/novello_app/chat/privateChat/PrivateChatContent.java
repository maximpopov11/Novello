package com.yn_1.novello_app.chat.privateChat;

import com.yn_1.novello_app.account.User;
import com.yn_1.novello_app.chat.Chat;
import com.yn_1.novello_app.message.Message;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 */
public class PrivateChatContent {

    /**
     * An array of sample (placeholder) items.
     */
    public static final List<Chat> ITEMS = new ArrayList<Chat>();

    /**
     * A map of sample (placeholder) items, by ID.
     */
    public static final Map<Integer, Chat> ITEMS_MAP = new HashMap<Integer, Chat>();

    private static final int COUNT = 25;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createMessageItem(-1, null, null));
        }
    }

    private static void addItem(Chat item) {
        ITEMS.add(item);
        ITEMS_MAP.put(item.getChatId(), item);
    }

    private static Chat createMessageItem(int chatId, List<User> users, List<Message> messages) {
        return new Chat(chatId, users, messages);
    }
}
