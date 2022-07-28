package com.thanura.repository;

import com.thanura.dto.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserDTO,Integer> {
    UserDTO findByUsername(String username);
}
