package ar.com.BackEndSpringboot.api.services;
/*
  <========================================
            IMPORTS Y ANNOTATIONS
  ========================================>
*/
import ar.com.BackEndSpringboot.api.models.Person;
import ar.com.BackEndSpringboot.api.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService{
    // Inyectamos el repósitorio
    @Autowired
    PersonRepository personRepository;
    /*
    <========================================
                Métodos del CRUD
    ========================================>
    */
    public List<Person> getPersons() {
        return personRepository.findAll();
    }

    public Optional<Person> getOne(Long id){
        return personRepository.findById(id);
    }

    public void savePerson(Person person) {
        personRepository.save(person);
    }

    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return personRepository.existsById(id);
    }
}
