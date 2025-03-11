package ch._anthony.lerndoku_editor_service.repository.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class SectionDao {

    @Id
    private Long id;

    @ManyToOne
    private DocumentationDao documentation;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public DocumentationDao getDocumentation() {
        return documentation;
    }

    public void setDocumentation(final DocumentationDao documentation) {
        this.documentation = documentation;
    }

}
