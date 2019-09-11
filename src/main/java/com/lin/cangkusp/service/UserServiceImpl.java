package com.lin.cangkusp.service;

import com.lin.cangkusp.common.exception.AppException;
import com.lin.cangkusp.dao.UserMapper;
import com.lin.cangkusp.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public User queryUserById(String sno){
        try {
            User user = userMapper.selectByPrimaryKey(sno);
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            throw new AppException("未找到匹配用户！",400);
        }
    }
}
