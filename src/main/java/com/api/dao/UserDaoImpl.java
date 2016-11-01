package com.api.dao;

import org.springframework.stereotype.Repository;
import org.sql2o.Connection;

import com.api.model.User;

@Repository
public class UserDaoImpl extends ApiDemoDao implements UserDao {

	@Override
	public User getUser(String account) {
		String sql = "SELECT * FROM User WHERE user_account = :account";
		try (Connection con = sqlDao.open()) {
			return con.createQuery(sql).addParameter("account", account)
					.addColumnMapping("user_account", "userAccount")
					.addColumnMapping("user_password", "userPassword")
					.addColumnMapping("user_description", "userDescription")
					.addColumnMapping("user_name", "userName")
					.executeAndFetchFirst(User.class);
		}
	}

}
