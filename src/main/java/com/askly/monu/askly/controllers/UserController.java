package com.askly.monu.askly.controllers;

import com.askly.monu.askly.DTO.UserDto;
import com.askly.monu.askly.Services.UserService;
import com.askly.monu.askly.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> user = userService.getUserById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping
    public User createUser(@RequestBody UserDto userDto) {
        return userService.createUser(userDto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
    @PostMapping("/{userId}/followTag/{tagId}")
    public ResponseEntity<Void> followTag(@PathVariable Long userId, @PathVariable Long tagId) {
        userService.followTag(userId, tagId);
        return ResponseEntity.noContent().build();
    }
}