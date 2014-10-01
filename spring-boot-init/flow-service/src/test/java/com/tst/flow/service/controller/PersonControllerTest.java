/**
 * (c) Copyright 2014 Total Soft Tech Solutions, Inc.
 * All rights reserved. All other trademarks and copyrights referred to herein
 * are the property of their respective holders. No part of this code may be
 * reproduced in any form or by any means or used to take any derivative work,
 * without written permission from Total Soft Tech Solutions, Inc.
 */
package com.tst.flow.service.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.web.client.RestTemplate;

import com.tst.flow.commons.dto.PersonDto;


/**
 * @author Joemar S Matulac <joemar.matulac@totalsofttech.com.ph>
 *
 */
public class PersonControllerTest {
	private static final String URL = "http://localhost:1024/person";

	@Test
	public void getPerson(){
			PersonDto result = restTemplate("ma","mama").getForObject(URL+"/getperson", PersonDto.class);
			System.out.println("****\n" + result.getFirstName() + "\n****\n");
	}
	
	@Test
	public void getPersons(){
		List<PersonDto> result = Arrays.asList(restTemplate("ma","mama").getForObject(URL+"/findall", PersonDto[].class));
		System.out.println("****\n" + result.get(0).getFirstName() + "\n****\n\n\n");
}
	
	@Test
	public void findByLastName(){
		List<PersonDto> dtos = Arrays.asList(restTemplate("ma","mama").postForObject(URL+"/getbylastname", "lname0.8669201274551452", PersonDto[].class));
		for (PersonDto personDto : dtos) {
			System.out.println(personDto.getFirstName() + " - " + personDto.getLastName());
		}
	}
	
	@Test
	public void save(){
		PersonDto personDto2 = new PersonDto("fname" + Math.random(), "lname" + Math.random(), 21);
		PersonDto personDto = restTemplate("ma","mama").postForObject(URL+"/save", personDto2, PersonDto.class);
		System.out.println("save():  Person id: " + personDto.getId());
	}
	
	@Test
	public void findByAgeAboveTenTest(){
		List<PersonDto> result = Arrays.asList(restTemplate("ma","mama").getForObject(URL+"/findageaboveten", PersonDto[].class));
		for (PersonDto personDto : result) {
			System.out.println("Name: " + personDto.getFirstName() + " ," + personDto.getLastName() + " Age: " + personDto.getAge());
		}
	}
	
	private static RestTemplate restTemplate(final String userName, final String password) {
		RestTemplate template = new RestTemplate();
		List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
		ClientHttpRequestInterceptor header = new ClientHttpRequestInterceptor() {
			
			@Override
			public ClientHttpResponse intercept(org.springframework.http.HttpRequest request, byte[] body,
					ClientHttpRequestExecution execution) throws IOException {
					String credential = userName + ":" + password;
				    byte[] encodedAuthorisation = Base64.encode(credential.getBytes());
				    request.getHeaders().add("Authorization", "Basic " + new String(encodedAuthorisation));
		        return execution.execute(request, body);
			}
		};
		interceptors.add(header);
		template.setInterceptors(interceptors);
		return template;
	}
	
	static HttpHeaders getHeaders(String auth) {
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    byte[] encodedAuthorisation = Base64.encode(auth.getBytes());
	    headers.add("Authorization", "Basic " + new String(encodedAuthorisation));
	    return headers;
	  }
}
