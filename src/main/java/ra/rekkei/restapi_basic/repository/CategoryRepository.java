package ra.rekkei.restapi_basic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.rekkei.restapi_basic.model.entity.Category;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category,String> {
    List<Category> findCategoriesByCateNameContains(String cateName);
}
