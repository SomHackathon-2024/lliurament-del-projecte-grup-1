package com.tecnocampus.ecotaro.APPLICATION.DTO;

import com.tecnocampus.ecotaro.DOMAIN.Message;
import com.tecnocampus.ecotaro.DOMAIN.Topic;
import com.tecnocampus.ecotaro.DOMAIN.Users;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class MessageDTO {

    private String id;
    private String content;
    private Users sender;
    private Topic topic;

    public MessageDTO(Message message, Users sender, Topic topic) {
        this.id = message.getId();
        this.content = message.getContent();
        this.sender = sender;
        this.topic = topic;
    }

    public MessageDTO(Message message){
        this.id = message.getId();
        this.content = message.getContent();
    }

    public String getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public Users getSender() {
        return sender;
    }

    public Topic getTopic() {
        return topic;
    }
}
