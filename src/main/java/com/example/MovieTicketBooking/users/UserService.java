package com.example.MovieTicketBooking.users;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;


@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }


    public void registerService(UserRequestDTO userRequestDTO){
        Optional<User> opt=userRepository.findByEmail(userRequestDTO.getEmail());
		if(opt.isPresent()){
			throw new IllegalStateException("email already exits");
		}
        User newUser = new User();
        newUser.setEmail(userRequestDTO.getEmail());
        newUser.setPassword(userRequestDTO.getPassword()); // Hash password
        userRepository.save(newUser);
    } 
    public void loginService(User user){
        Optional<User> opt=userRepository.findByEmail(user.getEmail());
		if(!opt.isPresent()){
			throw new IllegalStateException("email does'nt exits");
		}
        User exUser=opt.get();
        if(!exUser.getPassWord().equals(user.getPassWord())){
            throw new IllegalStateException("Invalid credentials");
        }
    } 

    public List<UserDTO> getUsers() {
        return userRepository.findAll().stream()
                .map(user -> new UserDTO(user.getEmail())) // Convert User to UserDTO
                .collect(Collectors.toList());
    }
}
