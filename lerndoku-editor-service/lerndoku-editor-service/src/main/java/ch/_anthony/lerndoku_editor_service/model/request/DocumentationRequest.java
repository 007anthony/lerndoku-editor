package ch._anthony.lerndoku_editor_service.model.request;

public class DocumentationRequest {
    private String title;
    private int semester;

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(final int semester) {
        this.semester = semester;
    }

}
