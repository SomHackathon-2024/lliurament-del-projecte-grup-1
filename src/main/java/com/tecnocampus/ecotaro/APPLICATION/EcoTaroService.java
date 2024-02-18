package com.tecnocampus.ecotaro.APPLICATION;

import com.tecnocampus.ecotaro.APPLICATION.DTO.UserDTO;
import com.tecnocampus.ecotaro.DOMAIN.Users;
import com.tecnocampus.ecotaro.PERSISTANCE.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class EcoTaroService {

    private final UserRepository userRepository;

    public EcoTaroService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO getUser(String userId){
        Users users = userRepository.findById(userId).orElseThrow();
        return new UserDTO(users);
    }

    public UserDTO createUser(UserDTO userDTO) {
        Users user = new Users(userDTO);
        userRepository.save(user);
        return userDTO;
    }
}
