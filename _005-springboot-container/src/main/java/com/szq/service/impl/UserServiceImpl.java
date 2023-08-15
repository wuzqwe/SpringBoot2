package com.szq.service.impl;

import com.szq.service.UserService;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Override
    public void sayHello(String name) {
        System.out.println("执行业务方法的sayHello:"+name);
    }
}
