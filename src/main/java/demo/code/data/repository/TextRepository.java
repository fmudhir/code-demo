package demo.code.data.repository;

import demo.code.data.model.TextModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TextRepository extends JpaRepository<TextModel, Long> {
    List<TextModel> findByEntityId(Long entityId);
}
