package com.tecnocampus.ecotaro.DOMAIN;

import com.tecnocampus.ecotaro.APPLICATION.DTO.ServiceDTO;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@Entity(name = "services")
public class Services {

    @Id
    @GeneratedValue
    private String id;

    private String name;
    private String description;
    private String url;

    @ManyToOne
    private Category category;

    public Services(ServiceDTO serviceDTO) {
        this.id = UUID.randomUUID().toString();
        this.name = serviceDTO.getName();
        this.description = serviceDTO.getDescription();
        this.url = serviceDTO.getUrl();
        this.category = serviceDTO.getCategory();
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

    public String getUrl() {
        return url;
    }

    public Category getCategory() {
        return category;
    }
}