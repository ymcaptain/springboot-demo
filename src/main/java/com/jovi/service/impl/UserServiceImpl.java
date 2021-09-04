package com.jovi.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jovi.entity.UserEntity;
import com.jovi.mapper.UserMapper;
import com.jovi.service.UserService;
import org.springframework.stereotype.Service;

/**
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {
}
