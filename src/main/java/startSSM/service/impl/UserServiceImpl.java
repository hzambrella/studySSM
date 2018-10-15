package startSSM.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import startSSM.dao.UserDAO;
import startSSM.util.dto.Result;
import startSSM.model.User;
import startSSM.service.IUser;

@Service("userService")
public class UserServiceImpl implements IUser {
	@Autowired
	UserDAO userDAO;

	@Override
	public int insertUser(User user) {
		return userDAO.insertUser(user);
	}
	
	@Override
	public User getUser(int id, String account) {
		if (id>0){
			return userDAO.getUserById(id);
		}
		
		if (account!=null){
			return userDAO.getUserByAccount(account);
		}
		
		return null;
	}

	@Override
	public Result<User> login(String account, String password) {
		User user=userDAO.getUserByAccount(account);
		if (user==null){
			Result<User> result=new Result<>(User.UserNotFound,false,User.UserNotFoundMess,null);
			return result;
		}
		
		String passToCheck=userDAO.checkPassword(account);
		if (passToCheck!=null&&passToCheck.equals(password)){
			Result<User> result=new Result<>(Result.Success,true,"",user);
			return result;
		}else{
			Result<User> result=new Result<>(User.UserWrongPass,false,User.UserWrongPassMess,null);
			return result;
		}
	}

	@Override
	public Result<User> TestTx(User user) {
		// TODO Auto-generated method stub
		return null;
	}
}
