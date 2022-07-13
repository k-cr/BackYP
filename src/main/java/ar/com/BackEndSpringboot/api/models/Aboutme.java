package ar.com.BackEndSpringboot.api.models;

/*
  <========================================
            IMPORTS Y ANNOTATIONS
  ========================================>
*/

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

// Genera la entidad en la BD
@Entity
// Este es el nombre que recibirá en la BD.
@Table(name = "about")
public class Aboutme {
    /*
      <========================================
                       ATRIBUTOS
      ========================================>
    */

    //Id.
    @Id
    // Lo hace autoincremental
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    // Con esto, hacemos que tenga estos caracteres como máximo.
    private String about;

    /*
      <========================================
                   CONSTRUCTORES
      ========================================>
    */

    //Constructor vacío
    public Aboutme(){}

    //Constructor
    public Aboutme(String about){
        this.about = about;
    }

    /*
      <========================================
                  SETTERS Y GETTERS
      ========================================>
    */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
