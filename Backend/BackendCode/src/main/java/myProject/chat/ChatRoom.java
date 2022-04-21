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
//    @JoinColumn(name = "message_id")
    Set<Message> messages;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Set<Message> getMessages() {
        return messages;
    }
    public void setMessages(Set<Message> messages) {
        this.messages = messages;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}