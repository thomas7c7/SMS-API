package net.diyotech.student_management_system.service;

import net.diyotech.student_management_system.controller.PersonController;
import net.diyotech.student_management_system.entity.Person;
import net.diyotech.student_management_system.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonService.class);

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    public String save(Person person){
        LOGGER.info("Saving person::"+person);
        if (personRepository.save(person) != null){
            return "Person saved successfully!";
        }
        return "Person not saved!";
    }

    public List<Person> getAllPersons() {
        System.out.println("Getting all persons");
        return personRepository.findAll();
    }
}
