package com.tecnocampus.ecotaro.APPLICATION.DTO;

import com.tecnocampus.ecotaro.DOMAIN.Users;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class UserDTO {

    private String id;
    private String name;
    private String surname;
    private String email;
    private String gender;
    private String username;

    public UserDTO(Users users) {
        this.id = users.getId();
        this.name = users.getName();
        this.surname = users.getSurname();
        this.email = users.getEmail();
        this.gender = users.getGender();
        this.username = users.getUsername();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public String getUsername() {
        return username;
    }
}