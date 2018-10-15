package startSSM.model;

import java.io.Serializable;

import startSSM.dto.Cart;

@SuppressWarnings("serial")
public class Order implements Serializable{
	private String orderId;
	private int userId;
	private int goodId;
	private int number;
	private int price;
	
	public static int CreateOrderFail=2000;
	public static int OrderNotFound=2404;
	public static String OrderNotFoundMess="订单不存在";
	
	//未支付
	public static int NotPayed=0;
	//已支付
	public static int Payed=1;
	
	public int getNumber() {
		return number;
	}
	
	public Order() {
		super();
		this.status = 0;
	}
	
	public Order(String orderId,int userId,Cart cart){
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.goodId = cart.getGoodId();
		this.number = cart.getNumber();
		this.price = cart.getPrice();
		this.status = 0;
	}
	
	public Order(String orderId, int userId, int goodId, int number, int price, int status) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.goodId = goodId;
		this.number = number;
		this.price = price;
		this.status = 0;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	private String createTime;
	private String updateTime;
	private int status;
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getGoodId() {
		return goodId;
	}
	public void setGoodId(int goodId) {
		this.goodId = goodId;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}
