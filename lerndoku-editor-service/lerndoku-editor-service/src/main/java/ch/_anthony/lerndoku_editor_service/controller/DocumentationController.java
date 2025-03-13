package ch._anthony.lerndoku_editor_service.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch._anthony.lerndoku_editor_service.model.Documentation;
import ch._anthony.lerndoku_editor_service.model.request.DocumentationRequest;
import ch._anthony.lerndoku_editor_service.service.DocumentationService;

@RestController
@RequestMapping("/documentations")
public class DocumentationController {

    private final DocumentationService documentationService;

    public DocumentationController(final DocumentationService documentationService) {
        this.documentationService = documentationService;
    }

    @PostMapping
    public Documentation createDocumentation(@RequestBody final DocumentationRequest request) {
        return documentationService.createDocumentation(request);
    }
}
