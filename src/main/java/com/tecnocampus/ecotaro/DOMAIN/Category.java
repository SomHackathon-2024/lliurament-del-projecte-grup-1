package com.tecnocampus.ecotaro.DOMAIN;

import com.tecnocampus.ecotaro.APPLICATION.DTO.CategoryDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@NoArgsConstructor
@Entity(name = "categories")
public class Category {

    @Id
    private String id;
    private String name;

    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
    @OrderColumn
    private Set<Services> services = new HashSet<>();

    public Category(CategoryDTO categoryDTO){

        this.id = UUID.randomUUID().toString();
        this.name = categoryDTO.getName();
    }

    public Category(String id, String name, Set<Services> services) {
        this.id = id;
        this.name = name;
        this.services = services;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Services> getServices() {
        return services;
    }
}