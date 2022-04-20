package myProject.chat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class ChatRoom {
    @Id
    @Column
    int id;

    @Column
    String name;

    @Column
    String description;

    @JsonIgnore
    @OneToMany(mappedBy = "chatRoom")
    @JoinColumn(name = "message_id")
    Set<Message> messages;

}
