package com.tecnocampus.ecotaro.APPLICATION.DTO;

import com.tecnocampus.ecotaro.DOMAIN.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CategoryDTO {

    private String id;
    private String name;

    public CategoryDTO(Category category){
        this.id= category.getId();
        this.name = category.getName();
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
}

