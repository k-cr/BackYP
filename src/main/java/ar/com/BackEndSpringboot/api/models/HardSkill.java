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
// Este es el nombre que recibirá en la BD.
@Table(name = "hardskill")
public class HardSkill {
    /*
      <========================================
                       ATRIBUTOS
      ========================================>
    */

    //Id.
    @Id
    // lo hace autoincremental
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int level;

    /*
    <========================================
                  CONSTRUCTORES
    ========================================>
    */
    //Constructor vacío
    public HardSkill(){}

    //Constructor
    public HardSkill(String name, int level){
        this.name = name;
        this.level = level;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
