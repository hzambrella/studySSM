package TestStartSSM;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

import startSSM.DAO.UserDAO;
import startSSM.Model.User;

@RunWith(SpringJUnit4ClassRunner.class)
//"classpath*:startSSM-servlet.xml" 加个*，免得找不到classpath
@ContextConfiguration(locations = {"classpath:applicationContext.xml"}) 
public class TestUserDAO {
	@Autowired
	UserDAO userDao;
	
	//@Test
	public void testInsertUser(){
		User user=new User("哈哈", 1, 23, "1231313", "哈德發賀卡上");
		System.out.println(userDao.insertUser(user));
	}
	@Test
	public void testGetUser(){
		User user=new User();
		user.setName("wang");
		List<User> result=userDao.getUser(user);
		System.out.println(JSON.toJSONString(result));
	}
}
