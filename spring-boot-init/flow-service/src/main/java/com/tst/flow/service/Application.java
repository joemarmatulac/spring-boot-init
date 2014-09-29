/**
 * (c) Copyright 2014 Total Soft Tech Solutions, Inc.
 * All rights reserved. All other trademarks and copyrights referred to herein
 * are the property of their respective holders. No part of this code may be
 * reproduced in any form or by any means or used to take any derivative work,
 * without written permission from Total Soft Tech Solutions, Inc.
 */
package com.tst.flow.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.tst.flow.persistence.config.ConnectionSettings;

/**
 * @author Joemar S Matulac <joemar.matulac@totalsofttech.com.ph>
 *
 */
@Configuration
@ComponentScan({"com.tst.flow.persistence", "com.tst.flow.service"})
@EnableAutoConfiguration
@EnableAspectJAutoProxy
@EnableConfigurationProperties(ConnectionSettings.class)
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
