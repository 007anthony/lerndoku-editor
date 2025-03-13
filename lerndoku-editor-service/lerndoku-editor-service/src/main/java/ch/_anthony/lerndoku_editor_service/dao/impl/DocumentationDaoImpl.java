package ch._anthony.lerndoku_editor_service.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import ch._anthony.lerndoku_editor_service.dao.DocumentationDao;
import ch._anthony.lerndoku_editor_service.dao.entity.DocumentationEntity;
import ch._anthony.lerndoku_editor_service.util.DocumentationState;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class DocumentationDaoImpl implements DocumentationDao {

    private final EntityManager entityManager;

    public DocumentationDaoImpl(final EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public DocumentationEntity save(final DocumentationEntity documentationEntity) {
        entityManager.persist(documentationEntity);

        return documentationEntity;
    }

    @Override
    @Transactional
    public List<DocumentationEntity> findAll(final Integer semester, final DocumentationState state) {
        final TypedQuery<DocumentationEntity> query = entityManager.createQuery(
                "select documentation from Documentation documentation where (:semester is null or documentation.semester = :semester) and (:state is null or documentation.state = :state)",
                DocumentationEntity.class);

        return query
                .setParameter("semester", semester)
                .setParameter("state", state)
                .getResultList();
    }

}
