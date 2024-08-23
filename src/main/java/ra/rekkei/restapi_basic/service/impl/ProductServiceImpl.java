package ra.rekkei.restapi_basic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ra.rekkei.restapi_basic.model.dto.request.ProductRequest;
import ra.rekkei.restapi_basic.model.entity.Category;
import ra.rekkei.restapi_basic.model.entity.Product;
import ra.rekkei.restapi_basic.repository.ProductRepository;
import ra.rekkei.restapi_basic.service.CategoryService;
import ra.rekkei.restapi_basic.service.ProductService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Integer proId) {
        return productRepository.findById(proId).orElseThrow(()->new NoSuchElementException("Khong ton tai prduct co ma: "+proId));
    }

    @Override
    public Product insertProduct(ProductRequest p) {
        Product prod = Product.builder()
                .yearMaking(p.getYearMaking())
                .producer(p.getProducer())
                .expireDate(p.getExpireDate())
                .proName(p.getProName())
                .build();
        Category category = categoryService.getCategoryById(p.getCateId());
        prod.setCate(category);
        return productRepository.save(prod);
    }

    @Override
    public Product upateProduct(Integer proId, ProductRequest p) {
        productRepository.findById(proId).orElseThrow(()->new NoSuchElementException("Khong ton tai prduct co ma: "+proId));
        Product prod = Product.builder()
                .yearMaking(p.getYearMaking())
                .producer(p.getProducer())
                .expireDate(p.getExpireDate())
                .proName(p.getProName())
                .build();
        Category category = categoryService.getCategoryById(p.getCateId());
        prod.setCate(category);
        prod.setProId(proId);
        return productRepository.save(prod);
    }

    @Override
    public void deleteProduct(Integer proId) {
        productRepository.deleteById(proId);
    }

    @Override
    public Page<Product> getProductsWithPaginationAndSorting(String searchName, Integer page, Integer pageSize, String sortBy, String orderBy) {
        Pageable pageable = null;

        if(!sortBy.isEmpty()){
            Sort sort;
            switch (sortBy){
                case "asc":
                    sort = Sort.by(sortBy).ascending();
                    break;
                case "desc":
                    sort = Sort.by(sortBy).descending();
                    break;
                default:
                    sort = Sort.by(sortBy).ascending();
                    //tang dan
            }
            pageable = PageRequest.of(page,pageSize,sort);
        }else{
            pageable = PageRequest.of(page,pageSize);
        }

        return productRepository.findProductsByProNameContainsIgnoreCase(searchName,pageable);
    }
}
