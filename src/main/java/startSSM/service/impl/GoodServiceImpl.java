package startSSM.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import startSSM.dao.GoodDAO;
import startSSM.dao.OrderDAO;
import startSSM.dao.UserDAO;
import startSSM.dto.Cart;
import startSSM.exception.DBErrException;
import startSSM.exception.UserMoneyNotEnoughException;
import startSSM.util.dto.Result;
import startSSM.model.Good;
import startSSM.model.Order;
import startSSM.model.SysMessage;
import startSSM.model.User;
import startSSM.service.IGood;

@Service("GoodService")
public class GoodServiceImpl implements IGood {
	@Autowired
	UserDAO userDAO;
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
		//List<Integer>ids=new ArrayList<>();
		
		for (Cart good:cart){
			//后端校验价格
			int priceInDB=goodDAO.getGoodPriceById(good.getGoodId());
			if (priceInDB!=good.getPrice()){
				good.setPrice(priceInDB);
			}
			Order order=new Order(orderId,userId,good);
			list.add(order);
		}
		int succNum=orderDAO.createOrder(list);
		if (succNum>0){
			Result<String>result=new Result<>(orderId);
			result.getMap().put("cart", cart);
			return result;
		}else{
			return new Result<>(Order.CreateOrderFail,false,"",null);
		}
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	// 1.检查用户余额是否充足。 2.如果充足，修改orderId的状态为已支付。3.修改用户的余额。
	// 三个操作必须是事务操作。余额不足，数据库出错，必须回滚。
	public Result<Boolean> payOrder(String orderId, int userId) throws Exception {
		Result<Boolean>result=new Result<>();
			List<Order>order=orderDAO.getOrderByOrderId(orderId);
			int sum=0;
			
			if (order.size()==0){
				return new Result<>(Order.OrderNotFound,false,Order.OrderNotFoundMess,false);
			}
			
			for (Order el:order){
				sum+=el.getPrice()*el.getNumber();
			}
			
			User user=userDAO.getUserById(userId);
			int money=user.getMoney();
			if (sum>money){
				throw User.MoneyNotEnoughException;
			}
			
			int num=orderDAO.updateOrderStatusById(orderId,Order.Payed);
			if (num>0){
				user.setMoney(money-sum);
				user.setCost(user.getCost()+sum);
			}else{
				throw new DBErrException();
			}
			
			if(userDAO.updateUser(user)>0){
				result.getMap().put("money",money);
				return result;
			}else{
				throw new DBErrException();
			}
	}
}
