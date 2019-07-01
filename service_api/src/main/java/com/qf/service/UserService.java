package com.qf.service;

import com.qf.pojo.User;

/**
 * Created by  .Life on 2019/06/29/0029 14:09
 */
public interface UserService {
    int insert(User user);
    boolean query(User user);

}
