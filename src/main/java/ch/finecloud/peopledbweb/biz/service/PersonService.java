package ch.finecloud.peopledbweb.biz.service;

import ch.finecloud.peopledbweb.biz.model.Person;
import ch.finecloud.peopledbweb.data.FileStorageRepository;
import ch.finecloud.peopledbweb.data.PersonRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.InputStream;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
public class PersonService {
    private final PersonRepository personRepository;
    private final FileStorageRepository storageRepository;

    public PersonService(PersonRepository personRepository, FileStorageRepository storageRepository) {
        this.personRepository = personRepository;
        this.storageRepository = storageRepository;
    }

    @Transactional
    public Person save(Person person, InputStream photoStream) {
        Person savedPerson = personRepository.save(person);
        storageRepository.save(person.getPhotoFilename(), photoStream);
        return savedPerson;
    }

    public Optional<Person> findById(Long aLong) {
        return personRepository.findById(aLong);
    }

    public Iterable<Person> findAll() {
        return personRepository.findAll();
    }

    public void deleteAllById(Iterable<Long> ids) {
        Iterable<Person> peopleToDelete = personRepository.findAllById(ids);
        Stream<Person> peopleStream = StreamSupport.stream(peopleToDelete.spliterator(), false);
        Set<String> filenames = peopleStream
                .map(Person::getPhotoFilename)
                .collect(Collectors.toSet());
        personRepository.deleteAllById(ids);
        storageRepository.deleteAllByName(filenames);
    }
}
