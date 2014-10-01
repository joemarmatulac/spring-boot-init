/**
 * (c) Copyright 2014 Total Soft Tech Solutions, Inc.
 * All rights reserved. All other trademarks and copyrights referred to herein
 * are the property of their respective holders. No part of this code may be
 * reproduced in any form or by any means or used to take any derivative work,
 * without written permission from Total Soft Tech Solutions, Inc.
 */
package com.tst.flow.service.auth;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Joemar S Matulac <joemar.matulac@totalsofttech.com.ph>
 *
 */
@ConfigurationProperties(value="credential")
public class BasicAuthSettings {
	private String username;
	private String password;
	
	public BasicAuthSettings() {}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}

