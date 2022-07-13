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
@Table(name = "project")
public class Project {
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

    private String name;
    private String description;
    private String url_image;
    private String url_liveDemo;
    private String url_sourceCode;

    /*
      <========================================
                   CONSTRUCTORES
      ========================================>
    */
    // Constructor vacío
    public Project(){}

    // Constructor
    public Project(String name, String description, String url_image, String url_liveDemo, String url_sourceCode){
        this.name = name;
        this.description = description;
        this.url_image = url_image;
        this.url_liveDemo = url_liveDemo;
        this.url_sourceCode = url_sourceCode;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl_image() {
        return url_image;
    }

    public void setUrl_image(String url_image) {
        this.url_image = url_image;
    }

    public String getUrl_liveDemo() {
        return url_liveDemo;
    }

    public void setUrl_liveDemo(String url_liveDemo) {
        this.url_liveDemo = url_liveDemo;
    }

    public String getUrl_sourceCode() {
        return url_sourceCode;
    }

    public void setUrl_sourceCode(String url_sourceCode) {
        this.url_sourceCode = url_sourceCode;
    }
}
