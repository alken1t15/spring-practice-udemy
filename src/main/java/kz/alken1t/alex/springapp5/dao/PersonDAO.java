package kz.alken1t.alex.springapp5.dao;

import kz.alken1t.alex.springapp5.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people = new ArrayList<>();

    {
        people.add(new Person(++PEOPLE_COUNT, "Tom","tom@mail.ru",34));
        people.add(new Person(++PEOPLE_COUNT, "Bob","bob@mail.ru",52));
        people.add(new Person(++PEOPLE_COUNT, "Mike","mike@yahoo.com",18));
        people.add(new Person(++PEOPLE_COUNT, "Katy","katy@gmail.com",34));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person updatePerson) {
        Person personToBeUpdate = show(id);
        personToBeUpdate.setName(updatePerson.getName());
        personToBeUpdate.setAge(updatePerson.getAge());
        personToBeUpdate.setEmail(updatePerson.getEmail());
    }

    public void delete(int id) {
        people.removeIf(person -> person.getId()== id);
    }
}