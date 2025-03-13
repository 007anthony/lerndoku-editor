package ch._anthony.lerndoku_editor_service.dao.entity;

import java.util.Date;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;

import ch._anthony.lerndoku_editor_service.util.DocumentationState;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity(name = "Documentation")
public class DocumentationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    private Date createdAt;
    private String title;
    private Integer semester;
    @Enumerated(EnumType.STRING)
    private DocumentationState state;

    @OneToOne
    private ImageEntity image;

    @OneToMany(mappedBy = "documentation")
    private Set<SectionEntity> sections;

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

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(final Integer semester) {
        this.semester = semester;
    }

    public DocumentationState getState() {
        return state;
    }

    public void setState(final DocumentationState state) {
        this.state = state;
    }

    public Set<SectionEntity> getSections() {
        return sections;
    }

    public void setSections(final Set<SectionEntity> sections) {
        this.sections = sections;
    }

    public ImageEntity getImage() {
        return image;
    }

    public void setImage(final ImageEntity image) {
        this.image = image;
    }

}