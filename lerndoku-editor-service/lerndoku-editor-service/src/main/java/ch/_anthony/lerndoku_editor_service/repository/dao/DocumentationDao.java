package ch._anthony.lerndoku_editor_service.repository.dao;

import java.util.Date;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class DocumentationDao {

    @Id
    private Long id;
    private Date date;
    private String title;

    @OneToOne
    private DocumentationDao documentation;

    @OneToMany(mappedBy = "documentation")
    private Set<SectionDao> sections;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(final Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public Set<SectionDao> getSections() {
        return this.sections;
    }

    public void setSections(final Set<SectionDao> sections) {
        this.sections = sections;
    }

}