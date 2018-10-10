package startSSM.service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import startSSM.dao.GoodDAO;
import startSSM.dao.OrderDAO;
import startSSM.dto.Cart;
import startSSM.util.dto.Result;
import startSSM.model.Good;
import startSSM.model.Order;
import startSSM.service.IGood;

@Service("GoodService")
public class GoodServiceImpl implements IGood {
	@Autowired
	GoodDAO goodDAO;
	@Autowired
	OrderDAO orderDAO;
	
	@Override
	public List<Good> getGoodsByShopId(int shopId) {
		return goodDAO.getGoodsByShopId(shopId);
	}

	@Override
	public Result<String> createOrder(int userId,Cart[] cart) {
		String orderId=UUID.randomUUID().toString().replace("-", "");
		List<Order>list=new ArrayList<>();
		
		//TODO:后端校验价格
		for (Cart good:cart){
			Order order=new Order(orderId,userId,good);
			list.add(order);
		}
		int succNum=orderDAO.createOrder(list);
		if (succNum>0){
			Result<String>result=new Result<>();
			return result;
		}else{
			return new Result<String>(Order.CreateOrderFail,false,"");
		}
	}

	@Override
	public Result<Boolean> payOrder(String orderId, int userId) {
		Result<Boolean>result=new Result<>();
		return result;
	}

}
