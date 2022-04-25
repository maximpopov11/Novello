package com.yn_1.novello_app.message;

import android.widget.ImageView;
import android.widget.TextView;

import org.java_websocket.handshake.ServerHandshake;

import java.util.Scanner;

public class MessagePresenter implements MessageContract.Presenter, MessageContract.WebSocketListener {

    private MessageContract.Model model;
    private MessageContract.View view;

    public MessagePresenter(MessageContract.Model model, MessageContract.View view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void onFragmentCreated() {
        model.beginWebSocket();
    }

    @Override
    public void onSendButtonClicked(String message) {
        model.sendClientMessage(message);
    }


    @Override
    public void onOpen(ServerHandshake handshake) {

    }

    @Override
    public void onMessage(String message) {
        Scanner scan = new Scanner(message);
        int userId = scan.nextInt();
        scan.nextLine();
        String username = scan.nextLine();
        String messageBody = scan.nextLine();

        // TODO: Replace placeholder arguments!
        Message messageObject = new Message(-1, null, userId, username, null, messageBody);

        model.addMessageToList(messageObject);
        view.notifyRecyclerMessageAdded(model.getMessageList().size() - 1);
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {

    }
}
