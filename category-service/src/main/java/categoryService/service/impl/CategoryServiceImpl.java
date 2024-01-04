package categoryService.service.impl;


import api.ResourceNotFoundException;
import categoryService.model.Category;
import categoryService.repository.CategoryRepository;
import categoryService.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository goodRepository;

    @Override
    public Category findOne(Long id) {
        return goodRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @Override
    public List<Category> findByLevelAndName(Integer level, String name) {
        return goodRepository.findByLevelAndName(level, name);
    }

    @Override
    public Category save(Category category) {
        return goodRepository.save(category);
    }
}
