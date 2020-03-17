package demo.code.data.repository;

import demo.code.data.model.EntityModel;
import demo.code.data.model.EntityType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EntityRepository extends JpaRepository<EntityModel, Long> {
    Optional<EntityModel> findByTypeAndName(EntityType type, String name);
}