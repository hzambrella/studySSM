package startSSM.DAO;

import java.util.List;

import startSSM.Model.User;

public interface UserDAO {
	public int insertUser(User user);
	public List<User> getUser(User user);
}
