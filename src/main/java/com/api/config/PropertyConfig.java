package com.api.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("application.properties")
public class PropertyConfig {

	@Value("${spring.datasource.url}")
	String dataSourceUrl;

	@Value("${spring.datasource.username}")
	String dataSourceUserName;

	@Value("${spring.datasource.password}")
	String dataSourceUserPassword;

	public String getDataSourceUrl() {
		return dataSourceUrl;
	}

	public void setDataSourceUrl(String dataSourceUrl) {
		this.dataSourceUrl = dataSourceUrl;
	}

	public String getDataSourceUserName() {
		return dataSourceUserName;
	}

	public void setDataSourceUserName(String dataSourceUserName) {
		this.dataSourceUserName = dataSourceUserName;
	}

	public String getDataSourceUserPassword() {
		return dataSourceUserPassword;
	}

	public void setDataSourceUserPassword(String dataSourceUserPassword) {
		this.dataSourceUserPassword = dataSourceUserPassword;
	}

}
