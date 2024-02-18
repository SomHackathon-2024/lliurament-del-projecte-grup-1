package com.tecnocampus.ecotaro.APPLICATION.DTO;

import com.tecnocampus.ecotaro.DOMAIN.Category;
import com.tecnocampus.ecotaro.DOMAIN.Services;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ServiceDTO {

    private String id;
    private String name;
    private String description;
    private String url;
    private Category category;

    public ServiceDTO(Services services) {
        this.id = services.getId();
        this.name = services.getName();
        this.description = services.getDescription();
        this.url = services.getUrl();
        this.category = getCategory();
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
