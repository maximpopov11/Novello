package myProject;

import javax.persistence.*;
import java.util.Set;

@Entity
class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column
    String name;

    @Column
    Integer accountType;

    @Column
    String username;

    @Column
    String password;

    @Column
    String securityQuestion;

    @Column
    String securityAnswer;

    @Column
    String email;

    @Column
    Integer age;

    @OneToMany(mappedBy = "user")
    Set<Evaluation> Evaluation;

    @OneToMany(mappedBy = "user")
    Set<Library> library;

    public Set<myProject.Evaluation> getEvaluation() {
        return Evaluation;
    }

    public void setEvaluation(Set<myProject.Evaluation> evaluation) {
        Evaluation = evaluation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAccountType() {
        return accountType;
    }

    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Library> getLibrary() {
        return library;
    }

    public void setLibrary(Set<Library> library) {
        this.library = library;
    }
}