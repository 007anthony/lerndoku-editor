package ch._anthony.lerndoku_editor_service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import ch._anthony.lerndoku_editor_service.model.Documentation;
import ch._anthony.lerndoku_editor_service.model.request.DocumentationRequest;
import ch._anthony.lerndoku_editor_service.repository.dao.DocumentationDao;

@Mapper(componentModel = "spring")
public interface DocumentationMapper {

    @Mapping(target = "sections", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    public DocumentationDao mapToDao(DocumentationRequest request);

    public Documentation mapToModel(DocumentationDao dao);
}
