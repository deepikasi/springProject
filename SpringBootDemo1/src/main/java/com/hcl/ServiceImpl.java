package com.hcl;

import java.lang.annotation.Annotation;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceImpl implements ServiceIntf {
	@Autowired
	Dao dao;

	@Transactional
	public void createUser(User user) {
		dao.createUser(user);

	}

	@Transactional
	public List<User> listUser(User user) {
		return dao.listUser(user);

	}

	@Transactional
	public int deleteById(int id2) {

		return dao.deleteById(id2);
	}

	@Transactional
	public List<User> allUser() {

		return dao.allUser();
	}

	@Transactional
	public User editById(int id) {

		return dao.editById(id);
	}

	@Transactional
	public User updateById(int id, User user) {
		
		return dao.updateById(id,user);
	}

}
