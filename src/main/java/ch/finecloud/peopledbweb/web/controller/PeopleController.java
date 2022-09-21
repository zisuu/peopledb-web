package ch.finecloud.peopledbweb.web.controller;

import ch.finecloud.peopledbweb.biz.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/people")
public class PeopleController {

    @GetMapping
    public String getPeople(Model model) {
        List<Person> people = List.of(
                new Person(10l, "Jake", "Snake", LocalDate.of(1950, 1, 8), new BigDecimal(50000)),
                new Person(20l, "Sara", "Smith", LocalDate.of(1960, 2, 7), new BigDecimal(60000)),
                new Person(30l, "Johnny", "Jackson", LocalDate.of(1970, 3, 6), new BigDecimal(70000)),
                new Person(31l, "Jerry", "Norris", LocalDate.of(1971, 3, 6), new BigDecimal(70000)),
                new Person(32l, "Smith", "Jane", LocalDate.of(1972, 3, 6), new BigDecimal(70000)),
                new Person(40l, "Bonny", "Norris", LocalDate.of(1980, 4, 5), new BigDecimal(80000))
        );
        model.addAttribute("people", people);
        return "people";
    }
}
