package ch.finecloud.peopledbweb.web.controller;

import ch.finecloud.peopledbweb.biz.model.Person;
import ch.finecloud.peopledbweb.data.PersonRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private PersonRepository personRepository;

    public PeopleController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @ModelAttribute("people")
    public Iterable<Person> getPeople() {
        return personRepository.findAll();
    }
    @GetMapping
    public String showPeoplePage() {
        return "people";
    }
}
