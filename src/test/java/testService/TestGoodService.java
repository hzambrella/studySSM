package testService;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import startSSM.dao.UserDAO;
import startSSM.dto.Cart;
import startSSM.model.User;
import startSSM.service.IGood;
import startSSM.util.dto.Result;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:spring/applicationContext_test.xml",
		"classpath:spring/spring-mybatis.xml","classpath:spring/spring-aop.xml" })
public class TestGoodService {
	@Resource(name="GoodService")
	IGood goodService;
	
	@Autowired
	UserDAO userDao;
	
	
	//@Test
	public void testBuy() throws Exception{
		int testMoney=600000;
		int testCost=3000;
		int userId=1;
		User testUser=new User();
		testUser.setId(userId);
		testUser.setMoney(testMoney);
		testUser.setCost(testCost);
		userDao.updateUser(testUser);

		Cart[] cart={new Cart(10000,1,38000),new Cart(10002,3,7500),new Cart(10001,2,5000)};
		Result<String>result=goodService.createOrder(userId, cart);
		Cart[]cart2=(Cart[]) result.getMap().get("cart");
		Assert.assertEquals(cart2[0].getPrice(), 380000);
		String orderId=result.getObj();
		Result<Boolean>result2=goodService.payOrder(orderId, userId);
		System.out.println(result2.message);
		Assert.assertTrue(result2.success);
		User user=userDao.getUserById(userId);
		int sum=0;
		for (Cart c:cart2){
			sum+=c.getPrice()*c.getNumber();
		}
		Assert.assertEquals(testMoney-sum, user.getMoney());
		Assert.assertEquals(testUser.getCost()+sum, user.getCost());
	}
}
