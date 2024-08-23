package ra.rekkei.restapi_basic.service;

import org.springframework.data.domain.Page;
import ra.rekkei.restapi_basic.model.dto.request.ProductRequest;
import ra.rekkei.restapi_basic.model.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProducts();
    Product getProductById(Integer proId);
    Product insertProduct(ProductRequest p);
    Product upateProduct(Integer proId, ProductRequest p);
    void deleteProduct(Integer proId);
    //List<Product> getProductsByName(String proName);
    Page<Product> getProductsWithPaginationAndSorting(String searchName, Integer page, Integer pageSize, String sortBy, String orderBy);
}
