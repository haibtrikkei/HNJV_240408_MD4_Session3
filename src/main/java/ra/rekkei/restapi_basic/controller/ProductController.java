package ra.rekkei.restapi_basic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ra.rekkei.restapi_basic.model.dto.request.ProductRequest;
import ra.rekkei.restapi_basic.model.dto.response.DataResponse;
import ra.rekkei.restapi_basic.model.entity.Category;
import ra.rekkei.restapi_basic.model.entity.Product;
import ra.rekkei.restapi_basic.service.CategoryService;
import ra.rekkei.restapi_basic.service.ProductService;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<DataResponse> getAllProducts(){
        return new ResponseEntity<>(new DataResponse(productService.getProducts(), HttpStatus.OK),HttpStatus.OK);
    }

    @GetMapping("/{proId}")
    public ResponseEntity<DataResponse> getById(@PathVariable("proId")Integer proId){
        return new ResponseEntity<>(new DataResponse(productService.getProductById(proId),HttpStatus.OK),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DataResponse> insertProductService(@Validated @RequestBody ProductRequest product){
        return new ResponseEntity<>(new DataResponse(productService.insertProduct(product),HttpStatus.CREATED),HttpStatus.CREATED);
    }

    @PutMapping("/{proId}")
    public ResponseEntity<DataResponse> upateProduct(@PathVariable("proId")Integer proId,@Validated @RequestBody ProductRequest product){
        return new ResponseEntity<>(new DataResponse(productService.upateProduct(proId,product),HttpStatus.OK),HttpStatus.OK);
    }

    @DeleteMapping("/{proId}")
    public ResponseEntity<DataResponse> deleteProduct(@PathVariable("proId")Integer proId){
        productService.deleteProduct(proId);
        return new ResponseEntity<>(new DataResponse("Đã xóa thành công category có mã: "+proId,HttpStatus.NO_CONTENT),HttpStatus.OK);
    }

    @GetMapping("/searchByName")
    public ResponseEntity<DataResponse> searchProductByName(@RequestParam(name = "searchName",defaultValue = "")String searchName,
                                                            @RequestParam(name = "page",defaultValue = "0")Integer page,
                                                            @RequestParam(name = "pageSize",defaultValue = "2")Integer pageSize,
                                                            @RequestParam(name = "sortBy",defaultValue = "")String sortBy,
                                                            @RequestParam(name = "orderBy",defaultValue = "asc")String orderBy){
        return  new ResponseEntity<>(new DataResponse(productService.getProductsWithPaginationAndSorting(searchName,page,pageSize,sortBy,orderBy).getContent(),HttpStatus.OK),HttpStatus.OK);
    }


}
