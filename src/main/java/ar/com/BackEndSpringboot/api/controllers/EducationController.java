package ar.com.BackEndSpringboot.api.controllers;
/*
  <========================================
            IMPORTS Y ANNOTATIONS
  ========================================>
*/
import ar.com.BackEndSpringboot.api.dto.EducationDTO;
import ar.com.BackEndSpringboot.api.dto.Mensaje;
import ar.com.BackEndSpringboot.api.models.Education;
import ar.com.BackEndSpringboot.api.services.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/education")
@CrossOrigin
public class EducationController {
    @Autowired
    private EducationService educationService;

    @GetMapping("/all")
    public ResponseEntity<List<Education>> getEducation(){
        List<Education> list = educationService.getEducation();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<?> addEducation(@RequestBody EducationDTO educationDTO){
        Education education = new Education(educationDTO.getStartDate(), educationDTO.getFinishDate(), educationDTO.getDegree(), educationDTO.getOtherInformation());
        educationService.saveEducation(education);
        return new ResponseEntity(new Mensaje("Creado"), HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> editEducation(@PathVariable("id") Long id, @RequestBody EducationDTO educationDTO){
        Education edu = educationService.getOne(id).get();
        edu.setDegree(educationDTO.getDegree());
        edu.setStartDate(educationDTO.getStartDate());
        edu.setFinishDate(educationDTO.getFinishDate());
        edu.setOtherInformation(educationDTO.getOtherInformation());
        educationService.saveEducation(edu);
        return new ResponseEntity(new Mensaje("Editado"), HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Education> getById(@PathVariable("id") Long id) {
        if(!educationService.existsById(id)){
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Education education = educationService.getOne(id).get();
        return new ResponseEntity(education, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEducation(@PathVariable("id") Long id){
        if(!educationService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        educationService.deleteEducation(id);
        return new ResponseEntity(new Mensaje("Eliminado"), HttpStatus.OK);
    }
}
