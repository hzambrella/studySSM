package testSDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

import startSSM.dao.OrderDAO;
import startSSM.model.Order;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:spring/applicationContext_test.xml",
		"classpath:spring/spring-mybatis.xml" })
public class TestOrderDAO {
	@Autowired
	private OrderDAO orderDao;
	
	@Test
	public void testUUID(){
		System.out.println(UUID.randomUUID().toString().replace("-",""));
	}
	
	public void testCreateOrder(){
		String orderId=UUID.randomUUID().toString().replace("-","");
		int goodId=10000;
		int number=1;
		List<Order>list=new ArrayList<>();
		for (int i=0;i<3;i++){
			Order order=new Order();
			order.setUserId(1);
			order.setGoodId(goodId);
			order.setNumber(number);
			order.setOrderId(orderId);
			order.setPrice(10000);
			goodId++;
			number++;
			list.add(order);
		}
		orderDao.createOrder(list);
		orderDao.updateOrderStatusById(orderId, Order.Payed);
	}
	
	@Test
	public void testGetOrder(){
		List<Order>list=orderDao.getOrderByOrderId("adsfa1231");
		System.out.println(JSON.toJSONString(list));
	}
}
