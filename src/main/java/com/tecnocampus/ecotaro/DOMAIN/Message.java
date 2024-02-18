package com.tecnocampus.ecotaro.DOMAIN;

import com.tecnocampus.ecotaro.APPLICATION.DTO.MessageDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "messages")
public class Message {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String content;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users sender;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topic_id")
    private Topic topic;

    public Message(MessageDTO messageDTO) {
        this.id = UUID.randomUUID().toString();
        this.content = messageDTO.getContent();
        this.sender = messageDTO.getSender();
        this.topic = messageDTO.getTopic();
    }

    public Message (String content){
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

}
