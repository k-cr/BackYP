package ar.com.BackEndSpringboot.api.services;

import ar.com.BackEndSpringboot.api.models.SoftSkill;
import ar.com.BackEndSpringboot.api.repositories.SoftSkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SoftSkillService{
    @Autowired
    public SoftSkillRepository softSkillRepository;

    public List<SoftSkill> getSoftskill() {
        return softSkillRepository.findAll();
    }

    public Optional<SoftSkill> getOne(Long id){
        return softSkillRepository.findById(id);
    }

    public void saveSoftskill(SoftSkill softSkill) {
        softSkillRepository.save(softSkill);
    }

    public void deleteSoftskill(Long id) {
        softSkillRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return softSkillRepository.existsById(id);
    }
}
