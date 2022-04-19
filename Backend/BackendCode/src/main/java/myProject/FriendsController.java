package myProject;


import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FriendsController {
    @Autowired
    FriendsInterface FIDB;
    @Autowired
    UserInfoInterface UIDB;

    @PostMapping("/addfriend")
    void createFriend(@RequestBody JSONObject jsonObject){
        Friends f = new Friends();
      //  User kevin = UIDB.findById(jsonObject.getAsNumber("uid"));
    }
}
