package demo.code.data.repository;

import demo.code.data.model.BulletModel;
import demo.code.data.model.BulletType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BulletRepository extends JpaRepository<BulletModel, Long> {
    List<BulletModel> findByTypeAndGroupIdIn(BulletType type, List<Long> groupIds);
}
