package ar.com.BackEndSpringboot.api.controllers;

import ar.com.BackEndSpringboot.api.dto.Mensaje;
import ar.com.BackEndSpringboot.api.dto.SoftSkillDTO;
import ar.com.BackEndSpringboot.api.models.SoftSkill;
import ar.com.BackEndSpringboot.api.services.SoftSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/softskill")
@CrossOrigin
public class SoftSkillController {

    @Autowired
    SoftSkillService softSkillService;

    @GetMapping("/all")
    public ResponseEntity<List<SoftSkill>> getSoftskill(){
        List<SoftSkill> list = softSkillService.getSoftskill();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<?> addSoftskill(@RequestBody SoftSkillDTO softSkillDTO){
        SoftSkill skill = new SoftSkill(softSkillDTO.getInformation());
        softSkillService.saveSoftskill(skill);
        return new ResponseEntity(new Mensaje("Creado"), HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<SoftSkill> getById(@PathVariable("id") Long id){
        if(!softSkillService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        SoftSkill skill = softSkillService.getOne(id).get();
        return new ResponseEntity(skill, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSoftskill(@PathVariable Long id){
        if(!softSkillService.existsById(id))
            return new ResponseEntity(new Mensaje("No hay"), HttpStatus.NOT_FOUND);
        softSkillService.deleteSoftskill(id);
        return new ResponseEntity(new Mensaje("Eliminado"), HttpStatus.OK);
    }

    // Necesita ser ADMIN primero para hacerlo
    @PutMapping("/edit/{id}")
    public ResponseEntity<?> editSoftskill(@PathVariable("id") Long id,
                                           @RequestBody SoftSkillDTO softSkillDTO){
        SoftSkill soft = softSkillService.getOne(id).get();
        soft.setInformation(softSkillDTO.getInformation());
        softSkillService.saveSoftskill(soft);
        return new ResponseEntity(new Mensaje("Editado"), HttpStatus.OK);
    }
}
