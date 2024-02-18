package com.tecnocampus.ecotaro.DOMAIN;

import com.tecnocampus.ecotaro.APPLICATION.DTO.ActivityDTO;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@NoArgsConstructor
@Entity(name = "activities")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String name;
    private String description;
    private LocalDateTime dateTime;
    private String location;

    @ManyToOne
    @JoinColumn(name = "organizer_id")
    private Users organizer;

    @ManyToMany
    @JoinTable(
            name = "activity_participants",
            joinColumns = @JoinColumn(name = "activity_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<Users> participants = new HashSet<>();

    public Activity(ActivityDTO activityDTO, Users organizer) {

        this.id = UUID.randomUUID().toString();
        this.name = activityDTO.getName();
        this.description = activityDTO.getDescription();
        this.dateTime = activityDTO.getDateTime();
        this.location = activityDTO.getLocation();
        this.organizer = organizer;
        this.participants = activityDTO.getParticipants();
    }

    public void addParticipant(Users participant){
        participants.add(participant);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getLocation() {
        return location;
    }

    public Users getOrganizer() {
        return organizer;
    }

    public Set<Users> getParticipants() {
        return participants;
    }
}
