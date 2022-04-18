package com.yn_1.novello_app.chat.privateChat;

import com.yn_1.novello_app.chat.Chat;

import java.util.List;

public class PrivateChatModel implements PrivateChatContract.Model {

    List<Chat> chats;

    public PrivateChatModel(List<Chat> chats) {
        this.chats = chats;
    }

    public List<Chat> getChats() {
        return chats;
    }

    /**
     * private int imagesIndex;
     * public void fetchProfileImagesOfChat(Chat[] chats, ChatType chatType, int[] profileImageSize, ChatContract.VolleyListener listener) {
     *         imagesIndex = 0;
     *         for (Chat chat : chats) {
     *             int chatId = chat.getChatId();
     *
     *             for (User user : chat.getUsers()) {
     *                 String userProfileImageUrl = user.getProfileImageUrl();
     *                 ImageRequester req = new ImageRequester();
     *                 String urlPath = "chat/" + currentUser.getUserId() + "/" + chatType.toString() + chatId;
     *                 req.getRequest(userProfileImageUrl, null, new VolleyCommand<Bitmap>() {
     *                     @Override
     *                     public void execute(Bitmap data) {
     *                         Bitmap image = Bitmap.createScaledBitmap(data,
     *                                 profileImageSize[0], profileImageSize[1],
     *                                 true);
     *                         imagesIndex++;
     *                         if (imagesIndex == chats.length) {
     *                             listener.onChatsRecieved();
     *                         }
     *                     }
     *
     *                     @Override
     *                     public void onError(VolleyError error) {
     *
     *                     }
     *                 }, null, null);
     *             }
     *
     */
}
