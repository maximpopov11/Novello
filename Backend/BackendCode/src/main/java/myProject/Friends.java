package myProject;

import io.swagger.annotations.ApiModelProperty;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;

@Entity
public class Friends {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(allowableValues = "100030499")
    int id;

    @ApiModelProperty(allowableValues = "Sam")
    @Column
    String username;

    //1 = mutral 2 = pending
    @ApiModelProperty(allowableValues = "1-2")
    @Column
    int friendshipStatus;

    @ApiModelProperty(allowableValues = "idnum")
    @Column
    int friendId;

    public int getId(){return id;}
    public void setId(int id){this.id = id; }

    public String getUsername(){return username; }
    public void setUsername(String username){this.username = username; }

    public int getFriendshipStatus(){return friendshipStatus;}
    public void setFriendshipStatus(int friendshipStatus){this.friendshipStatus = friendshipStatus; }

    public int getFriendID(){return friendId; }
    public void setFriendId(int friendId) {
        this.friendId = friendId;
    }

    @OneToOne
    @JsonIgnore
    private User user;


    public Friends()
    {
    }
}
