package myProject.chat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import myProject.user.User;

import javax.persistence.*;
import java.util.Set;

@Entity
public class ChatRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column
    String name;

    @Column
    String description;

    @JsonIgnore
    @OneToMany(mappedBy = "chatRoom")
//    @JoinColumn(name = "message_id")
    Set<Message> messages;

    @JsonIgnore
    @ManyToMany(mappedBy = "chatRooms")
    Set<User> users;

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

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