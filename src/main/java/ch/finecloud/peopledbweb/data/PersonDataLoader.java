package ch.finecloud.peopledbweb.data;

import ch.finecloud.peopledbweb.biz.model.Person;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Component
public class PersonDataLoader implements ApplicationRunner {

    private PersonRepository personRepository;

    public PersonDataLoader(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (personRepository.count() == 0) {
            List<Person> people = List.of(
                    new Person(null, "Pete", "Snake", LocalDate.of(1950, 1, 8), new BigDecimal(50000)),
                    new Person(null, "Jennifer", "Smith", LocalDate.of(1960, 2, 7), new BigDecimal(60000)),
                    new Person(null, "Mark", "Jackson", LocalDate.of(1970, 3, 6), new BigDecimal(70000)),
                    new Person(null, "Vishnu", "Norris", LocalDate.of(1971, 3, 6), new BigDecimal(70000)),
                    new Person(null, "Alice", "Jane", LocalDate.of(1972, 3, 6), new BigDecimal(70000)),
                    new Person(null, "Daniel", "Norris", LocalDate.of(1980, 4, 5), new BigDecimal(80000))
            );
            personRepository.saveAll(people);
        }
    }
}
