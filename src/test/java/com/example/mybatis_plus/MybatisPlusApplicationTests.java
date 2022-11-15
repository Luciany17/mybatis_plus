package com.example.mybatis_plus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatis_plus.entity.User;
import com.example.mybatis_plus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
class MybatisPlusApplicationTests {
    @Autowired
    private UserMapper userMapper;



    //1.查询所有
    @Test
    void findAll() {
        List<User> users = userMapper.selectList(null);
        System.out.println("users = " + users);
    }

    //2.添加
    @Test
    void testAdd() {
        User user = new User();
        user.setAge(34534);
        user.setEmail("334@qq.com");
        user.setName("1006");
        int insert = userMapper.insert(user);
        System.out.println("insert = " + insert);
    }

    //3.修改
    @Test
    void testUpdate() {
        User user = new User();
        user.setName("修改后");
        user.setId(1592422212864888834L);
        int update = userMapper.updateById(user);

    }

    //4.删除
    @Test
    void testDelete() {
        int delete = userMapper.deleteById(-1761587198L);
        System.out.println("delete = " + delete);
    }

    //乐观锁测试
    @Test
    void testOptimisticLocker() {
        User user = userMapper.selectById(1592429798376873985L);
        user.setEmail("23144@66");
        int update = userMapper.updateById(user);

    }

    //批量查询
    @Test
    void selectBatchIds() {
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1166057473L, 1782595585L));
        System.out.println("users = " + users);
    }

    //批量删除
    @Test
    void deleteBatchIds() {
        int flag = userMapper.deleteBatchIds(Arrays.asList(-1627381758L, 633401345L));
        System.out.println("flag = " + flag);
    }

    //简单条件删除
    @Test
    void deleteByMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("age","33");
        int delete = userMapper.deleteByMap(map);
        System.out.println("delete = " + delete);

    }

    //复杂查询操作
    @Test
    void testSelect(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt("name","1001");
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println("users = " + users);
    }

}
