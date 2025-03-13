package ch._anthony.lerndoku_editor_service.model;

import java.util.Date;

import ch._anthony.lerndoku_editor_service.util.DocumentationState;

public class Documentation {
    private Long id;
    private String title;
    private Date createdAt;
    private Integer semester;
    private DocumentationState state;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(final Date createdAt) {
        this.createdAt = createdAt;
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

}
