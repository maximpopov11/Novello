package com.yn_1.novello_app.chat.privateChat;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yn_1.novello_app.R;
import com.yn_1.novello_app.chat.Chat;
import com.yn_1.novello_app.message.Message;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 */
public class PrivateChatFragment extends Fragment implements PrivateChatContract.View {

    private static final String ARG_PRIVATE_CHATS = "private-chats";
    private List<Chat> privateChats;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public PrivateChatFragment() {
    }

    public static PrivateChatFragment newInstance(List<Chat> privateChats) {
        PrivateChatFragment fragment = new PrivateChatFragment();
        Bundle args = new Bundle();
        args.putParcelableArrayList(ARG_PRIVATE_CHATS, (ArrayList<? extends Parcelable>) privateChats);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            privateChats = getArguments().getParcelableArrayList(ARG_PRIVATE_CHATS);
            PrivateChatContract.Presenter presenter = new PrivateChatPresenter(
                    new PrivateChatModel(privateChats), this);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_private_chat_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            recyclerView.setAdapter(new PrivateChatRecyclerViewAdapter(PrivateChatContent.ITEMS));
        }
        return view;
    }
}