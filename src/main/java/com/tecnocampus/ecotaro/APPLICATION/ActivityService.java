package com.tecnocampus.ecotaro.APPLICATION;

import com.tecnocampus.ecotaro.APPLICATION.DTO.ActivityDTO;
import com.tecnocampus.ecotaro.DOMAIN.Activity;
import com.tecnocampus.ecotaro.DOMAIN.Users;
import com.tecnocampus.ecotaro.PERSISTANCE.ActivityRepository;
import com.tecnocampus.ecotaro.PERSISTANCE.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActivityService {
    private final ActivityRepository activityRepository;
    private final UserRepository userRepository;

    public ActivityService(ActivityRepository activityRepository, UserRepository userRepository) {
        this.activityRepository = activityRepository;
        this.userRepository = userRepository;
    }

    public ActivityDTO createActivity(ActivityDTO activityDTO, String organizerId) {

        Users organizer = userRepository.findById(organizerId)
                .orElseThrow(() -> new RuntimeException("Organizer not found"));
        Activity activity = new Activity(activityDTO,organizer);
        Activity savedActivity = activityRepository.save(activity);
        return new ActivityDTO(savedActivity);
    }


    @Transactional
    public ActivityDTO addParticipant(String activityId, String userId) {
        Activity activity = activityRepository.findById(activityId)
                .orElseThrow(() -> new RuntimeException("Activity not found"));
        Users user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        activity.addParticipant(user);
        activityRepository.save(activity);
        return new ActivityDTO(activity);
    }

    public List<ActivityDTO> findAllActivities() {
        List<Activity> activities = activityRepository.findAll();
        return activities.stream().map(ActivityDTO::new).collect(Collectors.toList());
    }

    public ActivityDTO findActivityById(String activityId) {
        Activity activity = activityRepository.findById(activityId)
                .orElseThrow(() -> new RuntimeException("Activity not found with ID: " + activityId));

        return new ActivityDTO(activity);
    }
}