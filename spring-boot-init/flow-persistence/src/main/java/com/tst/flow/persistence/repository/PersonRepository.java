/**
 * (c) Copyright 2014 Total Soft Tech Solutions, Inc.
 * All rights reserved. All other trademarks and copyrights referred to herein
 * are the property of their respective holders. No part of this code may be
 * reproduced in any form or by any means or used to take any derivative work,
 * without written permission from Total Soft Tech Solutions, Inc.
 */
package com.tst.flow.persistence.repository;

/**
 * @author Joemar S Matulac <joemar.matulac@totalsofttech.com.ph>
 *
 */
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tst.flow.persistence.domain.Person;
public interface PersonRepository extends CrudRepository<Person, Long>{
	List<Person> findByLastName(String lastName);
	
	@Query("SELECT p FROM com.tst.flow.persistence.domain.Person p WHERE p.age > 10")
	List<Person> findByAgeAboveTen();
}
