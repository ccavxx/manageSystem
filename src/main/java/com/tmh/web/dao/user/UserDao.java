package com.tmh.web.dao.user;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.tmh.web.dao.base.BaseDao;
import com.tmh.web.domain.User;

public interface UserDao extends BaseDao{

	@Insert("insert into user(username,password,salt,status) value(" +
			"#{username},#{password},#{salt},#{status})")
	void create(User user);

	@Select("select * from user")
	List<User> findAll();

	@Update("update user set password=${password},salt=${salt},status=#{status} where id=${id}")
	void update(User user);
	
	@Select("select * from user where id=#{id}")
	User findById(Integer id);

	@Update("update user set status = 2 where id=#{id}")
	Integer deleteById(Integer id);
	
	@Select("select * from user where username=#{username}")
	User findByUsername(String username);

}
