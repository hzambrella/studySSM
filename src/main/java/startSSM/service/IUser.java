package startSSM.service;

import startSSM.util.dto.Result;
import startSSM.model.User;

public interface IUser {
	public int insertUser(User user); 
	public User getUser(int id,String account);
	public Result<User> login(String account,String password);
	
	public Result<User> TestTx(User user);
}
