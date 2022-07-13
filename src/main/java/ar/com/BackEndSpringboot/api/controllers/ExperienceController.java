package ar.com.BackEndSpringboot.api.controllers;

import ar.com.BackEndSpringboot.api.dto.ExperienceDTO;
import ar.com.BackEndSpringboot.api.dto.Mensaje;
import ar.com.BackEndSpringboot.api.models.Experience;
import ar.com.BackEndSpringboot.api.services.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/experience")
@CrossOrigin
public class ExperienceController {

    @Autowired
    public ExperienceService experienceService;

    @GetMapping("/all")
    public ResponseEntity<List<Experience>> getExperience(){
        List<Experience> list = experienceService.getExperience();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<?> addExperience(@RequestBody ExperienceDTO experienceDTO){
        Experience exp = new Experience(experienceDTO.getStartDate(), experienceDTO.getFinishDate(), experienceDTO.getOcupation(), experienceDTO.getOtherInformation());
        experienceService.saveExperience(exp);
        return new ResponseEntity(new Mensaje("Creado"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteExperience(@PathVariable("id") Long id){
        if(!experienceService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        experienceService.deleteExperience(id);
        return new ResponseEntity(new Mensaje("Eliminado"), HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Experience> getById(@PathVariable("id") Long id){
        if(!experienceService.existsById(id)){
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Experience experience = experienceService.getOne(id).get();
        return new ResponseEntity(experience, HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> editExperience(@PathVariable("id") Long id, @RequestBody ExperienceDTO experienceDTO){
        Experience exp = experienceService.getOne(id).get();
        exp.setOcupation(experienceDTO.getOcupation());
        exp.setStartDate(experienceDTO.getStartDate());
        exp.setFinishDate(experienceDTO.getFinishDate());
        exp.setOtherInformation(experienceDTO.getOtherInformation());
        experienceService.saveExperience(exp);
        return new ResponseEntity(new Mensaje("Editado"), HttpStatus.OK);
    }
}
