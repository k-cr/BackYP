package ar.com.BackEndSpringboot.api.dto;

import javax.persistence.Column;

public class SoftSkillDTO {
    // Con esto, hacemos que tenga estos caracteres como máximo.
    @Column(length = 2048)
    private String information;

    public SoftSkillDTO(String information) {
        this.information = information;
    }

    public SoftSkillDTO() {
    }

    public String getInformation() {
        
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }
}
