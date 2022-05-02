package com.yn_1.novello_app.create_chat;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.yn_1.novello_app.account.User;
import com.yn_1.novello_app.databinding.FragmentFriendBinding;

import java.util.List;

public class MyCreateChatRecyclerViewAdapter extends RecyclerView.Adapter<MyCreateChatRecyclerViewAdapter.ViewHolder> {

    private final List<User> mValues;

    public MyCreateChatRecyclerViewAdapter(List<User> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentFriendBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.username.setText(mValues.get(position).getUsername());
        // TODO: Add user profile image
        holder.profileImage.setImageBitmap(null);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final CheckBox selectableCheckBox;
        public final ImageView profileImage;
        public final TextView username;
        public User mItem;

        public ViewHolder(FragmentFriendBinding binding) {
            super(binding.getRoot());
            selectableCheckBox = binding.friendCheckButton;
            profileImage = binding.friendImage;
            username = binding.friendName;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + username.getText() + "'";
        }
    }
}