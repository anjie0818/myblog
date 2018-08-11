package com.anjie.apply;

import com.anjie.blogserver.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplyApplicationTests {
@Autowired
	UserMapper userMapper;
	@Test
	public void contextLoads() {
		userMapper.loadUserByUsername("linghu");
	}
}
