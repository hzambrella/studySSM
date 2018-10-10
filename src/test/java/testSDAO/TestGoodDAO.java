package testSDAO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

import startSSM.dao.GoodDAO;
import startSSM.model.Good;
import startSSM.service.IGood;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:spring/applicationContext_test.xml",
		"classpath:spring/spring-mybatis.xml" })
public class TestGoodDAO {
	@Autowired
	private GoodDAO goodDao;
	
	@Resource(name = "GoodService")
	private IGood goodService;

	@Test
	public void testGetGoodsByShopId() {
		List<Good> goods = goodService.getGoodsByShopId(1);
		System.out.println(JSON.toJSONString(goods));
	}
	@Test
	public void testGetGoodsPriceByIds(){
		List<Integer>ids=new ArrayList<>(Arrays.asList(new Integer[]{10005,10007,10010}));
		List<Integer>prices=new ArrayList<>(Arrays.asList(new Integer[]{30000,160000,235000}));
		List<Integer>result=goodDao.getGoodsPriceByIds(ids);
		boolean condition=prices.equals(result);
		Assert.assertTrue(condition);
	}
}
