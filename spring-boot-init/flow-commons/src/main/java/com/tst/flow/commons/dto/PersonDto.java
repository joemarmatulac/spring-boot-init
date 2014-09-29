/**
 * (c) Copyright 2014 Total Soft Tech Solutions, Inc.
 * All rights reserved. All other trademarks and copyrights referred to herein
 * are the property of their respective holders. No part of this code may be
 * reproduced in any form or by any means or used to take any derivative work,
 * without written permission from Total Soft Tech Solutions, Inc.
 */
package com.tst.flow.commons.dto;


/**
 * @author Joemar S Matulac <joemar.matulac@totalsofttech.com.ph>
 *
 */
public class PersonDto {
	private long id;
	private String firstName;
	private String lastName;

	protected PersonDto() {
	}

	public PersonDto(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public PersonDto(long id, String lastName) {
		super();
		this.id = id;
		this.lastName = lastName;
	}

	public PersonDto(long id, String fistName, String lastName) {
		this.id = id;
		this.firstName = fistName;
		this.lastName = lastName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName="
				+ lastName + "]";
	}
}
