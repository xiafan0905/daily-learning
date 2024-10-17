package com.example.dailylearning.web.dao;

import com.example.dailylearning.web.User;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface UserDao {

    int update(User user);

    List<User> selectUser(@Param("name") String name);

    String selectName();
}
