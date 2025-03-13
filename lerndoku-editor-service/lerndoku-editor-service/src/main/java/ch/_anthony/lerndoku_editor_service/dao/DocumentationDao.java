package ch._anthony.lerndoku_editor_service.dao;

import java.util.List;

import ch._anthony.lerndoku_editor_service.dao.entity.DocumentationEntity;
import ch._anthony.lerndoku_editor_service.util.DocumentationState;

public interface DocumentationDao {

    public DocumentationEntity save(DocumentationEntity documentationEntity);

    public List<DocumentationEntity> findAll(Integer semester, DocumentationState state);

}
