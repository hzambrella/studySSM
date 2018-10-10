package startSSM.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import startSSM.model.User;

public interface UserDAO {
	// 插入的使用
	public int insertUser(User user);

	// choose when otherwise的使用
	public List<User> getUser(User user);

	// 使用foreach
	public List<User> getUserByIds(List<Integer> list);

	// 批量插入
	public int insertUsers(List<User> user);

	// 删除的使用
	public int deleteUsers(@Param("id") int id, @Param("name") String name);

	// update的使用
	public int updateUser(User user);
	
	//login
	public String checkPassword(String account);
	public User getUserById(int id);
	public User getUserByAccount(String account);
}
