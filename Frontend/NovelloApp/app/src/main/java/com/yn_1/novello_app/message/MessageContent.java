package com.yn_1.novello_app.message;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 */
public class MessageContent {

    /**
     * An array of sample (placeholder) items.
     */
    public static final List<Message> ITEMS = new ArrayList<Message>();

    /**
     * A map of sample (placeholder) items, by ID.
     */
    public static final Map<Integer, Message> ITEMS_MAP = new HashMap<Integer, Message>();

    private static final int COUNT = 25;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createMessageItem(i, -1, "Test"));
        }
    }

    private static void addItem(Message item) {
        ITEMS.add(item);
        ITEMS_MAP.put(item.getMessageId(), item);
    }

    private static Message createMessageItem(int messageId, int userId, String message) {
        return new Message(messageId, userId, message);
    }
}