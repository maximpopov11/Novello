package myProject;

import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;

@Entity
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    int age;
    String name;
    String email;

    public int getId(){return id;}
    public void setId(int id){this.id = id; }

    public String getName() { return name; }
    public void setName(String name){ this.name = name; }

    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public User getUser(){
        return user;
    }

    public void setUser(User user){
        this.user = user;
    }

    @OneToOne
    @JsonIgnore
    private User user;


    public UserInfo()
    {
    }

    //	@OneToMany(mappedBy = "person")
//	private Set<BookRating> ratings;


//	@OneToMany
//	@JoinColumn(name = "bk_book_id")
/*

	public Books getBk() {
		return bk;
	}
	@ManyToOne
	@JoinColumn(name = "friends_id")
	Person friends;

	public Person getFriends() {
		return friends;
	}
	@Column
	Books library;
	@Column
	CREDIT CARD INFO

	@Column
	Friends JSON
*/
}
