package ch._anthony.lerndoku_editor_service.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ch._anthony.lerndoku_editor_service.model.Documentation;
import ch._anthony.lerndoku_editor_service.model.request.DocumentationRequest;
import ch._anthony.lerndoku_editor_service.service.DocumentationService;
import ch._anthony.lerndoku_editor_service.util.DocumentationState;

@RestController
@RequestMapping("/documentations")
@CrossOrigin("http://localhost:4200")
public class DocumentationController {

    private final DocumentationService documentationService;

    public DocumentationController(final DocumentationService documentationService) {
        this.documentationService = documentationService;
    }

    @PostMapping
    public Documentation createDocumentation(@RequestBody final DocumentationRequest request) {
        return documentationService.createDocumentation(request);
    }

    @GetMapping
    public List<Documentation> getDocumentations(@RequestParam(required = false) final Integer semester,
            @RequestParam(required = false) final String search,
            @RequestParam(required = false) final DocumentationState state) {
        return documentationService.getDocumentations(search, semester, state);
    }
}
