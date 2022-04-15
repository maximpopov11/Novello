package com.yn_1.novello_app.chat.privateChat;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.yn_1.novello_app.chat.Chat;
import com.yn_1.novello_app.databinding.FragmentPrivateChatBinding;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Chat}.
 */
public class PrivateChatRecyclerViewAdapter extends RecyclerView.Adapter<PrivateChatRecyclerViewAdapter.ViewHolder> {

    private final List<Chat> mValues;

    public PrivateChatRecyclerViewAdapter(List<Chat> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(FragmentPrivateChatBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.chatImage.setImageBitmap(null);
        holder.chatName.setText("[Chat Name]");
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final ImageView chatImage;
        public final TextView chatName;
        public Chat mItem;

        public ViewHolder(FragmentPrivateChatBinding binding) {
            super(binding.getRoot());
            chatImage = binding.chatImage;
            chatName = binding.chatTitle;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + chatName + "'";
        }
    }
}