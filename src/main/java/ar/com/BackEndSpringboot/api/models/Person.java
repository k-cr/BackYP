package ar.com.BackEndSpringboot.api.models;

/*
  <========================================
            IMPORTS Y ANNOTATIONS
  ========================================>
*/

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;
import java.util.List;

// Genera la entidad en la BD
@Entity
// Este es el nombre que recibirá en la BD.
@Table(name = "person")
public class Person {
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

    private String fullname;
    private String ocupation;
    private String ubication;
    private String intitution;
    private String url_institution;
    private String url_pfp;
    private String url_banner;
    /*
      <========================================
                   CONSTRUCTORES
      ========================================>
    */
    public Person(){

    }

    public Person(String fullname, String ocupation, String ubication, String intitution, String url_institution, String url_pfp, String url_banner) {
        this.fullname = fullname;
        this.ocupation = ocupation;
        this.ubication = ubication;
        this.intitution = intitution;
        this.url_institution = url_institution;
        this.url_pfp = url_pfp;
        this.url_banner = url_banner;
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

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getOcupation() {
        return ocupation;
    }

    public void setOcupation(String ocupation) {
        this.ocupation = ocupation;
    }

    public String getUbication() {
        return ubication;
    }

    public void setUbication(String ubication) {
        this.ubication = ubication;
    }

    public String getIntitution() {
        return intitution;
    }

    public void setIntitution(String intitution) {
        this.intitution = intitution;
    }

    public String getUrl_institution() {
        return url_institution;
    }

    public void setUrl_institution(String url_institution) {
        this.url_institution = url_institution;
    }

    public String getUrl_pfp() {
        return url_pfp;
    }

    public void setUrl_pfp(String url_pfp) {
        this.url_pfp = url_pfp;
    }

    public String getUrl_banner() {
        return url_banner;
    }

    public void setUrl_banner(String url_banner) {
        this.url_banner = url_banner;
    }
}
