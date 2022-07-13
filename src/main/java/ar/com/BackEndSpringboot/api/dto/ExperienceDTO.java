package ar.com.BackEndSpringboot.api.dto;

import javax.persistence.Column;

public class ExperienceDTO {
    private String startDate;
    private String finishDate;
    private String ocupation;

    // Con esto, hacemos que tenga estos caracteres como máximo.
    @Column(length = 2048)
    private String otherInformation;

    public ExperienceDTO() {
    }

    public ExperienceDTO(String startDate, String finishDate, String ocupation, String otherInformation) {
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.ocupation = ocupation;
        this.otherInformation = otherInformation;
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
