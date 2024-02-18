package com.tecnocampus.ecotaro.PERSISTANCE;

import com.tecnocampus.ecotaro.DOMAIN.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, String> {
}
