/**
 * (c) Copyright 2014 Total Soft Tech Solutions, Inc.
 * All rights reserved. All other trademarks and copyrights referred to herein
 * are the property of their respective holders. No part of this code may be
 * reproduced in any form or by any means or used to take any derivative work,
 * without written permission from Total Soft Tech Solutions, Inc.
 */

package com.tst.flow.service.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author Joemar S Matulac <joemar.matulac@totalsofttech.com.ph>
 *
 */
@EnableConfigurationProperties({BasicAuthSettings.class})
@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private BasicAuthSettings basicAuth;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser(basicAuth.getUsername()).password(basicAuth.getPassword()).roles("USER");
	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests().antMatchers("/**/**").hasRole("USER").anyRequest().anonymous().and().httpBasic();
	}

}
