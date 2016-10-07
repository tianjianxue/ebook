package com.hexian.web.service;

import com.hzit.entity.User;

import java.util.List;

/**
 * Created by Administrator on 2016/10/6.
 */
public interface UserServices {
    /**
     *
     * @param username
     * @param password
     * @return
     */
    public User findone(String username, String password);

    /**
     *
     * @param user
     * @return
     */
    public int insert(User user);
}
