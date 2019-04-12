package com.hcl;

import java.util.Iterator;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class DaoImpl implements Dao {
	@Autowired
	SessionFactory sessionFactory;

	public void createUser(User user) {

		sessionFactory.getCurrentSession().save(user);

	}

	public List<User> listUser(User user) {
		List<User> ls = sessionFactory.getCurrentSession().createQuery("from User").list();

		return ls;

	}

	public int deleteById(int id2) {
		return sessionFactory.getCurrentSession().createSQLQuery("delete from employee where id = ?")
				.addEntity(User.class).setParameter(0, id2).executeUpdate();

	}

	public List<User> allUser() {
		List<User> ls = sessionFactory.getCurrentSession().createQuery("from User").list();

		return ls;
	}

	public User editById(int id) {
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery("select * from employee where id=?")
				.addEntity(User.class);
		query.setParameter(0, id);
		List<User> ls = query.list();
		User user = null;
		Iterator itr = ls.iterator();
		while (itr.hasNext()) {
			user = (User) itr.next();
		}
		return user;
	}

	
	public User updateById(int id, User user) {
		
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("update employee set userName=?,phoneNo=?,city=? where id=?").addEntity(User.class);
        query.setParameter(0,user.getUserName());
        query.setParameter(1,user.getPhoneNo());
        query.setParameter(2,user.getCity());
        query.setParameter(3,id);
        
        query.executeUpdate();
		
		return null;
	}

}
