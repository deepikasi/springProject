package com.hcl;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface Dao {
	public void createUser(User user);

	public List<User> listUser(User user);

	public int deleteById(int id2);

	public List<User> allUser();

	public User editById(int id);

	public User updateById(int id, User user);
}
