package ar.com.BackEndSpringboot.api.dto;

import javax.persistence.Column;

public class AboutmeDTO {
    @Column(length = 2048)
    private String about;

    public AboutmeDTO() {
    }

    public AboutmeDTO(String about) {
        this.about = about;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
