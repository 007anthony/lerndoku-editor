package ch._anthony.lerndoku_editor_service.service;

import ch._anthony.lerndoku_editor_service.model.Documentation;
import ch._anthony.lerndoku_editor_service.model.request.DocumentationRequest;

public interface DocumentationService {

    public Documentation createDocumentation(DocumentationRequest documentationRequest);
}