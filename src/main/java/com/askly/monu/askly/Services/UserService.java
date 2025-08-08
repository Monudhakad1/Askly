package com.askly.monu.askly.Services;

import com.askly.monu.askly.DTO.UserDto;
import com.askly.monu.askly.Repositories.TagRepo;
import com.askly.monu.askly.Repositories.UserRepo;
import com.askly.monu.askly.models.Tag;
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
    public void followTag(Long userId, Long tagId) {
        User user = userRepo.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Tag tag = tagRepo.findById(tagId).orElseThrow(() -> new RuntimeException("Tag not found"));
        user.getFollowedTags().add(tag);
        userRepo.save(user);
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