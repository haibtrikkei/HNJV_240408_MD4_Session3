package ra.rekkei.restapi_basic.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ra.rekkei.restapi_basic.model.entity.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    //@Query("select p from Product  p where p.proName like concat('%',:proName,'%')")
    Page<Product> findProductsByProNameContainsIgnoreCase(String proName, Pageable pageable);

}
