package com.test.work.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.beans.Person;
import com.test.work.dao.UserDao;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Transactional
	public boolean insert(Person person)
	{
		return userDao.insert(person)>0;
	}
	

}
