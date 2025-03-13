package ch._anthony.lerndoku_editor_service.service.impl;

import org.springframework.stereotype.Service;

import ch._anthony.lerndoku_editor_service.mapper.DocumentationMapper;
import ch._anthony.lerndoku_editor_service.model.Documentation;
import ch._anthony.lerndoku_editor_service.model.request.DocumentationRequest;
import ch._anthony.lerndoku_editor_service.repository.DocumentationRepository;
import ch._anthony.lerndoku_editor_service.repository.dao.DocumentationDao;
import ch._anthony.lerndoku_editor_service.service.DocumentationService;

@Service
public class DocumentationServiceImpl implements DocumentationService {

    private final DocumentationRepository documentationRepository;
    private final DocumentationMapper documentationMapper;

    public DocumentationServiceImpl(final DocumentationRepository documentationRepository,
            final DocumentationMapper documentationMapper) {
        this.documentationRepository = documentationRepository;
        this.documentationMapper = documentationMapper;
    }

    @Override
    public Documentation createDocumentation(final DocumentationRequest request) {
        final DocumentationDao documentatioDao = documentationMapper.mapToDao(request);

        documentationRepository.save(documentatioDao);

        return this.documentationMapper.mapToModel(documentatioDao);
    }

}
