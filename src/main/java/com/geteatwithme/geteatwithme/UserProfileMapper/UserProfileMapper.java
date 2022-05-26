package com.geteatwithme.geteatwithme.UserProfileMapper;

import com.geteatwithme.geteatwithme.model.Alarm;
import com.geteatwithme.geteatwithme.model.Post;
import com.geteatwithme.geteatwithme.model.UserProfile;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.LinkedList;
import java.util.List;

@Mapper
public interface UserProfileMapper {
    @Select("SELECT * FROM userprofile WHERE id=#{id}")
    UserProfile getUserProfile(@Param("id") String id);

    @Select("SELECT * FROM userprofile")
    List<UserProfile> getUserProfileList();

    @Insert("INSERT INTO userprofile VALUES(#{id}, #{name}, #{gender}, PASSWORD(#{password}), #{age}, #{nickname},36.5,#{token_id})")
    int insertUserProfile(@Param("id") String id, @Param("name") String name, @Param("gender") int gender,@Param("password") String password, @Param("age") int age, @Param("nickname") String nickname,@Param("token_id")String token_id);

    @Update("UPDATE userprofile SET password=PASSWORD(#{password}), age=#{age}, nickname=#{nickname} WHERE id= #{id}")
    int updateUserProfile(@Param("id") String id, @Param("password") String password, @Param("age") int age, @Param("nickname") String nickname);
    @Update("UPDATE userprofile SET age=#{age}, nickname=#{nickname} WHERE id= #{id}")
    int updateUserProfileWithoutPw(@Param("id")String id,@Param("age")int age,@Param("nickname")String nickname);
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
    @Insert("INSERT INTO post VALUES(#{id}, #{restaurant},#{meeting_place},#{category},#{max_people}, #{cur_people}, #{meeting_date}, #{meeting_time}, #{contents}, #{Longtitude}, #{Latitude},(SELECT MAX(post_id)+1 FROM post ALIAS_FOR_SUBQUERY JOIN userprofile WHERE post.id=userprofile.id), #{meet_x},#{meet_y},#{restaurant_id},#{visible},1,#{sec})")
    int insertUserPost(@Param("id")String id, @Param("restaurant")String restaurant, @Param("meeting_place")String meeting_place,@Param("category")int category, @Param("max_people")int max_people, @Param("cur_people")int cur_people, @Param("meeting_date")String meeting_date, @Param("meeting_time")String meeting_time, @Param("contents")String contents, @Param("Longtitude")Double Longtitude, @Param("Latitude")Double Latitude,@Param("meet_x")Double meet_x,@Param("meet_y")Double meet_y,@Param("restaurant_id")int restaurant_id,@Param("visible")int visible,@Param("sec")int sec);

    @Select("SELECT * FROM post JOIN userprofile WHERE userprofile.id=post.id")
    LinkedList<Post> GetAllPost();

    @Select("SELECT * FROM post JOIN userprofile WHERE category=#{category} AND userprofile.id=post.id")
    LinkedList<Post>GetCategoryPost(@Param("category")int category);
    @Select("SELECT * FROM post JOIN userprofile WHERE userprofile.id=post.id AND restaurant LIKE CONCAT('%',#{name},'%')")
    LinkedList<Post>GetSearchingPost(@Param("name")String name);
    @Select("SELECT * FROM post JOIN userprofile WHERE userprofile.id=post.id AND post_id=#{id}")
    Post GetPost_idPost(@Param("id")String id);
    @Update("UPDATE userprofile SET token_id=#{token_id} WHERE id=#{id}")
    int UpdateToken(@Param("id")String id,@Param("token_id")String token_id);
    @Insert("INSERT INTO useralarm VALUES(#{id},#{request},#{opposite_id},#{post_id},#{view},#{nickname},#{oppostie_nickname},(SELECT MAX(alarm_id)+1 FROM useralarm ALIAS_FOR_SUBQUERY ))")
    int InsertAlarm(@Param("id")String id, @Param("request")int request, @Param("opposite_id")String oppostie_id, @Param("post_id")int post_id,@Param("view")int view,@Param("nickname")String nickname,@Param("oppostie_nickname")String opposite_nickname);
    @Select("SELECT * FROM useralarm WHERE id=#{id}")
    LinkedList<Alarm>GetUserAlarm(@Param("id")String id);
    @Update("UPDATE useralarm SET view=1 WHERE alarm_id=#{id}")
    int UpdateView(@Param("id")int id);
}

