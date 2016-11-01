package com.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.api.dao.UserDao;
import com.api.model.User;

@Configuration
class GlobalAuthenticationConfiguration extends GlobalAuthenticationConfigurerAdapter {

	@Autowired
	UserDao userDao;

	@Override
	public void init(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService());
	}

	@Bean
	UserDetailsService userDetailsService() {
		return new UserDetailsService() {

			@Override
			public UserDetails loadUserByUsername(String userAccount)
					throws UsernameNotFoundException {

				User user = userDao.getUser(userAccount);
				if (user != null) {
					
					return new org.springframework.security.core.userdetails.User(
							user.getUserAccount(), user.getUserPassword(),
							true, true, true, true,
							AuthorityUtils.createAuthorityList("USER"));
					
				} else {

					throw new UsernameNotFoundException(
							"could not find the user '" + userAccount + "'");
				}
			}

		};
	}
}
