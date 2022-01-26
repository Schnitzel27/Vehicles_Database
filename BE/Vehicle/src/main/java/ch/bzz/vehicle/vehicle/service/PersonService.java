package ch.bzz.vehicle.vehicle.service;

import ch.bzz.vehicle.vehicle.model.Person;
import ch.bzz.vehicle.vehicle.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<Person> getPersons() {
        return personRepository.findAll();
    }

    public Person findPersonById(Long Id) {
        return personRepository.findById(Id).orElse(null);
    }

    public boolean createPerson(Person person) {
        if (person.getAddress().isEmpty()
                || person.getHair_colour().isEmpty()
                || person.getAddress().isEmpty()
                || person.getHair_colour().isEmpty()
                || person.getId() != null
                || person.getPlace().isEmpty()
                || person.getPlz() < 1000
                || person.getPlz() > 9999
                || person.getLastname().isEmpty()
                || person.getPrename().isEmpty()
        ) {
            return false;
        } else {
            personRepository.save(person);
            return true;
        }
    }

}
