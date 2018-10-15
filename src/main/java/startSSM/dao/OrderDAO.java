package startSSM.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import startSSM.model.Order;

public interface OrderDAO {
	public int createOrder(List<Order>order);
	public List<Order> getOrderByOrderId(String orderId);
	public int updateOrderStatusById(@Param("orderId")String orderId,@Param("status")int status);
}
