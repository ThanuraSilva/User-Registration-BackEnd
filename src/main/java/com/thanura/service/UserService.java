package com.thanura.service;
import com.thanura.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    UserDTO saveUser(UserDTO user);
}
