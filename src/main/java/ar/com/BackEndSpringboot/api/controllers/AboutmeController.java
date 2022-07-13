package ar.com.BackEndSpringboot.api.controllers;

/*
  <========================================
            IMPORTS Y ANNOTATIONS
  ========================================>
*/
import ar.com.BackEndSpringboot.api.dto.AboutmeDTO;
import ar.com.BackEndSpringboot.api.dto.Mensaje;
import ar.com.BackEndSpringboot.api.models.Aboutme;
import ar.com.BackEndSpringboot.api.services.AboutmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

// Indica que es una Rest Controller
@RestController
// Dirección donde se accede
@RequestMapping("/api/about")
// Desde qué dirección se puede acceder (Dejarlo vacío para todas las direcciones)
@CrossOrigin
public class AboutmeController {
    /*
    <========================================
                  INYECCIONES
    ========================================>
    */
    @Autowired
    AboutmeService aboutmeService;

    /*
    <========================================
                 MÉTODOS DEL CRUD
    ========================================>
    */

    // <-------- Nuevo aboutme ---------->
    // Necesita ser ADMIN primero para hacerlo
    // A esta ruta ingresamos.
    @PostMapping("/new")
    public ResponseEntity<?> addAbout(@RequestBody AboutmeDTO aboutmeDTO) {
        Aboutme aboutme = new Aboutme(aboutmeDTO.getAbout());
        aboutmeService.saveAbout(aboutme);
        return new ResponseEntity(new Mensaje("Creado"), HttpStatus.OK);
    }

    // <-------- Mostrar aboutme ---------->
    // A esta ruta ingresamos.
    @GetMapping("/all")
    public ResponseEntity<List<Aboutme>> getAbout(){
        List<Aboutme> list = aboutmeService.getAbout();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Aboutme> getById(@PathVariable("id") Long id) {
        if(!aboutmeService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        Aboutme aboutme = aboutmeService.getOne(id).get();
        return new ResponseEntity(aboutme, HttpStatus.OK);
    }

    // <-------- Eliminar aboutme ---------->
    // Necesita ser ADMIN primero para hacerlo
    // A esta ruta ingresamos.
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAbout(@PathVariable("id") Long id){
        aboutmeService.deleteAbout(id);
        return new ResponseEntity(new Mensaje("Eliminado"), HttpStatus.OK);
    }

    // <-------- Editar aboutme ---------->
    // Necesita ser ADMIN primero para hacerlo
    // A esta ruta ingresamos.
    @PutMapping("/edit/{id}")
    public ResponseEntity<?> editAbout(@PathVariable("id") Long id, @RequestBody AboutmeDTO aboutmeDTO){
        Aboutme aboutme = aboutmeService.getOne(id).get();
        aboutme.setAbout(aboutmeDTO.getAbout());
        aboutmeService.saveAbout(aboutme);
        return new ResponseEntity(new Mensaje("Editado"), HttpStatus.OK);
    }
}
