package com.geteatwithme.geteatwithme.controller;
import com.geteatwithme.geteatwithme.UserProfileMapper.UserProfileMapper;
import com.geteatwithme.geteatwithme.model.Post;
import com.geteatwithme.geteatwithme.model.UserProfile;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
public class UserProfileController {
    private UserProfileMapper mapper;

    public UserProfileController(UserProfileMapper mapper) {
        this.mapper = mapper;
    }
    @GetMapping("/user/idcheck/{id}")
    public int checkProfile(@PathVariable("id")String id){
        return mapper.checkUsername(id);
    }
    @GetMapping("/user/nickcheck/{nickname}")
    public int checkNick(@PathVariable("nickname")String nickname){return mapper.checkUserNickname(nickname);}
    @GetMapping("/user/{id}")
    public UserProfile getUserProfile(@PathVariable("id") String id) {
        return mapper.getUserProfile(id);
    }

    @GetMapping("/user/all")
    public List<UserProfile> getUserProfileList() {
        return mapper.getUserProfileList();
    }
    @PutMapping("/user/{id}")
    public int putUserProfile(@PathVariable("id") String id, @RequestParam("name") String name, @RequestParam("gender") int gender, @RequestParam("password") String password,@RequestParam("age") int age , @RequestParam("nickname") String nickname, @RequestParam("grade") Double grade) {
        mapper.insertUserProfile(id, name, gender, password, age, nickname,grade);
        return 1;
    }

    @PostMapping("/user/{id}")
    public void postUserProfile(@PathVariable("id") String id, @RequestParam("name") String name, @RequestParam("gender") int gender, @RequestParam("password") String password,@RequestParam("age") int age , @RequestParam("nickname") String nickname) {
        mapper.updateUserProfile(id, name, gender, password, age, nickname);
    }
    @DeleteMapping("/user/{id}")
    public void deleteUserProfile(@PathVariable("id") String id) {
        mapper.deleteUserProfile(id);
    }
    @GetMapping("/user/login/{id}/{password}")
    public int CheckLogin(@PathVariable("id")String id,@PathVariable("password")String password){
        return mapper.checkLogin(id,password);
    }
    @GetMapping("/post/{id}/all")
    public List<Post> getUserIdPostList(@PathVariable("id")String id){return mapper.GetUserIdPost(id);}
    @GetMapping("/post/all")
    public LinkedList<Post> getPostList(){return mapper.GetAllPost();}
    @PutMapping("/post/{id}")
    public int putUserPost(@PathVariable("id")String id,
                            @RequestParam("restaurant") String restaurant,
                            @RequestParam("meeting_place")String meeting_place,
                            @RequestParam("category")int category,
                            @RequestParam("max_people")int max_people,
                            @RequestParam("cur_people")int cur_people,
                            @RequestParam("meeting_date")String meeting_date,
                            @RequestParam("meeting_time")String meeting_time,
                            @RequestParam("contents")String contents,
                            @RequestParam("Longtitude")Double Longtitude,
                            @RequestParam("Latitude")Double Latitude
                            ){
        return mapper.insertUserPost(id,
                                restaurant,
                                meeting_place,
                                category,
                                max_people,
                                cur_people,
                                meeting_date,
                                meeting_time,
                                contents,
                                Longtitude,
                                Latitude);
    }
    @GetMapping("/post/{category}/alllist")
    public LinkedList<Post>getCategoryPostList(@PathVariable("category")int category){return mapper.GetCategoryPost(category);}

}
