package com.yn_1.novello_app.message;

import android.util.Log;

import com.yn_1.novello_app.Const;
import com.yn_1.novello_app.account.User;
import com.yn_1.novello_app.chat.Chat;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

public class MessageModel implements MessageContract.Model {

    MessageContract.WebSocketListener websocketListener;

    Chat chat;
    User currentUser;
    List<Message> messageList;

    private WebSocketClient cc;


    public MessageModel(MessageContract.WebSocketListener websocketListener,
                        Chat chat, User currentUser, List<Message> messageList) {
        this.websocketListener = websocketListener;
        this.chat = chat;
        this.currentUser = currentUser;
        this.messageList = messageList;
    }

    @Override
    public void beginWebSocket() {
        Draft[] drafts = {
                new Draft_6455()
        };

        final String url = Const.baseUrl + "websocket/" + chat.getChatId()
                + "/" + currentUser.getUserId();

        try {
            Log.d("Socket:", "Attempting connection");
            cc = new WebSocketClient(new URI(url), (Draft) drafts[0]) {
                @Override
                public void onMessage(String message) {
                    Log.d("", "run() returned: " + message);
                    websocketListener.onMessage(message);
                }

                @Override
                public void onOpen(ServerHandshake handshake) {
                    Log.d("OPEN", "run() returned: " + "is connecting");
                    websocketListener.onOpen(handshake);
                }

                @Override
                public void onClose(int code, String reason, boolean remote) {
                    Log.d("CLOSE", "onClose() returned: " + reason);
                    websocketListener.onClose(code, reason, remote);
                }

                @Override
                public void onError(Exception e) {
                    Log.d("Exception:", e.toString());
                }
            };
        } catch (URISyntaxException e) {
            Log.d("Exception:", e.getMessage().toString());
            e.printStackTrace();
        }
        cc.connect();
    }
}
