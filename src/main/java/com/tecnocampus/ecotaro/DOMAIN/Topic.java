package com.tecnocampus.ecotaro.DOMAIN;

import com.tecnocampus.ecotaro.APPLICATION.DTO.TopicDTO;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.UUID;

@NoArgsConstructor
@Entity(name = "topics")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String title;
    private String description;

    @OneToMany(mappedBy = "topic", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Message> messages;

    public Topic(TopicDTO topicDTO) {

        this.id = UUID.randomUUID().toString();
        this.title = topicDTO.getTitle();
        this.description = topicDTO.getDescription();
        this.messages = null;
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
        return this.messages;
    }

    public void addMessages(Message m){
        messages.add(m);
    }
}
