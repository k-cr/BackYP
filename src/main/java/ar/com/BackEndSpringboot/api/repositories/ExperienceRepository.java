package ar.com.BackEndSpringboot.api.repositories;

/*
  <========================================
            IMPORTS Y ANNOTATIONS
  ========================================>
*/
import ar.com.BackEndSpringboot.api.models.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Indica que es un repositorio
@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Long> {
}
