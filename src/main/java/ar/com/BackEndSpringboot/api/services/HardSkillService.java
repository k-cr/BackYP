package ar.com.BackEndSpringboot.api.services;

import ar.com.BackEndSpringboot.api.models.HardSkill;
import ar.com.BackEndSpringboot.api.repositories.HardSkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HardSkillService{
    @Autowired
    public HardSkillRepository hardSkillRepository;

    public List<HardSkill> getHardskill() {
        return hardSkillRepository.findAll();
    }

    public Optional<HardSkill> getOne(Long id) {
        return hardSkillRepository.findById(id);
    }

    public void saveHardskill(HardSkill hardSkill) {
        hardSkillRepository.save(hardSkill);
    }

    public void deleteHardskill(Long id) {
        hardSkillRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return hardSkillRepository.existsById(id);
    }
}
