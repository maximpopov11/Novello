package myProject.chat;

import lombok.Data;
import myProject.User;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "messages")
@Data
public class Message {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int chatRoom;

    @ManyToOne
    @JoinColumn(name = "message_Id")
    User user;

    @Lob
    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "sent")
    private Date sent = new Date();
	
	
	public Message() {};
	
	public Message(User user, String content) {
		this.user = user;
		this.content = content;
	}


    public int getChatRoom() {
        return chatRoom;
    }
    public void setChatRoom(int chatRoom) {
        this.chatRoom = chatRoom;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getSent() {
        return sent;
    }

    public void setSent(Date sent) {
        this.sent = sent;
    }

    
}
