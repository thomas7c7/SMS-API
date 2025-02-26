package net.diyotech.student_management_system.controller;

import net.diyotech.student_management_system.entity.Person;
import net.diyotech.student_management_system.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/person") //url for one to one mapping
@RequestMapping("persons") //url for one to many and many to many mapping

public class PersonController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonController.class);

    private final PersonService personService;

    public PersonController(PersonService personService){
        this.personService = personService;
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody Person person){
        LOGGER.info("Saving person::"+person);
        return ResponseEntity.status(200).body(personService.save(person));
    }

}
