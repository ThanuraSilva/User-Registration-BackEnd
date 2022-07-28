package com.thanura;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class AppInitializer {
    public static void main(String[] args) {
        SpringApplication.run(AppInitializer.class, args);
    }
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
//    @Bean
//    CommandLineRunner run (UserService userService){
//        return args -> {
//            userService.addStateToUser("thanura","USER");
//            userService.addStateToUser("gamini","ADMIN");
//            userService.addStateToUser("chandrani","ADMIN");
//        };
//    }

}
