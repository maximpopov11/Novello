package myProject;


import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

@RestController
public class FriendsController {
    @Autowired
    FriendsInterface FIDB;
    @Autowired
    UserInterface UIDB;

    @PostMapping("/friend")
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

    @GetMapping("/friends")
    Friends returnAllFriends(@RequestBody JSONObject jsonObject)
    {
        Friends f = new Friends();
        //f = FIDB.get((Integer) jsonObject.getAsNumber("userId"));
         //f = FIDB.findById((Integer) jsonObject.getAsNumber("userId")).orElseThrow(NoSuchElementException::new);
//        Set<Friends> friends = f.friendshipStatus();
//
//        Set<Friends> friendsSet = new HashSet<>();
//
//        Iterator<Friends> friendsIterator = friendsSet.iterator();
//
//        Friends friends1;
//
//        int c;
//        while (friendsIterator.hasNext()) {
//            friends1 = friendsIterator.next();
//            c = friends1.getFriendshipStatus();
//            if (c == FriendshipStatus) {
//                librarySet.add(friends1);
//            }
//        }
//        return librarySet;

        return f;
    }
}
