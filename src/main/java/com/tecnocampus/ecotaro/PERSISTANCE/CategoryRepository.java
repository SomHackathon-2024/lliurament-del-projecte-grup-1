package com.tecnocampus.ecotaro.PERSISTANCE;

import com.tecnocampus.ecotaro.DOMAIN.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, String> {
}
