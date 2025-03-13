package ch._anthony.lerndoku_editor_service.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import ch._anthony.lerndoku_editor_service.dao.entity.DocumentationEntity;
import ch._anthony.lerndoku_editor_service.model.Documentation;
import ch._anthony.lerndoku_editor_service.model.request.DocumentationRequest;
import ch._anthony.lerndoku_editor_service.util.DocumentationState;

@Mapper(componentModel = "spring", imports = { DocumentationState.class })
public interface DocumentationMapper {

    @Mapping(target = "sections", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "image", ignore = true)
    @Mapping(target = "state", expression = "java(DocumentationState.OPEN)")
    public DocumentationEntity mapToDao(DocumentationRequest request);

    public Documentation mapToModel(DocumentationEntity dao);

    public List<Documentation> mapToModel(List<DocumentationEntity> daos);
}
