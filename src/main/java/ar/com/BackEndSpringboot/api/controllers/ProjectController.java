package ar.com.BackEndSpringboot.api.controllers;

import ar.com.BackEndSpringboot.api.dto.Mensaje;
import ar.com.BackEndSpringboot.api.dto.ProjectDTO;
import ar.com.BackEndSpringboot.api.models.Project;
import ar.com.BackEndSpringboot.api.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/projects")
@CrossOrigin
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @PostMapping("/new")
    public ResponseEntity<?> addProject(@RequestBody ProjectDTO projectDTO) {
        Project project = new Project(projectDTO.getName(), projectDTO.getDescription(), projectDTO.getUrl_image(), projectDTO.getUrl_liveDemo(), projectDTO.getUrl_sourceCode());
        projectService.saveProjects(project);
        return new ResponseEntity(new Mensaje("Creado"), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Project>> getProjects() {
        List<Project> list = projectService.getProjects();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Project> getById(@PathVariable("id") Long id){
        if(!projectService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        Project project = projectService.getOne(id).get();
        return new ResponseEntity(project, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProject(@PathVariable("id") Long id){
        if(!projectService.existsById(id))
            return new ResponseEntity(new Mensaje("No hay"), HttpStatus.NOT_FOUND);
        projectService.deleteProjects(id);
        return new ResponseEntity(new Mensaje("Eliminado"), HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> editProject(@PathVariable("id") Long id,
                                               @RequestBody ProjectDTO projectDTO){
        Project pro = projectService.getOne(id).get();
        pro.setName(projectDTO.getName());
        pro.setDescription(projectDTO.getDescription());
        pro.setUrl_image(projectDTO.getUrl_image());
        pro.setUrl_liveDemo(projectDTO.getUrl_liveDemo());
        pro.setUrl_sourceCode(projectDTO.getUrl_sourceCode());
        projectService.saveProjects(pro);
        return new ResponseEntity(new Mensaje("Editado"), HttpStatus.OK);
    }
}
