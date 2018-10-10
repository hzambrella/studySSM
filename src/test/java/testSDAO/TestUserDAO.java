package testSDAO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

import startSSM.dao.UserDAO;
import startSSM.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
// "classpath*:startSSM-servlet.xml" 加个*，免得找不到classpath
@ContextConfiguration(locations = {
		"classpath:spring/applicationContext_test.xml",
		"classpath:spring/spring-mybatis.xml" })
public class TestUserDAO {
	@Autowired
	UserDAO userDao;

	// @Test
	public void testInsertUser() {
		User user = new User("哈哈", 1, 23, "1231313", "哈德發賀卡上");
		System.out.println(userDao.insertUser(user));
	}

	@Test
	public void testGetUser() {
		User user = new User();
		user.setName("wang");
		List<User> result = userDao.getUser(user);
		System.out.println(JSON.toJSONString(result));
	}

	@Test
	public void testGetUserByIds() {
		List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 6, 8, 100));
		List<User> result = userDao.getUserByIds(list);
		System.out.println(JSON.toJSONString(result));
	}

	// @Test
	public void testInsertUsers() {
		List<User> users = new ArrayList<>();
		users.add(new User("飞机", 1, 30, "1313131", "发发阿发上的"));
		users.add(new User("飞机", 1, 30, "1313131", "发发阿发上的"));
		Integer result = userDao.insertUsers(users);
		System.out.println(result);
		result = userDao.deleteUsers(0, "飞机");
		System.out.println(result);
	}

	@Test
	public void testUpdateUser() {
		User user = new User(3);
		user.setAddr("喝咖啡的话11");
		System.out.println(userDao.updateUser(user));
	}
}
