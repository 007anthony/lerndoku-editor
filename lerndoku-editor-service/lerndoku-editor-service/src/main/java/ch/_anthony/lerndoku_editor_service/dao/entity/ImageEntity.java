package ch._anthony.lerndoku_editor_service.dao.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity(name = "Image")
public class ImageEntity {

    @Id
    private Long id;
    private String imageUrl;

    @OneToOne
    private DocumentationEntity documentation;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(final String imageUrl) {
        this.imageUrl = imageUrl;
    }

}
