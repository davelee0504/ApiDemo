package com.api.dao;

import com.api.model.User;

public interface UserDao {
	User getUser(String account);
}
