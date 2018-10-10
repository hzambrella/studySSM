package startSSM.service;

import java.util.List;

import startSSM.dto.Cart;
import startSSM.model.Good;
import startSSM.util.dto.Result;

public interface IGood {
	public List<Good>getGoodsByShopId(int shopId);
	public Result<String>  createOrder(int userId,Cart[]cart);
	public  Result<Boolean>  payOrder(String orderId,int userId);
}
