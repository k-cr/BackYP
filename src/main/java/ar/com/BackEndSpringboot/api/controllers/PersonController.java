package ar.com.BackEndSpringboot.api.controllers;

import ar.com.BackEndSpringboot.api.dto.Mensaje;
import ar.com.BackEndSpringboot.api.dto.PersonDTO;
import ar.com.BackEndSpringboot.api.models.Person;
import ar.com.BackEndSpringboot.api.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/person")
@CrossOrigin
public class PersonController {
   @Autowired
   private PersonService personService;

   @GetMapping("/all")
   public ResponseEntity<List<Person>>getPersons(){
      List<Person> list = this.personService.getPersons();
      return new ResponseEntity(list, HttpStatus.OK);
   }

   @PostMapping("/new")
   public ResponseEntity<?> addPersons(@RequestBody PersonDTO personDTO){
      Person person = new Person(personDTO.getFullname(), personDTO.getOcupation(), personDTO.getUbication(), personDTO.getIntitution(), personDTO.getUrl_institution(), personDTO.getUrl_pfp(), personDTO.getUrl_banner());
      personService.savePerson(person);
      return new ResponseEntity(new Mensaje("Creado"), HttpStatus.OK);
   }

   @GetMapping("/detail/{id}")
   public ResponseEntity<Person> getById(@PathVariable("id") Long id) {
      if(!personService.existsById(id)){
         return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
      }
      Person person = personService.getOne(id).get();
      return new ResponseEntity(person, HttpStatus.OK);
   }

   @PutMapping("/edit/{id}")
   public ResponseEntity<?> editPerson(@PathVariable("id")Long id,
                                       @RequestBody PersonDTO personDTO){
   Person per = personService.getOne(id).get();
   per.setFullname(personDTO.getFullname());
   per.setOcupation(personDTO.getOcupation());
   per.setUbication(personDTO.getUbication());
   per.setIntitution(personDTO.getIntitution());
   per.setUrl_institution(personDTO.getUrl_institution());
   per.setUrl_pfp(personDTO.getUrl_pfp());
   per.setUrl_banner(personDTO.getUrl_banner());
   personService.savePerson(per);
   return new ResponseEntity(new Mensaje("Editado"), HttpStatus.OK);
   }

   @DeleteMapping("/delete/{id}")
   public ResponseEntity<?> deletePerson(@PathVariable("id") Long id){
      if(!personService.existsById(id))
         return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
      personService.deletePerson(id);
      return new ResponseEntity(new Mensaje("Eliminado"), HttpStatus.OK);
   }
}
