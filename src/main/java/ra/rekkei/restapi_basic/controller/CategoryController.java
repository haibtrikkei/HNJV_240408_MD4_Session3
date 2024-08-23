package ra.rekkei.restapi_basic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.rekkei.restapi_basic.model.dto.response.DataResponse;
import ra.rekkei.restapi_basic.model.entity.Category;
import ra.rekkei.restapi_basic.service.CategoryService;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<DataResponse> getAllCategories(){
        return new ResponseEntity<>(new DataResponse(categoryService.getCategories(), HttpStatus.OK),HttpStatus.OK);
    }

    @GetMapping("/{cateId}")
    public ResponseEntity<DataResponse> getById(@PathVariable("cateId")String cateId){
        return new ResponseEntity<>(new DataResponse(categoryService.getCategoryById(cateId),HttpStatus.OK),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DataResponse> insertCategory(@RequestBody Category cate){
        return new ResponseEntity<>(new DataResponse(categoryService.insertCategory(cate),HttpStatus.CREATED),HttpStatus.CREATED);
    }

    @PutMapping("/{cateId}")
    public ResponseEntity<DataResponse> upateCategory(@PathVariable("cateId")String cateId, @RequestBody Category cate){
        return new ResponseEntity<>(new DataResponse(categoryService.updateCategory(cateId,cate),HttpStatus.OK),HttpStatus.OK);
    }

    @DeleteMapping("/{cateId}")
    public ResponseEntity<DataResponse> deleteCategory(@PathVariable("cateId")String cateId){
        categoryService.deleteCategory(cateId);
        return new ResponseEntity<>(new DataResponse("Đã xóa thành công category có mã: "+cateId,HttpStatus.NO_CONTENT),HttpStatus.OK);
    }

    @GetMapping("/searchByName/{cateName}")
    public ResponseEntity<DataResponse> searchCategoryByName(@PathVariable("cateName")String cateName){
        return  new ResponseEntity<>(new DataResponse(categoryService.getCategoriesByName(cateName),HttpStatus.OK),HttpStatus.OK);
    }
}
