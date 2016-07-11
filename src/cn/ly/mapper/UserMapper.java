package cn.ly.mapper;


import java.util.List;

import cn.ly.bean.User;

public interface UserMapper {
	public User findUserById(int id);
	public List<User> findUserByName(String name);
	public void insertUser(User user);
	public void deleteUser(int id);
	public void updateUser(User user);
}
