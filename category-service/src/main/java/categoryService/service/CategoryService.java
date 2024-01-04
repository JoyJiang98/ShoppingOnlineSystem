package categoryService.service;





import categoryService.model.Category;

import java.util.List;


public interface CategoryService {
    Category findOne(Long id);

    List<Category> findByLevelAndName(Integer level, String name);

    Category save(Category category);
}
