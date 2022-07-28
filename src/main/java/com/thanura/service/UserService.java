package com.thanura.service;
import com.thanura.entnites.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User saveUser(User user);
}
