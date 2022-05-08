package com.geteatwithme.geteatwithme.controller;
import com.geteatwithme.geteatwithme.UserProfileMapper.UserProfileMapper;
import com.geteatwithme.geteatwithme.model.UserProfile;
import org.springframework.web.bind.annotation.*;
import javax.annotation.PostConstruct;
import java.util.List;

@RestController
public class UserProfileController {
    private UserProfileMapper mapper;

    public UserProfileController(UserProfileMapper mapper) {
        this.mapper = mapper;
    }

    @GetMapping("/user/{id}")
    public UserProfile getUserProfile(@PathVariable("id") String id) {
        return mapper.getUserProfile(id);
    }

    @GetMapping("/user/all")
    public List<UserProfile> getUserProfileList() {
        return mapper.getUserProfileList();
    }

    @PutMapping("/user/{id}")
    public void putUserProfile(@PathVariable("id") String id, @RequestParam("name") String name, @RequestParam("gender") int gender, @RequestParam("password") String password,@RequestParam("age") int age , @RequestParam("nickname") String nickname) {
        mapper.insertUserProfile(id, name, gender, password, age, nickname);
    }

    @PostMapping("/user/{id}")
    public void postUserProfile(@PathVariable("id") String id, @RequestParam("name") String name, @RequestParam("gender") int gender, @RequestParam("password") String password,@RequestParam("age") int age , @RequestParam("nickname") String nickname) {
        mapper.updateUserProfile(id, name, gender, password, age, nickname);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUserProfile(@PathVariable("id") String id) {
        mapper.deleteUserProfile(id);
    }
}
