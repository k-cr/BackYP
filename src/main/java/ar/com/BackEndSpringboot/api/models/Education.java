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
@Table(name = "education")
public class Education {
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

    private String startDate;
    private String finishDate;
    private String degree;
    private String otherInformation;

    /*
      <========================================
                   CONSTRUCTORES
      ========================================>
    */

    //Constructor vacío
    public Education(){}

    //Constructor
    public Education(String startDate, String finishDate, String degree, String otherInformation){
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.degree = degree;
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

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getOtherInformation() {
        return otherInformation;
    }

    public void setOtherInformation(String otherInformation) {
        this.otherInformation = otherInformation;
    }
}
