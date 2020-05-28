package webapp.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

    private String id;
    private String name;
    private String password;
    private String email;
    private String phoneNumber;
    private String birthDay;


    public User(String id, String name, String password, String email, String phoneNumber, String birthDay) {
        this.id = name+birthDay;
        this.name = name;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birthDay = birthDay;
    }

    public User(){

    }
}
