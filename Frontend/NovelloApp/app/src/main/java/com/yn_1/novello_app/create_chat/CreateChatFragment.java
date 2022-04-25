package com.yn_1.novello_app.create_chat;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.yn_1.novello_app.NavBarActivity;
import com.yn_1.novello_app.R;
import com.yn_1.novello_app.account.User;
import com.yn_1.novello_app.chat.Chat;

/**
 * A fragment representing a list of Items.
 */
public class CreateChatFragment extends Fragment implements CreateChatContract.View {

    CreateChatContract.Presenter presenter;

    RecyclerView recyclerView;
    Button createChatButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        User user = CreateChatFragmentArgs.fromBundle(savedInstanceState).getCurrentUser();
        presenter = new CreateChatPresenter(new CreateChatModel(user), this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_friend_list, container, false);

        createChatButton = view.findViewById(R.id.createChat);
        // Set the adapter
        recyclerView = view.findViewById(R.id.friendRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new MyCreateChatRecyclerViewAdapter(PlaceholderContent.ITEMS));

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void navigateToMessageScreen(User user, Chat chat) {
        CreateChatFragmentDirections.ActionCreateChatFragmentToMessageFragment action =
                CreateChatFragmentDirections.actionCreateChatFragmentToMessageFragment(
                        user, chat);
        ((NavBarActivity) getActivity()).getController().navigate(action);
    }
}