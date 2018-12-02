package auth;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.security.SecureRandom; 

@Entity // This tells Hibernate to make a table out of this class
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    
    private SecureRandom rand = new SecureRandom(); 
    private int sessionID = rand.nextInt(10000);

    private String username;
    private String displayname;

    private String profileImageURL = ""; //TODO Change to URL type
    private String email;
    private String password;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return username;
	}

	public void setName(String name) {
		this.username = name;
        this.displayname = name;
	}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
	}

    public void setPassword(String password) {
        this.password = password;
    }
}
