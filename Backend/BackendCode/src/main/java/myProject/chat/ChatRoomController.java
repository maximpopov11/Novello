package myProject.chat;

import myProject.User;
import myProject.UserInterface;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;
import java.util.Set;

@RestController
public class ChatRoomController {
    @Autowired
    ChatRoomRepository cdb;
    @Autowired
    UserInterface udb;

//    @PostMapping("/chatRoom")
//    void createRoom(@RequestBody JSONObject[] json){
//        User user;
//
//        for(int i = 0; i<json.length; i++){
//            user = udb.findById((int) json[i].getAsNumber("userId")).orElseThrow(NoSuchElementException::new);
//        }
////        cdb.save(chatRoom);
//    }


//    @GetMapping("/chatRoom")
//    void getRooms(@RequestBody JSONObject json[]){
//        int user = (int) json[0].getAsNumber("userId");
//
//    }

}
