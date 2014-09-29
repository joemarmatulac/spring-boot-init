/**
 * (c) Copyright 2014 Total Soft Tech Solutions, Inc. All rights reserved. All
 * other trademarks and copyrights referred to herein are the property of their
 * respective holders. No part of this code may be reproduced in any form or by
 * any means or used to take any derivative work, without written permission
 * from Total Soft Tech Solutions, Inc.
 */
package com.tst.flow.service.businessl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.tst.flow.commons.dto.PersonDto;
import com.tst.flow.persistence.domain.Person;
import com.tst.flow.persistence.repository.PersonRepository;

/**
 * @author Joemar S Matulac <joemar.matulac@totalsofttech.com.ph>
 *
 */
@Controller
public class PersonnelBusinessLogic {

    @Autowired
    PersonRepository personR;

    public PersonnelBusinessLogic() {
    }

    public PersonDto getPersonDto() {
        Person entity = personR.findOne(1L);
        return toDto(entity);
    }

    public List<PersonDto> findByLastName(String lastName) {
        List<Person> personLst = personR.findByLastName(lastName);
        return toDtoList(personLst);
    }

    public List<PersonDto> findAll() {
        List<Person> persons = new ArrayList<>();
        for (Person person : personR.findAll()) {
            persons.add(person);
        }
        return toDtoList(persons);
    }

    /**
     * @param personLst
     * @return
     */
    private List<PersonDto> toDtoList(List<Person> personLst) {
        List<PersonDto> list = new ArrayList<>();
        if (!personLst.isEmpty()) {
            for (Person p : personLst) {
                list.add(new PersonDto(p.getId(), p.getFirstName(), p.getLastName()));
            }
        }
        return list;
    }

    private static PersonDto toDto(Person entity) {
        return new PersonDto(entity.getId(), entity.getLastName(), entity.getFirstName());
    }

    /**
     * @param person
     * @return
     */
    public PersonDto save(PersonDto person) {
        Person saved = personR.save(new Person(person.getFirstName(), person.getLastName()));
        return new PersonDto(saved.getId(), saved.getFirstName(), saved.getLastName());
    }

}
