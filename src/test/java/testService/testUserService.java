package testService;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import startSSM.util.dto.Result;
import startSSM.model.User;
import startSSM.service.IUser;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:spring/applicationContext_test.xml",
		"classpath:spring/spring-mybatis.xml" })
public class testUserService{
	@Resource(name="userService")
	IUser userService;
	
	@Test
	public void testLogin(){
		Result<User> user=userService.login("user1", "123456");
		Assert.assertNotNull(user);
		Assert.assertEquals(user.getObj().getName(), "哈哈");
		
		Result<User> user2=userService.login("user1", "1234567");
		Assert.assertNull(user2);
	}
}