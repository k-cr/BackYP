package ar.com.BackEndSpringboot.api.repositories;

/*
  <========================================
            IMPORTS Y ANNOTATIONS
  ========================================>
*/
import ar.com.BackEndSpringboot.api.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Indica que es un repositorio
@Repository
public interface PersonRepository extends JpaRepository <Person, Long>{

}
