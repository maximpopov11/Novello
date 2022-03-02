package myProject;

import javax.persistence.*;

@Entity
class Person {
	
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

//	@Column
//	Books library;

//	@Column
//	CREDIT CARD INFO
//
//	@Column
//	Friends JSON


	
	public Integer getId() { return id; }

	public String getName() { return name; }

	public Integer getAccountType() { return accountType; }

	public Integer getAge() { return age; }

	public String getUsername() { return username; }

	public String getPassword() { return password; }

	public String getSecurityQuestion() { return securityQuestion; }

	public String getSecurityAnswer() { return securityAnswer; }

	public String getEmail() { return email; }



	
	
}