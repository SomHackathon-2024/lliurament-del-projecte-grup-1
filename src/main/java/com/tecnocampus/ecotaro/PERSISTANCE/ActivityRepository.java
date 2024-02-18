package com.tecnocampus.ecotaro.PERSISTANCE;

import com.tecnocampus.ecotaro.DOMAIN.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, String> {
}
