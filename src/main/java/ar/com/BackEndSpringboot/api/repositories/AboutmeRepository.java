package ar.com.BackEndSpringboot.api.repositories;

/*
  <========================================
            IMPORTS Y ANNOTATIONS
  ========================================>
*/
import ar.com.BackEndSpringboot.api.models.Aboutme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Indica que esto es un repositorio.
@Repository
public interface AboutmeRepository extends JpaRepository<Aboutme, Long> {
}
