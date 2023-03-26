package com.hongda.mybatis;

import com.hongda.mybatis.mapper.UserMapper;
import com.hongda.mybatis.pojo.User;
import net.minidev.json.JSONArray;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
 class MybatisPlusTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    void selectAll() {
        List<User> userList = userMapper.selectList(null);
        System.out.println(JSONArray.toJSONString(userList));
    }
}
