package ar.com.BackEndSpringboot.api.repositories;

/*
  <========================================
            IMPORTS Y ANNOTATIONS
  ========================================>
*/
import ar.com.BackEndSpringboot.api.models.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// Indica que es un repositorio
@Repository
public interface EducationRepository extends JpaRepository<Education, Long> {
    Optional<Education> findByDegree(String degree);
    boolean existsByDegree(String degree);
}
