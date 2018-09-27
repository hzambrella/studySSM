package startSSM.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import startSSM.DAO.UserDAO;
import startSSM.Model.User;
import startSSM.Service.IUser;

@Service("userService")
public class UserServiceImpl implements IUser {
	@Autowired
	UserDAO userDAO;

	@Override
	public int insertUser(User user) {
		return userDAO.insertUser(user);
	}
}
