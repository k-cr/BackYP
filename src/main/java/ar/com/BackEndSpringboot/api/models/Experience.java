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
@Table(name = "experience")
public class Experience {
    /*
      <========================================
                       ATRIBUTOS
      ========================================>
    */

    //Id.
    @Id
    // Lo hace autoincremental
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String startDate;
    private String finishDate;
    private String ocupation;
    private String otherInformation;

    /*
      <========================================
                   CONSTRUCTORES
      ========================================>
    */

    //Constructor vacío
    public Experience(){}
    //Constructor
    public Experience(String startDate, String finishDate, String ocupation, String otherInformation){
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.ocupation = ocupation;
        this.otherInformation = otherInformation;
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

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(String finishDate) {
        this.finishDate = finishDate;
    }

    public String getOcupation() {
        return ocupation;
    }

    public void setOcupation(String ocupation) {
        this.ocupation = ocupation;
    }

    public String getOtherInformation() {
        return otherInformation;
    }

    public void setOtherInformation(String otherInformation) {
        this.otherInformation = otherInformation;
    }
}
