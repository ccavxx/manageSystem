package com.tmh.test.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.tmh.test.base.AbstractTest;
import com.tmh.web.dao.user.UserDao;
import com.tmh.web.domain.User;

public class UserDaoTest extends AbstractTest{
	
	@Autowired
	private UserDao userDao;
	
	@Test
	@Rollback(false)
	public void findByUsername(){
		User user = userDao.findById(1);
		System.out.println(user.getUsername());
	}
	
}
