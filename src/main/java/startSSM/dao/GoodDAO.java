package startSSM.dao;

import java.util.List;

import startSSM.model.Good;
import startSSM.model.Order;

public interface GoodDAO {
	public List<Good>getGoodsByShopId(int shopId);
	
	public int getGoodPriceById(int goodId);
	// 根据id获得商品的价格，用于计算总价
	public List<Integer>getGoodsPriceByIds(List<Integer>ids);
}
