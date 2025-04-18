package com.example.demo.persistence;

import java.util.List;

import com.example.demo.model.Person;

public interface PersonDao {
    
    Person findById(Long id);
    
    List<Person> findAll();
    
    Person save(Person person);
    
    void update(Long id, Person person);
    
    void delete(Long id);

}
