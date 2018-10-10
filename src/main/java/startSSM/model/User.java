package startSSM.model;

import java.io.Serializable;

public class User implements Serializable{
	private int id;
	private String name;
	private String account;
	private int sex;
	private int age;
	private String tel;
	private String addr;
	private String createTime;
	private int money;
	private int cost;
	
	public static int UserNotFound=1000;
	public static int UserWrongPass=1001;

	public User() {
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public User(int id) {
		this.id = id;
	}

	/**
	 * 
	 * @param name
	 * @param sex
	 * @param age
	 * @param tel
	 * @param addr
	 */
	public User(String name, int sex, int age, String tel, String addr) {
		super();
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.tel = tel;
		this.addr = addr;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}
}
