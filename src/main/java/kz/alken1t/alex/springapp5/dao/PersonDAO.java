package kz.alken1t.alex.springapp5.dao;

import kz.alken1t.alex.springapp5.repository.PersonRepository;
import kz.alken1t.alex.springapp5.models.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PersonDAO {
  //  private static int PEOPLE_COUNT;

    private final PersonRepository personRepository;



    public List<Person> index() {
        return personRepository.findAll();
    }

    public Person show(Long id) {
        return personRepository.findById(id).orElseThrow();
    }

    public void save(Person person) {
        personRepository.save(person);
    }

    public void update(Long id, Person updatePerson) {
        Person personToBeUpdate = personRepository.findById(id).orElseThrow();
        personToBeUpdate.setName(updatePerson.getName());
        personToBeUpdate.setAge(updatePerson.getAge());
        personToBeUpdate.setEmail(updatePerson.getEmail());
    }

    public void delete(Long id) {
        personRepository.deleteById(id);
    }
}