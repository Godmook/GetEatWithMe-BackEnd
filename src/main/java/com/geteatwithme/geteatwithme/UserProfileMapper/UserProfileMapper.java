package com.geteatwithme.geteatwithme.UserProfileMapper;

import com.geteatwithme.geteatwithme.model.Post;
import com.geteatwithme.geteatwithme.model.UserProfile;
import org.apache.ibatis.annotations.*;

import java.util.LinkedList;
import java.util.List;

@Mapper
public interface UserProfileMapper {
    @Select("SELECT * FROM userprofile WHERE id=#{id}")
    UserProfile getUserProfile(@Param("id") String id);

    @Select("SELECT * FROM userprofile")
    List<UserProfile> getUserProfileList();

    @Insert("INSERT INTO userprofile VALUES(#{id}, #{name}, #{gender}, PASSWORD(#{password}), #{age}, #{nickname}, #{grade})")
    int insertUserProfile(@Param("id") String id, @Param("name") String name, @Param("gender") int gender,@Param("password") String password, @Param("age") int age, @Param("nickname") String nickname, Double grade);

    @Update("UPDATE userprofile SET name=#{name}, gender=#{gender}, password=PASSWORD(#{password}), age=#{age}, nickname=#{nickname} WHERE id= #{id}")
    int updateUserProfile(@Param("id") String id, @Param("name") String name, @Param("gender") int gender,@Param("password") String password, @Param("age") int age, @Param("nickname") String nickname);

    @Delete("DELETE FROM userprofile WHERE id=#{id}")
    int deleteUserProfile(@Param("id") String id);

    @Select("SELECT COUNT(*) FROM userprofile WHERE id=#{id}")
    int checkUsername(@Param("id") String id);

    @Select("SELECT COUNT(*) FROM userprofile WHERE nickname=#{nickname}")
    int checkUserNickname(@Param("nickname") String nickname);
    @Select("SELECT COUNT(*) FROM userprofile WHERE id=#{id} AND password=PASSWORD(#{password})")
    int checkLogin(@Param("id")String id, @Param("password")String password);
    @Select("SELECT * FROM post JOIN userprofile WHERE post.id=#{id} AND userprofile.id=post.id")
    LinkedList<Post> GetUserIdPost(@Param("id")String id);
    //수정 필요
    @Insert("INSERT INTO post VALUES(#{id}, #{restaurant},#{meeting_place},#{category},#{max_people}, #{cur_people}, #{meeting_date}, #{meeting_time}, #{contents}, #{Longtitude}, #{Latitude},(SELECT COUNT(*) FROM post ALIAS_FOR_SUBQUERY JOIN userprofile WHERE post.id=userprofile.id), #{meet_x},#{meet_y},#{restaurant_id},#{visible})")
    int insertUserPost(@Param("id")String id, @Param("restaurant")String restaurant, @Param("meeting_place")String meeting_place,@Param("category")int category, @Param("max_people")int max_people, @Param("cur_people")int cur_people, @Param("meeting_date")String meeting_date, @Param("meeting_time")String meeting_time, @Param("contents")String contents, @Param("Longtitude")Double Longtitude, @Param("Latitude")Double Latitude,@Param("meet_x")Double meet_x,@Param("meet_y")Double meet_y,@Param("restaurant_id")int restaurant_id,@Param("visible")int visible);

    @Select("SELECT * FROM post JOIN userprofile WHERE userprofile.id=post.id")
    LinkedList<Post> GetAllPost();

    @Select("SELECT * FROM post JOIN userprofile WHERE category=#{category} AND userprofile.id=post.id")
    LinkedList<Post>GetCategoryPost(@Param("category")int category);
    @Select("SELECT * FROM post JOIN userprofile WHERE userprofile.id=post.id AND restaurant LIKE CONCAT('%',#{name},'%')")
    LinkedList<Post>GetSearchingPost(@Param("name")String name);
    @Select("SELECT * FROM post JOIN userprofile WHERE userprofile.id=post.id AND post_id=#{id}")
    Post GetPost_idPost(@Param("id")String id);
}

