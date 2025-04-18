package com.example.demo.persistence;

import com.example.demo.model.Person;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonH2 implements PersonDao {
    
    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<Person> personRowMapper = (rs, rowNum) -> 
        new Person(rs.getLong("id"), rs.getString("name"), rs.getString("email"));

    public PersonH2(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    @Override
    public Person findById(Long id) {
        return jdbcTemplate.queryForObject(
            "SELECT * FROM people WHERE id = ?", 
            personRowMapper, 
            id
        );
    }

    @Override
    public List<Person> findAll() {
        return jdbcTemplate.query(
            "SELECT * FROM people", 
            personRowMapper
        );
    }

    @Override
    public Person save(Person person) {
        jdbcTemplate.update(
            "INSERT INTO people (name, email) VALUES (?, ?)",
            person.getName(),
            person.getEmail()
        );
        return person;
    }

    @Override
    public void update(Long id, Person person) {
        jdbcTemplate.update(
            "UPDATE people SET name = ?, email = ? WHERE id = ?",
            person.getName(),
            person.getEmail(),
            id
        );
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update(
            "DELETE FROM people WHERE id = ?",
            id
        );
    }
}
