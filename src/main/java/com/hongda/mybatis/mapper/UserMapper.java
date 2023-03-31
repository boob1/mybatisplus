package com.hongda.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserMapper extends BaseMapper<com.hongda.mybatis.pojo.User> {


    Map<String,Object> selectById1(Long id);
}
