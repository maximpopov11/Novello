package com.yn_1.novello_app.chat;

import android.graphics.Bitmap;
import android.util.Log;

import com.android.volley.VolleyError;
import com.yn_1.novello_app.account.AdultUser;
import com.yn_1.novello_app.account.User;
import com.yn_1.novello_app.volley_requests.ImageRequester;
import com.yn_1.novello_app.volley_requests.JsonArrayRequester;
import com.yn_1.novello_app.volley_requests.VolleyCommand;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ChatModel implements ChatContract.Model {

    private User currentUser;

    private List<Chat> privateChats;
    private List<Chat> publicChats;

    public ChatModel(User user) {
        currentUser = user;
    }

    @Override
    public void fetchChats(ChatType chatType) {
        JsonArrayRequester req = new JsonArrayRequester();
        String urlPath = "chat/" + currentUser.getUserId() + "/" + chatType.toString();
        req.getRequest(urlPath, null, new VolleyCommand<JSONArray>() {
            @Override
            public void execute(JSONArray data) {
                for (int i = 0; i < data.length(); i++) {
                    try {
                        JSONObject chatObject = data.getJSONObject(i);
                        int chatId = chatObject.getInt("id");

                        JSONArray userArray = chatObject.getJSONArray("users");
                        List<User> users = new ArrayList();
                        for (int j = 0; j < userArray.length(); j++) {
                            JSONObject userObject = userArray.getJSONObject(j);
                            int userId = userObject.getInt("id");
                            String name = userObject.getString("name");
                            String userImageUrl = userObject.getString("image");
                            User user = new AdultUser(userId, name, userImageUrl);
                            users.add(user);
                        }
                        Chat chat = new Chat(chatId, users);

                    } catch (JSONException e) {
                        Log.d("Chat", "Unable to parse JSON of " + chatType.toString() + " chat.");
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onError(VolleyError error) {
                Log.d("Chat", "Unable to fetch " + chatType.toString() + " chat.");
            }
        }, null, null);
    }

    @Override
    public void fetchProfileImagesOfChat(Chat[] chats, ChatType chatType, int[] profileImageSize, ChatContract.VolleyListener listener) {
        for (Chat chat : chats) {
            int chatId = chat.getChatId();

            for (User user : chat.getUsers()) {
                String userProfileImageUrl = user.getProfileImageUrl();
                ImageRequester req = new ImageRequester();
                String urlPath = "chat/" + currentUser.getUserId() + "/" + chatType.toString() + chatId;
                req.getRequest(userProfileImageUrl, null, new VolleyCommand<Bitmap>() {
                    @Override
                    public void execute(Bitmap data) {
                        Bitmap image = Bitmap.createScaledBitmap(data,
                                profileImageSize[0], profileImageSize[1],
                                true);
                        listener.onImageRecieved(image);
                    }

                    @Override
                    public void onError(VolleyError error) {

                    }
                }, null, null);
            }
        }
    }

    @Override
    public User getUser() {
        return currentUser;
    }

    @Override
    public List<Chat> getPrivateChats() {
        return privateChats;
    }

    @Override
    public List<Chat> getPublicChats() {
        return publicChats;
    }

    @Override
    public int getPrivateChatCount() {
        return privateChats.size();
    }

    @Override
    public int getPublicChatCount() {
        return  publicChats.size();
    }

    @Override
    public int getTotalChatCount() {
        return privateChats.size() + publicChats.size();
    }
}
