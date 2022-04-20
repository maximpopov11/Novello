package myProject;

import io.swagger.annotations.ApiModelProperty;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Friends {
    @EmbeddedId
    FriendsKey id;

    @ManyToOne
    @MapsId("senderId")
    @JoinColumn(name = "Senderid")
    User sender;

    @ManyToOne
    @MapsId("receiverId")
    @JoinColumn(name = "Receiverid")
    User receiver;


//    @ApiModelProperty(allowableValues = "Sam")
//    @Column
//    String username;

    //1 = mutral 2 = pending
    @ApiModelProperty(allowableValues = "1-2")
    @Column
    int friendshipStatus;

//    @ApiModelProperty(allowableValues = "idnum")
//    @Column
//    int sender_Id;
//
//    @Column
//    int receiver_Id;



    public FriendsKey getId(){return id;}
    public void setId(FriendsKey id){this.id = id; }

//    public String getUsername(){return username; }
//    public void setUsername(String username){this.username = username; }

    public int getFriendshipStatus(){return friendshipStatus;}
    public void setFriendshipStatus(int friendshipStatus){this.friendshipStatus = friendshipStatus; }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;}

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;}
//    public int getReceiver_Id() {
//        return receiver_Id;
//    }
//
//    public void setReceiver_Id(int receiver_Id) {
//        this.receiver_Id = receiver_Id;
//    }
//
//    public int getSender_Id() {
//        return sender_Id;
//    }
//
//    public void setSender_Id(int sender_Id) {
//        this.sender_Id = sender_Id;
//    }
    //    public int getFriendID(){return friendId; }
//    public void setFriendId(int friendId) {
//        this.friendId = friendId;
//    }

//    @OneToOne
//    @JsonIgnore
//    private User user;
//
//
//    public Friends()
//    {
//    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Friends other = (Friends) obj;
        if (id == null) {
            return other.id == null;
        } else return id.equals(other.id);
    }
}
