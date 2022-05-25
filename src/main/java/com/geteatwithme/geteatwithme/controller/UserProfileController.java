package com.geteatwithme.geteatwithme.controller;
import com.geteatwithme.geteatwithme.UserProfileMapper.UserProfileMapper;
import com.geteatwithme.geteatwithme.model.Alarm;
import com.geteatwithme.geteatwithme.model.Post;
import com.geteatwithme.geteatwithme.model.UserProfile;
import org.springframework.web.bind.annotation.*;
import retrofit2.http.Path;

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
    public int putUserProfile(@PathVariable("id") String id, @RequestParam("name") String name, @RequestParam("gender") int gender, @RequestParam("password") String password,@RequestParam("age") int age , @RequestParam("nickname") String nickname,@RequestParam("token_id")String token_id) {
        mapper.insertUserProfile(id, name, gender, password, age, nickname,token_id);
        return 1;
    }
    @PostMapping("/update/user/withoutpw/{id}")
    public int updateUserProfiileWithoutPw(@PathVariable("id")String id,@RequestParam("age")int age,@RequestParam("nickname")String nickname){return mapper.updateUserProfileWithoutPw(id,age,nickname);}
    @PostMapping("/update/user/{id}")
    public int postUserProfile(@PathVariable("id") String id,  @RequestParam("password") String password,@RequestParam("age") int age , @RequestParam("nickname") String nickname) {
        return mapper.updateUserProfile(id, password, age, nickname);
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
    public LinkedList<Post> getUserIdPostList(@PathVariable("id")String id){return mapper.GetUserIdPost(id);}
    @GetMapping("/post/all")
    public LinkedList<Post> getPostList(){return mapper.GetAllPost();}
   //수정
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
                            @RequestParam("Latitude")Double Latitude,
                            @RequestParam("meet_x")Double meet_x,
                            @RequestParam("meet_y")Double meet_y,
                            @RequestParam("restaurant_id") int restaurant_id,
                            @RequestParam("visible")int visible,
                            @RequestParam("post_visible")int post_visible,
                            @RequestParam("sec")int sec
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
                                Latitude,
                                meet_x,
                                meet_y,
                                restaurant_id,
                                visible,
                                post_visible,
                                sec
        );
    }
    @GetMapping("/post/find_by_post_id/{id}")
    public Post getPostByPost_id(@PathVariable("id")String id){return mapper.GetPost_idPost(id);}
    @GetMapping("/post/{category}/alllist")
    public LinkedList<Post>getCategoryPostList(@PathVariable("category")int category){return mapper.GetCategoryPost(category);}
    @GetMapping("/post/search/{name}")
    public LinkedList<Post>getSearchingPostList(@PathVariable("name")String name){return mapper.GetSearchingPost(name);}
    @PostMapping("/user/token/{id}/{token_id}")
    public int UpdateToken(@PathVariable("id")String id, @PathVariable("token_id")String token){return mapper.UpdateToken(id,token);}
    @PutMapping("/alarm/{id}")
    public int InsertAlarm(@PathVariable("id")String id,@RequestParam("request")int request,@RequestParam("opposite_id")String opposite_id,@RequestParam("post_id")int post_id,@RequestParam("view")int view,@RequestParam("nickname")String nickname,@RequestParam("opposite_nickname")String opposite_nickname){return mapper.InsertAlarm(id,request,opposite_id,post_id,view,nickname,opposite_nickname);}
    @GetMapping("/getalarm/{id}")
    public LinkedList<Alarm>GetUserAlarm(@PathVariable("id")String id){return mapper.GetUserAlarm(id);}
}
