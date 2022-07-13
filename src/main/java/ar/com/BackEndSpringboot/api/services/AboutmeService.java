package ar.com.BackEndSpringboot.api.services;

/*
  <========================================
            IMPORTS Y ANNOTATIONS
  ========================================>
*/
import ar.com.BackEndSpringboot.api.models.Aboutme;
import ar.com.BackEndSpringboot.api.repositories.AboutmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// Indica que es un servicio
@Service
@Transactional
public class AboutmeService{
    // Inyectamos la interfaz del repositorio
    @Autowired
    public AboutmeRepository aboutmeRepository;
    /*
    <========================================
                Métodos del CRUD
    ========================================>
    */
    public List<Aboutme> getAbout() {
        return aboutmeRepository.findAll();
    }

    public Optional<Aboutme> getOne(Long id) {
        return aboutmeRepository.findById(id);
    }

    public void saveAbout(Aboutme aboutme) {
        aboutmeRepository.save(aboutme);
    }

    public void deleteAbout(Long id) {
        aboutmeRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return aboutmeRepository.existsById(id);
    }
}
