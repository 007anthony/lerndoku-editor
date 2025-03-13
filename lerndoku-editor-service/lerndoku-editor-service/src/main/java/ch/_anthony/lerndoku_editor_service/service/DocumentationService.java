package ch._anthony.lerndoku_editor_service.service;

import java.util.List;

import ch._anthony.lerndoku_editor_service.model.Documentation;
import ch._anthony.lerndoku_editor_service.model.request.DocumentationRequest;
import ch._anthony.lerndoku_editor_service.util.DocumentationState;

public interface DocumentationService {

    public Documentation createDocumentation(DocumentationRequest documentationRequest);

    public List<Documentation> getDocumentations(String search, Integer semester, DocumentationState state);
}