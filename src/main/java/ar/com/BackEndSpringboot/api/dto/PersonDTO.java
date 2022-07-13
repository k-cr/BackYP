package ar.com.BackEndSpringboot.api.dto;

import javax.persistence.Column;

public class PersonDTO {

    private String fullname;
    private String ocupation;
    private String ubication;
    private String intitution;

    // Con esto, hacemos que tenga estos caracteres como máximo.
    @Column(name = "url_institution", length = 2048)
    private String url_institution;

    @Column(name = "url_pfp", length = 2048)
    private String url_pfp;

    @Column(name = "url_banner", length = 2048)
    private String url_banner;

    public PersonDTO() {
    }

    public PersonDTO(String fullname, String ocupation, String ubication, String intitution, String url_institution, String url_pfp, String url_banner) {
        this.fullname = fullname;
        this.ocupation = ocupation;
        this.ubication = ubication;
        this.intitution = intitution;
        this.url_institution = url_institution;
        this.url_pfp = url_pfp;
        this.url_banner = url_banner;
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
