package ar.com.BackEndSpringboot.api.models;

/*
  <========================================
            IMPORTS Y ANNOTATIONS
  ========================================>
*/

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

// Genera la entidad en la BD
@Entity
// Este es el nombre que recibirá en la BD
@Table(name = "softskill")
public class SoftSkill {
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
    private String information;

    /*
      <========================================
                   CONSTRUCTORES
      ========================================>
    */
    // Constructor vacío
    public SoftSkill(){}
    // Constructor
    public SoftSkill(String information){
        this.information = information;
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

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }
}
