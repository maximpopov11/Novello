package myProject;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class FriendsKey implements Serializable {
    @Column(name = "Senderid")
    Integer senderId;

    @Column(name = "Receiverid")
    Integer receiverId;

}
