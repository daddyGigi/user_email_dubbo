package com.qf.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qf.dao.UserMapper;
import com.qf.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Wrapper;

/**
 * Created by  .Life on 2019/06/29/0029 14:08
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public int insert(User user) {
        return userMapper.insert(user);
    }

    @Override
    public boolean query(User user) {
        QueryWrapper queryWrapper = new QueryWrapper(user);
        User u = userMapper.selectOne(queryWrapper);
        if (u !=null){
            return true;
        }
        return false;
    }
}
