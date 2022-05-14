package com.geteatwithme.geteatwithme.UserProfileMapper;

import com.geteatwithme.geteatwithme.model.UserProfile;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserProfileMapper {
    @Select("SELECT * FROM userprofile WHERE id=#{id}")
    UserProfile getUserProfile(@Param("id") String id);

    @Select("SELECT * FROM userprofile")
    List<UserProfile> getUserProfileList();

    @Insert("INSERT INTO userprofile VALUES(#{id}, #{name}, #{gender}, PASSWORD(#{password}), #{age}, #{nickname})")
    int insertUserProfile(@Param("id") String id, @Param("name") String name, @Param("gender") int gender,@Param("password") String password, @Param("age") int age, @Param("nickname") String nickname);

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
}
