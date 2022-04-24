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

        FriendsKey oldFriend = new FriendsKey();
        oldFriend.setSenderId((Integer) jsonObject.getAsNumber("receiverId"));
        oldFriend.setReceiverId((Integer) jsonObject.getAsNumber("senderId"));
        Friends old = new Friends();
        int status = 1;
        try {
            old = FIDB.findById(oldFriend).orElseThrow(NoSuchElementException::new);


       if (old.getFriendshipStatus() == 1);
       {
           old.setFriendshipStatus(2);
           status = 2;
       }
        }catch(Exception e){}




        f.setFriendshipStatus(status);
        FIDB.save(f);
        return f;
      //  User kevin = UIDB.findById(jsonObject.getAsNumber("uid"));
    }

    @GetMapping("/friends")
    Set<Friends> returnAllFriends(@RequestBody JSONObject jsonObject)
    {
       User u = UIDB.findById((int)jsonObject.getAsNumber("id")).orElseThrow(NoSuchElementException::new);
        //Friends f = new Friends();
        Set<Friends> friendsSet = new HashSet<>();
        Set<Friends> allMutralFriends = new HashSet<>();
        friendsSet = u.getFriends();
        Iterator<Friends> friendsIterator = friendsSet.iterator();
        Friends f;
        while(friendsIterator.hasNext())
        {
            f = friendsIterator.next();
           if((u.getId() == f.getSender().id) && f.getFriendshipStatus() == 2)
           {
               allMutralFriends.add(f);
           }
        }
        return allMutralFriends;
    }
}
