package com.thanura.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Repository
public class UserDTO {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String email;
    private String username;
    private String password;

}
