package com.yn_1.novello_app.message;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.yn_1.novello_app.R;
import com.yn_1.novello_app.account.User;
import com.yn_1.novello_app.chat.Chat;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MessageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MessageFragment extends Fragment implements MessageContract.View {

    private MessageContract.Presenter presenter;
    private MessageContract.WebSocketListener presenterListener;

    private ImageView chatImage;
    private TextView chatTitle;
    private EditText inputMessageField;
    private Button messageSendButton;


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment MessageFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MessageFragment newInstance(String param1, String param2) {
        MessageFragment fragment = new MessageFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        User currentUser = MessageFragmentArgs.fromBundle(getArguments()).getCurrentUser();
        Chat currentChat = MessageFragmentArgs.fromBundle(getArguments()).getCurrentChat();

        presenter = new MessagePresenter(
                new MessageModel(currentChat, currentUser), this);
        presenterListener = (MessageContract.WebSocketListener) presenter;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_message, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        chatImage = view.findViewById(R.id.messageViewImage);
        chatTitle = view.findViewById(R.id.messageViewTitle);
        inputMessageField = view.findViewById(R.id.messageInputField);
        messageSendButton = view.findViewById(R.id.messageSendButton);

        messageSendButton.setOnClickListener(v -> {
            presenterListener.onMessage(getInputText());
        });

        presenter.onFragmentCreated();
    }

    @Override
    public String getInputText() {
        return inputMessageField.getText().toString();
    }
}