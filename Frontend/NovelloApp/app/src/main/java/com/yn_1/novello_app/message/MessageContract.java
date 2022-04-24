package com.yn_1.novello_app.message;

import android.widget.ImageView;
import android.widget.TextView;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

public interface MessageContract {
    interface Model {
        void setListener(WebSocketListener listener);
        void beginWebSocket();
        void sendClientMessage(String message);
    }

    interface View {
        String getInputText();
    }

    interface Presenter {
        void onFragmentCreated();
        void onSendButtonClicked(String message);
    }

    interface WebSocketListener {
        void onOpen(ServerHandshake handshake);
        void onMessage(String message);
        void onClose(int code, String reason, boolean remote);
    }
}
