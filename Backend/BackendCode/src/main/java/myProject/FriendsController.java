package myProject;


import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

@RestController
public class FriendsController {
    @Autowired
    FriendsInterface FIDB;
    @Autowired
    UserInterface UIDB;

    @PostMapping("/addfriend")
    Friends createFriend(@RequestBody JSONObject jsonObject){
        FriendsKey friendsKey = new FriendsKey();
        friendsKey.setSenderId((Integer) jsonObject.getAsNumber("senderId"));
        friendsKey.setReceiverId((Integer) jsonObject.getAsNumber("receiverId"));
        Friends f = new Friends();
        f.setId(friendsKey);
        User sender = UIDB.findById(friendsKey.senderId).orElseThrow(NoSuchElementException::new);
        User receiver = UIDB.findById(friendsKey.receiverId).orElseThrow(NoSuchElementException::new);

        f.setSender(sender);
        f.setReceiver(receiver);

        f.setFriendshipStatus((Integer) jsonObject.getAsNumber("friendshipStatus"));
        FIDB.save(f);
        return f;
      //  User kevin = UIDB.findById(jsonObject.getAsNumber("uid"));
    }
}
