package com.api.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.sql2o.Sql2o;

import com.api.config.PropertyConfig;

public abstract class ApiDemoDao {

	@Autowired
	PropertyConfig config;

	protected static Sql2o sqlDao;

	@Autowired
	public void init() {
		sqlDao = new Sql2o(config.getDataSourceUrl(),
				config.getDataSourceUserName(),
				config.getDataSourceUserPassword());
	}
}
