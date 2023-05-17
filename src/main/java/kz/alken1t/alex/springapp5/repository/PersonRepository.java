package kz.alken1t.alex.springapp5.repository;

import kz.alken1t.alex.springapp5.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Long> {

}