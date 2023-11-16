package com.betrybe.agrix.ebytr.staff.controller;

import com.betrybe.agrix.controller.dto.PersonDto;
import com.betrybe.agrix.ebytr.staff.entity.Person;
import com.betrybe.agrix.ebytr.staff.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/** PersonController. */
@RestController
@RequestMapping("/persons")
public class PersonController {
  private final PersonService personService;

  @Autowired
  public PersonController(PersonService personService) {
    this.personService = personService;
  }

  /** Route to POST a Person. */
  @PostMapping()
  @ResponseStatus(HttpStatus.CREATED)
  public PersonDto save(@RequestBody PersonDto personDto) {
    Person newPerson = personService.create(personDto.toEntity());

    return PersonDto.fromEntity(newPerson);
  }
}
