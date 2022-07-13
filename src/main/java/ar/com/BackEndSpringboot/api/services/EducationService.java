package ar.com.BackEndSpringboot.api.services;
/*
  <========================================
            IMPORTS Y ANNOTATIONS
  ========================================>
*/
import ar.com.BackEndSpringboot.api.models.Education;
import ar.com.BackEndSpringboot.api.repositories.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EducationService{
    @Autowired
    public EducationRepository educationRepository;


    public List<Education> getEducation() {
        return educationRepository.findAll();
    }

    public Optional<Education> getOne(Long id){
        return educationRepository.findById(id);
    }

    public void saveEducation(Education education) {
        educationRepository.save(education);
    }

    public void deleteEducation(Long id) {
        educationRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return educationRepository.existsById(id);
    }

    public boolean existsByDegree(String degree){
        return educationRepository.existsByDegree(degree);
    }
}
