package ar.com.BackEndSpringboot.api.controllers;

import ar.com.BackEndSpringboot.api.dto.HardSkillDTO;
import ar.com.BackEndSpringboot.api.dto.Mensaje;
import ar.com.BackEndSpringboot.api.models.HardSkill;
import ar.com.BackEndSpringboot.api.services.HardSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/hardskill")
@CrossOrigin
public class HardskillController {

    @Autowired
    private HardSkillService hardskillService;

    @PostMapping("/new")
    public ResponseEntity<?> addHardskill(@RequestBody HardSkillDTO hardSkillDTO){
        HardSkill hardSkill = new HardSkill(hardSkillDTO.getName(), hardSkillDTO.getLevel());
        hardskillService.saveHardskill(hardSkill);
        return new ResponseEntity(new Mensaje("Creado"), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<HardSkill>> getHardskill(){
        List <HardSkill> list = hardskillService.getHardskill();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<HardSkill> getById(@PathVariable("id") Long id) {
        if(!hardskillService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        }
        HardSkill hardSkill = hardskillService.getOne(id).get();
        return new ResponseEntity(hardSkill, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteHardskill(@PathVariable("id") Long id){
        if(!hardskillService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        hardskillService.deleteHardskill(id);
        return new ResponseEntity(new Mensaje("Eliminado"), HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> editHardskill(@PathVariable("id") Long id,
                                           @RequestBody HardSkillDTO hardSkillDTO){
        HardSkill skill = hardskillService.getOne(id).get();
        skill.setName(hardSkillDTO.getName());
        skill.setLevel(hardSkillDTO.getLevel());
        hardskillService.saveHardskill(skill);
        return new ResponseEntity(new Mensaje("Editado"), HttpStatus.OK);
    }
}
