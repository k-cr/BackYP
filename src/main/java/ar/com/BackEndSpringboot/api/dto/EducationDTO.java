package ar.com.BackEndSpringboot.api.dto;

import javax.persistence.Column;

public class EducationDTO {
    private String startDate;
    private String finishDate;
    private String degree;

    // Con esto, hacemos que tenga estos caracteres como máximo.
    @Column(length = 2048)
    private String otherInformation;

    public EducationDTO() {
    }

    public EducationDTO(String startDate, String finishDate, String degree, String otherInformation) {
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.degree = degree;
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
