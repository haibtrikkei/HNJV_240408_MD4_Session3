package ra.rekkei.restapi_basic.service;

import ra.rekkei.restapi_basic.model.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getCategories();
    Category getCategoryById(String cateId);
    Category insertCategory(Category cate);
    Category updateCategory(String cateId, Category cate);
    void deleteCategory(String cateId);
    List<Category> getCategoriesByName(String cateName);
}
