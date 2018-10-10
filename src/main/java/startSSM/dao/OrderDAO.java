package startSSM.dao;

import java.util.List;

import startSSM.model.Order;

public interface OrderDAO {
	public int createOrder(List<Order>order);
}
