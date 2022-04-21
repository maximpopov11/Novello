package myProject;


import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import myProject.chat.Message;

import javax.persistence.*;
import java.util.Set;

@Entity
@Api(value = "UserClass")
public
class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

//    @Column
//    String name;
    @ApiModelProperty(allowableValues = "1")
    @Column
    Integer accountType;

    @ApiModelProperty(allowableValues = "Kevin")
    @Column
    String username;

    @ApiModelProperty(allowableValues = "letMeIn")
    @Column
    String password;

    @ApiModelProperty(allowableValues = "Where was my mother born?")
    @Column
    String securityQuestion;

    @ApiModelProperty(allowableValues = "Alaska")
    @Column
    String securityAnswer;

//    @Column
//    String email;
//
//    @Column
//    Integer age;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    Set<BookData> BookData;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "UserInfo_id")
    private UserInfo userInfo;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
//    @JoinColumn(name = "message_id")
    Set<Message> messages;

    @JsonIgnore
    public Set<BookData> getBookData() {
        return BookData;
    }

    public void setBookData(Set<BookData> bookData) {
        BookData = bookData;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }

    public Integer getAccountType() {
        return accountType;
    }

    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
    }

//    public Integer getAge() {
//        return age;
//    }
//
//    public void setAge(Integer age) {
//        this.age = age;
//    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSecurityQuestion() {
        return securityQuestion;
    }

    public void setSecurityQuestion(String securityQuestion) {
        this.securityQuestion = securityQuestion;
    }

    public String getSecurityAnswer() {
        return securityAnswer;
    }

    public void setSecurityAnswer(String securityAnswer) {
        this.securityAnswer = securityAnswer;
    }

//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }

    public UserInfo getUserInfo(){return userInfo; }
    public void setUserInfo(UserInfo userInfo) {this.userInfo = userInfo; }

}