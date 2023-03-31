package com.hongda.mybatis;

import com.hongda.mybatis.mapper.UserMapper;
import com.hongda.mybatis.pojo.User;
import net.minidev.json.JSONArray;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
 class MybatisPlusTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    void selectAll() {
        List<User> userList = userMapper.selectList(null);
        System.out.println(JSONArray.toJSONString(userList));
    }
    @Test
    void testInsert(){
        User user = new User();
        user.setAge(33);
        user.setUserName("刘宏达3");
        user.setEmail("1102158249@qq.com");
        int result = userMapper.insert(user);
        System.out.println("result:"+result);
        System.out.println("id"+user.getId());
    }
    @Test
    void testDeleteById(){
        // DELETE FROM user WHERE id=?
        int i = userMapper.deleteById(1L);
        System.out.println(i);
    }

    @Test
    void testDeleteByMap(){
        // DELETE FROM user WHERE user_name = ?
        Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("user_name","刘宏达");
        userMapper.deleteByMap(hashMap);
    }

    @Test
    void testDeleteByIds(){
        // DELETE FROM user WHERE id IN ( ? , ? , ? )
        List<Long> longs = Arrays.asList(1L, 2L, 3L);
        int i = userMapper.deleteBatchIds(longs);
        System.out.println(i);

    }
    @Test
    void testUpdateById(){
        // UPDATE user SET user_name=?, email=? WHERE id=?
        User user = new User();
        user.setUserName("刘思念");
        user.setEmail("3245@qq.com");
        user.setId(1640493478723547138L);
        userMapper.updateById(user);
    }
    @Test
    void testSelectById(){
        //SELECT id,user_name,age,email FROM user WHERE id=?
        User user = userMapper.selectById(1640493478723547138L);
        System.out.println(user);
    }
    @Test
    void testSelectByIds(){
        // SELECT id,user_name,age,email FROM user WHERE id IN ( ? , ? )
        List<Long> ids = Arrays.asList(1640493478723547138L, 1640492914144968705L);
        List<User> users = userMapper.selectBatchIds(ids);
        System.out.println(JSONArray.toJSONString(users));

    }
    @Test
    void testSelectByMap(){
        // SELECT id,user_name,age,email FROM user WHERE user_name = ?
        Map<String, Object> map = new HashMap<>();
        map.put("user_name","刘思念");
        List<User> users = userMapper.selectByMap(map);
        System.out.println(JSONArray.toJSONString(users));
    }
    @Test
    void testSelectList(){
        // SELECT id,user_name,age,email FROM user
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }

    @Test
    void testselectById1(){
        // SELECT id,user_name,age,email FROM user
        Map<String,Object> users = userMapper.selectById1(1640493478723547138L);
        System.out.println(users);
    }


}
