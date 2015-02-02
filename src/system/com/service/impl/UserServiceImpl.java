package com.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.UserDao;
import com.service.BaseService;
import com.service.UserService;

@Service("userService")
public class UserServiceImpl extends BaseService implements UserService {
	@Resource
	private UserDao userDao;
}
