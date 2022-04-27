package myProject.chat;

import myProject.User;
import myProject.UserInterface;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

@RestController
public class ChatRoomController {
    @Autowired
    ChatRoomRepository cdb;
    @Autowired
    UserInterface udb;

    @PostMapping("/chatRoom")
    void createRoom(@RequestBody JSONObject[] json){

        User user;
        ChatRoom chatRoom = new ChatRoom();
        chatRoom.setName(json[0].getAsString("name"));
        Set<User> users = new HashSet<>();

        for(int i = 1; i<json.length; i++){
            user = udb.findById(Integer.parseInt( json[i].getAsString("userId"))).orElseThrow(NoSuchElementException::new);
            user.getChatRooms().add(chatRoom);
            users.add(user);
        }
        chatRoom.setUsers(users);
        cdb.save(chatRoom);
    }
}
