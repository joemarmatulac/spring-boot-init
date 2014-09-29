/**
 * (c) Copyright 2014 Total Soft Tech Solutions, Inc. All rights reserved. All
 * other trademarks and copyrights referred to herein are the property of their
 * respective holders. No part of this code may be reproduced in any form or by
 * any means or used to take any derivative work, without written permission
 * from Total Soft Tech Solutions, Inc.
 */
package com.tst.flow.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tst.flow.commons.dto.PersonDto;
import com.tst.flow.service.businessl.PersonnelBusinessLogic;

/**
 * @author Joemar S Matulac <joemar.matulac@totalsofttech.com.ph>
 *
 */
@Controller
@RequestMapping("/person")
public class PersonControllerService {

    @Autowired
    PersonnelBusinessLogic logic;

    @RequestMapping(value = "/getperson", method = RequestMethod.GET)
    public @ResponseBody
    PersonDto sayHello(@RequestParam(value = "name", required = false, defaultValue = "Stranger") String name) {
        return logic.getPersonDto();
    }

    @RequestMapping(value = "/getbylastname", method = RequestMethod.POST)
    public @ResponseBody
    List<PersonDto> findByLastName(@RequestBody String lastName) {
        System.out.println("****** " + lastName + " ******");
        return logic.findByLastName(lastName);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public @ResponseBody
    PersonDto save(@RequestBody PersonDto person) {
        System.out.println("****** " + person.getLastName() + " ******");
        return logic.save(person);
    }

    @RequestMapping(value = "/findall", method = RequestMethod.GET)
    public @ResponseBody
    List<PersonDto> findAll() {
        return logic.findAll();
    }
}
