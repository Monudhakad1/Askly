package com.askly.monu.askly.Services;

import com.askly.monu.askly.DTO.UserDto;
import com.askly.monu.askly.Repositories.TagRepo;
import com.askly.monu.askly.Repositories.UserRepo;
import com.askly.monu.askly.models.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepo userRepo;

    private TagRepo tagRepo;


    public UserService(UserRepo userRepo, TagRepo tagRepo) {
        this.userRepo = userRepo;
        this.tagRepo = tagRepo;
    }


    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepo.findById(id);
    }

    public User createUser(UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());

        return userRepo.save(user);
    }

    public void deleteUser(Long id) {
        userRepo.deleteById(id);

    }
}