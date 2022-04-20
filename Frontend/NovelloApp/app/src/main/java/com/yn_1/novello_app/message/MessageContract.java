package com.yn_1.novello_app.message;

import org.java_websocket.handshake.ServerHandshake;

public interface MessageContract {
    interface Model {
        void beginWebSocket();
    }

    interface View {

    }

    interface Presenter {

    }

    interface WebSocketListener {
        void onOpen(ServerHandshake handshake);
        void onMessage(String message);
        void onClose(int code, String reason, boolean remote);
    }
}
