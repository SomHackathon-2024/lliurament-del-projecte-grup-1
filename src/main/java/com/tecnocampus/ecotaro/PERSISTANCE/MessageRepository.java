package com.tecnocampus.ecotaro.PERSISTANCE;

import com.tecnocampus.ecotaro.DOMAIN.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, String> {
    List<Message> findByTopicId(String topicId);
}
