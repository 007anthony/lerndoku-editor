package ch._anthony.lerndoku_editor_service.repository.dao;

import java.util.Date;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class DocumentationDao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    private Date createdAt;
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(final Date createdAt) {
        this.createdAt = createdAt;
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