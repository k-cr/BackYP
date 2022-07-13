package ar.com.BackEndSpringboot.api.services;

import ar.com.BackEndSpringboot.api.models.Experience;
import ar.com.BackEndSpringboot.api.repositories.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ExperienceService{

    @Autowired
    public ExperienceRepository experienceRepository;

    public List<Experience> getExperience() {
        return experienceRepository.findAll();
    }

    public Optional<Experience> getOne(Long id){
        return experienceRepository.findById(id);
    }

    public void saveExperience(Experience experience) {
        experienceRepository.save(experience);
    }

    public void deleteExperience(Long id) {
        experienceRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return experienceRepository.existsById(id);
    }
}
