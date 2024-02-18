package com.tecnocampus.ecotaro.PERSISTANCE;

import com.tecnocampus.ecotaro.DOMAIN.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, String> {
}
