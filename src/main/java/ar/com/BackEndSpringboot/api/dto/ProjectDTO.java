package ar.com.BackEndSpringboot.api.dto;


import javax.persistence.Column;

public class ProjectDTO {

    private String name;
    private String description;

    // Con esto, hacemos que tenga estos caracteres como máximo.
    @Column(length = 2048)
    private String url_image;

    // Con esto, hacemos que tenga estos caracteres como máximo.
    @Column(length = 2048)
    private String url_liveDemo;

    // Con esto, hacemos que tenga estos caracteres como máximo.
    @Column(length = 2048)
    private String url_sourceCode;

    public ProjectDTO() {
    }

    public ProjectDTO(String name, String description, String url_image, String url_liveDemo, String url_sourceCode) {
        this.name = name;
        this.description = description;
        this.url_image = url_image;
        this.url_liveDemo = url_liveDemo;
        this.url_sourceCode = url_sourceCode;
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
