package com.tecnocampus.ecotaro.API;

import com.tecnocampus.ecotaro.APPLICATION.DTO.UserDTO;
import com.tecnocampus.ecotaro.APPLICATION.EcoTaroService;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserRestController {
    private final EcoTaroService ecoTaroService;

    public UserRestController(EcoTaroService ecoTaroService) {
        this.ecoTaroService = ecoTaroService;
    }

    @PostMapping("/users")
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
        return ecoTaroService.createUser(userDTO);
    }

    @GetMapping("/users/{userId}")
    public UserDTO getUser(@PathVariable String userId){
        return ecoTaroService.getUser(userId);
    }

}
