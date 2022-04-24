package com.yn_1.novello_app.message;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yn_1.novello_app.R;

import java.util.List;

public class MessageRecyclerViewAdapter extends RecyclerView.Adapter {

    private enum MESSAGE_TYPE {SENT, RECEIVED};

    private int currentUserId;
    private Context context;
    private List<Message> messageList;

    public MessageRecyclerViewAdapter (int currentUserId, Context context, List<Message> messageList) {
        this.currentUserId = currentUserId;
        this.context = context;
        this.messageList = messageList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;

        if (viewType == MESSAGE_TYPE.SENT.ordinal()) {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.chat_me, parent, false);
            return new SentMessageHolder(view);
        }
        else if (viewType == MESSAGE_TYPE.RECEIVED.ordinal()) {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.chat_other, parent, false);
            return new ReceivedMessageHolder(view);
        }

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Message message = (Message) messageList.get(position);

        switch (holder.getItemViewType()) {
            case 0:
                ((SentMessageHolder) holder).bind(message);
                break;
            case 1:
                ((ReceivedMessageHolder) holder).bind(message);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }

    @Override
    public int getItemViewType(int position) {
        Message message = (Message) messageList.get(position);

        if (message.getUserId() == currentUserId) {
            return MESSAGE_TYPE.SENT.ordinal();
        }
        else {
            return MESSAGE_TYPE.RECEIVED.ordinal();
        }
    }

    private class SentMessageHolder extends RecyclerView.ViewHolder {
        TextView messageText, timeText;

        SentMessageHolder(View itemView) {
            super(itemView);

            messageText = (TextView) itemView.findViewById(R.id.me_message);
            timeText = (TextView) itemView.findViewById(R.id.me_time);
        }

        void bind(Message message) {
            messageText.setText(message.getMessage());
            timeText.setText(message.getMessageDate().toString());
        }
    }

    private class ReceivedMessageHolder extends RecyclerView.ViewHolder {
        TextView messageText, timeText, nameText;
        ImageView profileImage;

        ReceivedMessageHolder(View itemView) {
            super(itemView);

            messageText = (TextView) itemView.findViewById(R.id.other_message);
            timeText = (TextView) itemView.findViewById(R.id.other_time);
            nameText = (TextView) itemView.findViewById(R.id.other_name);

            // May be incorrect, resource points to fragment_message.xml instead of chat_other.xml
            profileImage = (ImageView) itemView.findViewById(R.id.messageViewImage);
        }

        void bind(Message message) {
            messageText.setText(message.getMessage());
            timeText.setText(message.getMessageDate().toString());
            nameText.setText(message.getUserName());
            profileImage.setImageBitmap(message.getUserProfileImage());
        }
    }
}
