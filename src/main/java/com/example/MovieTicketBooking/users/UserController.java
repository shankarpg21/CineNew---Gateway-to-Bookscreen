package com.example.MovieTicketBooking.users;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/users")

public class UserController {
    
    private final UserService userService;

    public UserController(UserService userService){
        this.userService=userService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserRequestDTO user){
        userService.registerService(user);
       return ResponseEntity.ok("User registered successfully!");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User userReq){
        userService.loginService(userReq);
        return ResponseEntity.ok("Login successfully");
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getUsers(){
        List<UserDTO> users = userService.getUsers().stream()
                .map(user -> new UserDTO(user.getEmail())) // Convert User to UserDTO
                .collect(Collectors.toList());
        return ResponseEntity.ok(users);
    }
}
