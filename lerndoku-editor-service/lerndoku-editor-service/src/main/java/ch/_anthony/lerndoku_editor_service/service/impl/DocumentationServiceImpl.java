package ch._anthony.lerndoku_editor_service.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import ch._anthony.lerndoku_editor_service.dao.DocumentationDao;
import ch._anthony.lerndoku_editor_service.dao.entity.DocumentationEntity;
import ch._anthony.lerndoku_editor_service.mapper.DocumentationMapper;
import ch._anthony.lerndoku_editor_service.model.Documentation;
import ch._anthony.lerndoku_editor_service.model.request.DocumentationRequest;
import ch._anthony.lerndoku_editor_service.service.DocumentationService;
import ch._anthony.lerndoku_editor_service.util.DocumentationState;

@Service
public class DocumentationServiceImpl implements DocumentationService {

    private final DocumentationDao documentationRepository;
    private final DocumentationMapper documentationMapper;

    public DocumentationServiceImpl(final DocumentationDao documentationRepository,
            final DocumentationMapper documentationMapper) {
        this.documentationRepository = documentationRepository;
        this.documentationMapper = documentationMapper;
    }

    @Override
    public Documentation createDocumentation(final DocumentationRequest request) {
        final DocumentationEntity documentatioDao = documentationMapper.mapToDao(request);

        documentationRepository.save(documentatioDao);

        return this.documentationMapper.mapToModel(documentatioDao);
    }

    @Override
    public List<Documentation> getDocumentations(final String search, final Integer semester,
            final DocumentationState state) {
        final List<DocumentationEntity> documentations = documentationRepository.findAll(semester, state);

        return this.documentationMapper.mapToModel(documentations);
    }

}
