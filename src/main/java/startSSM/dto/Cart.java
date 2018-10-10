package startSSM.dto;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class Cart implements Serializable{
	private int goodId;
	private int number;
	private int price;
	public Cart(){
		
	}
	
	public Cart(int goodId,int number,int price){
		this.goodId=goodId;
		this.number=number;
		this.setPrice(price);
	}
	
	public int getGoodId() {
		return goodId;
	}
	public void setGoodId(int goodId) {
		this.goodId = goodId;
	}
	public int getNumber() {
		return number;
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
}