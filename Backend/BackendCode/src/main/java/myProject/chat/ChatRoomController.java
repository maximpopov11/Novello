package myProject.chat;

import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatRoomController {
    @Autowired
    ChatRoomRepository cdb;

    @PostMapping("/chatRoom")
    void createRoom(@RequestBody ChatRoom chatRoom){
        cdb.save(chatRoom);
    }

}
