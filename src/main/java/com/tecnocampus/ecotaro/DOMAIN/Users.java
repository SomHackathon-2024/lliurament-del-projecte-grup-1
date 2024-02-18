package com.tecnocampus.ecotaro.DOMAIN;

import com.tecnocampus.ecotaro.APPLICATION.DTO.UserDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Entity(name = "users")
public class Users {


    @jakarta.persistence.Id
    private String id;

    private String name;
    private String surname;
    private String email;
    private String gender;
    @Column(unique = true)
    private String username;

    @OneToMany(mappedBy = "organizers")
    private Set<Activity> organizedActivities = new HashSet<>();

    @ManyToMany(mappedBy = "participants")
    private Set<Activity> participatingActivities = new HashSet<>();

    public Users(UserDTO userDTO)  {
        this.id = UUID.randomUUID().toString();
        this.name = userDTO.getName();
        this.surname = userDTO.getSurname();
        this.email = userDTO.getEmail();
        this.gender = userDTO.getGender();
        this.username = userDTO.getUsername();
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

    public Set<Activity> getOrganizedActivities() {
        return organizedActivities;
    }

    public Set<Activity> getParticipatingActivities() {
        return participatingActivities;
    }
}