package lv.accenture.bootcamp.rardb4.model;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long UserID;

    @Size(min = 2, max = 256)
    private String username;


    public User(Long userID, String username) {
        super();
        UserID = userID;
        this.username = username;
    }

    public User() {
    }

    public Long getUserID() {
        return UserID;
    }

    public void setUserID(Long userID) {
        UserID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
