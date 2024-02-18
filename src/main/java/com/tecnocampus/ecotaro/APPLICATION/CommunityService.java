package com.tecnocampus.ecotaro.APPLICATION;

import com.tecnocampus.ecotaro.APPLICATION.DTO.MessageDTO;
import com.tecnocampus.ecotaro.APPLICATION.DTO.TopicDTO;
import com.tecnocampus.ecotaro.DOMAIN.Message;
import com.tecnocampus.ecotaro.DOMAIN.Topic;
import com.tecnocampus.ecotaro.DOMAIN.Users;
import com.tecnocampus.ecotaro.PERSISTANCE.MessageRepository;
import com.tecnocampus.ecotaro.PERSISTANCE.TopicRepository;
import com.tecnocampus.ecotaro.PERSISTANCE.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommunityService {
    private final TopicRepository topicRepository;
    private final MessageRepository messageRepository;
    private final UserRepository userRepository;

    public CommunityService(TopicRepository topicRepository, MessageRepository messageRepository, UserRepository userRepository) {
        this.topicRepository = topicRepository;
        this.messageRepository = messageRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public TopicDTO createTopic(TopicDTO topicDTO) {
        Topic topic = new Topic(topicDTO);
        topicRepository.save(topic);
        return new TopicDTO(topic);
    }

    @Transactional
    public MessageDTO postMessage(String topicId, String content, String senderId) {
        Topic topic = topicRepository.findById(topicId).orElseThrow(() -> new RuntimeException("Topic not found"));
        Users sender = userRepository.findById(senderId).orElseThrow(() -> new RuntimeException("User not found"));
        Message message = new Message(content);
        messageRepository.save(message);
        return new MessageDTO(message,sender,topic);
    }

    public List<TopicDTO> getAllTopics() {
        List<Topic> topics = topicRepository.findAll();
        return topics.stream().map(TopicDTO::new).collect(Collectors.toList());
    }

    public List<MessageDTO> getMessagesByTopic(String topicId) {
        List<Message> messages = messageRepository.findByTopicId(topicId);
        return messages.stream().map(MessageDTO::new).collect(Collectors.toList());
    }
}