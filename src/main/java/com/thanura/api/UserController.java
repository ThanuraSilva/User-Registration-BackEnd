package com.thanura.api;
import com.thanura.dto.UserDTO;
import com.thanura.security.JWTUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import com.thanura.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private  final JWTUtils jwtUtils;

    @GetMapping(path="/users/test")
    public String testing(){
        return "Thanura";
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path="/users/save", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO saveUser(@RequestBody UserDTO user) {
        return userService.saveUser(user);
    }

    @PostMapping(path = "/users/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> loginUser(@RequestBody UserDTO loginCredentials) {
        try {
            UserDetails userDetails = userService.loadUserByUsername(loginCredentials.getUsername());
            if (userDetails.getPassword().replace("{noop}", "").equals(loginCredentials.getPassword())){
               String jwt = jwtUtils.generateJwtToken(userDetails.getUsername());
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
//                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authentication);
                return new ResponseEntity<>(jwt, HttpStatus.OK);
            }
            return new ResponseEntity<>("Invalid login credentials", HttpStatus.UNAUTHORIZED);
        }catch (UsernameNotFoundException e){
            return new ResponseEntity<>("User does not exist", HttpStatus.UNAUTHORIZED);
        }
    }
}

