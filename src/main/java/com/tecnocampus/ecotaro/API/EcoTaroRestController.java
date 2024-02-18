package com.tecnocampus.ecotaro.API;

import com.tecnocampus.ecotaro.APPLICATION.ActivityService;
import com.tecnocampus.ecotaro.APPLICATION.CommunityService;
import com.tecnocampus.ecotaro.APPLICATION.DTO.*;
import com.tecnocampus.ecotaro.APPLICATION.ServiceManagementService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EcoTaroRestController {

    private final ActivityService activityService;
    private final CommunityService communityService;
    private final ServiceManagementService serviceManagementService;


    public EcoTaroRestController(ActivityService activityService, CommunityService communityService, ServiceManagementService serviceManagementService) {

        this.activityService = activityService;
        this.communityService = communityService;
        this.serviceManagementService = serviceManagementService;
    }

    @PostMapping("/activities/users/{organizerId}/create")
    public ActivityDTO createActivity(@RequestBody ActivityDTO activitydto, @PathVariable String organizerId) {
        return activityService.createActivity(activitydto, organizerId);
    }


    @GetMapping("/activities")
    public List<ActivityDTO> getAllActivities() {
        return activityService.findAllActivities();
    }

    @PostMapping("/activities/{activityId}/users/{userId}/join")
    public ActivityDTO joinActivity(@PathVariable String activityId,  @PathVariable String userId) {
        return activityService.addParticipant(activityId, userId);
    }

    @GetMapping("/activities/{activityId}")
    public ActivityDTO getActivityDetails(@PathVariable String activityId) {
        return activityService.findActivityById(activityId);
    }

    @PostMapping("/topics")
    public TopicDTO createTopic(@RequestBody TopicDTO topicDTO) {
        return communityService.createTopic(topicDTO);
    }

    @PostMapping("/messages")
    public MessageDTO postMessage(@RequestParam String topicId,
                                  @RequestParam String content,
                                  @RequestParam String senderId) {
        return communityService.postMessage(topicId, content, senderId);
    }

    @GetMapping("/topics")
    public List<TopicDTO> getAllTopics() {
        return communityService.getAllTopics();
    }

    @GetMapping("/topics/{topicId}/message")
    public List<MessageDTO> getMessagesByTopic(@PathVariable String topicId) {
        return communityService.getMessagesByTopic(topicId);
    }

    @PostMapping("/categories")
    public CategoryDTO createCategory(@RequestBody CategoryDTO categoryDTO) {

        return serviceManagementService.createCategory(categoryDTO);
    }

    @PostMapping("/services")
    public ServiceDTO createService(@RequestBody ServiceDTO serviceDTO) {
        return serviceManagementService.createService(serviceDTO);
    }

    @GetMapping("/categories")
    public List<CategoryDTO> getAllCategories() {
        return serviceManagementService.getAllCategories();
    }

    @GetMapping("/services")
    public List<ServiceDTO> getAllServices() {
        return serviceManagementService.getAllServices();
    }

    @GetMapping("/services/byCategory/{categoryId}")
    public List<ServiceDTO> getServicesByCategory(@PathVariable String categoryId) {
        return serviceManagementService.getServicesByCategory(categoryId);
    }
}
