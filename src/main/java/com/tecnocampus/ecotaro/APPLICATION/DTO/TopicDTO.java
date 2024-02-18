package com.tecnocampus.ecotaro.APPLICATION.DTO;

import com.tecnocampus.ecotaro.DOMAIN.Message;
import com.tecnocampus.ecotaro.DOMAIN.Topic;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor
@Getter
public class TopicDTO {

    private String id;
    private String title;
    private String description;
    private Set<Message> messages;

    public TopicDTO(Topic topic) {
        this.id = topic.getId();
        this.title = topic.getTitle();
        this.description = topic.getDescription();
        this.messages = topic.getMessages();
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Set<Message> getMessages() {
        return messages;
    }
}
