package com.tecnocampus.ecotaro.APPLICATION.DTO;

import com.tecnocampus.ecotaro.DOMAIN.Activity;
import com.tecnocampus.ecotaro.DOMAIN.Users;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@NoArgsConstructor
public class ActivityDTO {

    private String id;
    private String name;
    private String description;
    private LocalDateTime dateTime;
    private String location;
    private Users organizer;
    private Set<Users> participants;

    public ActivityDTO(Activity activity) {
        this.id = activity.getId();
        this.name = activity.getName();
        this.description = activity.getDescription();
        this.dateTime = activity.getDateTime();
        this.location = activity.getLocation();
        this.organizer = activity.getOrganizer();
        this.participants = activity.getParticipants();
    }

    public String getId() {
        return this.id;
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

    public Set<Users> getParticipants() {
        return participants;
    }
}
