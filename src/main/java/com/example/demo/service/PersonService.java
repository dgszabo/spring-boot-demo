package com.example.demo.service;

import org.springframework.stereotype.Service;
import java.util.List;

import com.example.demo.persistence.PersonDao;
import com.example.demo.model.Person;

@Service
public class PersonService {
    private final PersonDao personDao;

    public PersonService(PersonDao personDao) {
        this.personDao = personDao;
    }

    public Person findById(Long id) {
        return personDao.findById(id);
    }

    public List<Person> findAll() {
        return personDao.findAll();
    }
    
    public Person save(Person person) {
        return personDao.save(person);
    }

    public void update(Long id, Person person) {
        personDao.update(id, person);
    }

    public void delete(Long id) {
        personDao.delete(id);
    }
}