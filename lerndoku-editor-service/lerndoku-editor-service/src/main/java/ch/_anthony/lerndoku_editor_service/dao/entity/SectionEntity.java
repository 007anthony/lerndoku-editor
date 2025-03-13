package ch._anthony.lerndoku_editor_service.dao.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity(name = "Section")
public class SectionEntity {

    @Id
    private Long id;

    @ManyToOne
    private DocumentationEntity documentation;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public DocumentationEntity getDocumentation() {
        return documentation;
    }

    public void setDocumentation(final DocumentationEntity documentation) {
        this.documentation = documentation;
    }

}
