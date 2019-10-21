package com.ljy.qx.learnmybatis.mapper;

import com.ljy.qx.learnmybatis.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author : 夕
 * @date : 2019/10/21
 */
@Component
@Mapper
public interface UserMapper {

    @Insert(" insert into user(id,name,age,sex) values (#{id},#{name},#{age},#{sex})")
    int add(User user);

    @Update(" update user set id=#{id} , name=#{name},age=#{age},sex=#{sex} where id=#{id} ")
    int update(User user);

    @Delete(" delete from user where id=#{id} ")
    int deleteById(int id);

    @Select("select * from user where id=#{id}")
    @Results(id = "user" , value = {
        @Result(property = "id" ,column = "id", javaType = Integer.class),
        @Result(property = "name" ,column = "name", javaType = String.class),
        @Result(property = "age" ,column = "age", javaType = Integer.class),
        @Result(property = "sex" ,column = "sex", javaType = String.class),
    })
    User queryById(int id);

}
