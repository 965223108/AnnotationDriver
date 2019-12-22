package com.test.work.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.test.beans.Person;

@Repository
public class UserDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int insert(Person person)
	{
		String sqlString = "insert into tbl_user(name,age,gender,phone) values(?,?,?,?)";
		int result = jdbcTemplate.update(sqlString,person.getName(),person.getAge(),person.getGender(),person.getPhone());
		return result;
	}

}
