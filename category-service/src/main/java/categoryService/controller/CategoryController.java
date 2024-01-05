package categoryService.controller;


import api.ResourceNotFoundException;
import categoryService.model.Category;
import categoryService.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/category")
public class CategoryController {
    private final Logger logger = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private CategoryService categoryService;

    private void logServiceInstance() {
        List<ServiceInstance> instances = discoveryClient.getInstances("category-service");
        if (!instances.isEmpty()) {
            ServiceInstance instance = instances.get(0); // Assuming you want the first instance
            logger.info("host:" + instance.getHost() + ", serviceId:" + instance.getServiceId());
        }
    }


    @CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public Category get(@PathVariable Long id) {
        logServiceInstance();
        Category category = categoryService.findOne(id);
        logger.info("/category, category id: " + category.getId() + ", category name: " + category.getName());
        return category;
    }



    @CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Category> save(@RequestBody Category category, UriComponentsBuilder ucb) {
        logServiceInstance();
        Category saved = categoryService.save(category);
        logger.info("/category, category id:" + saved.getId() + ", category name:" + saved.getName());

        HttpHeaders headers = new HttpHeaders();
        URI locationUri = ucb.path("/category/")
                .path(String.valueOf(saved.getId()))
                .build()
                .toUri();
        headers.setLocation(locationUri);

        return new ResponseEntity<>(saved, headers, HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public List<Category> categories(@RequestParam(value = "level", defaultValue = "0") Integer level, @RequestParam(value = "name", defaultValue = "top") String name) {
        logServiceInstance();
        List<Category> categories = categoryService.findByLevelAndName(level, name);
        logger.info("/category, category level: " + level + ", category name: " + name);
        return categories;
    }

}
