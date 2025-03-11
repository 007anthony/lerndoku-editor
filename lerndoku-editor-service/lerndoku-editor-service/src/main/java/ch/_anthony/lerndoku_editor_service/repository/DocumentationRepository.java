package ch._anthony.lerndoku_editor_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ch._anthony.lerndoku_editor_service.repository.dao.DocumentationDao;

@Repository
public interface DocumentationRepository extends JpaRepository<DocumentationDao, Long> {

}
