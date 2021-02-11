package pt.donors.club.donors_club.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.donors.club.donors_club.models.Category;
import pt.donors.club.donors_club.models.Subcategory;
import pt.donors.club.donors_club.repositories.CategoryRepository;
import pt.donors.club.donors_club.repositories.SubcategoryRepository;

@RestController
@RequestMapping(path = "/api/categories")
public class CategoryController {
    private Logger logger = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private SubcategoryRepository subCategoryRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Category> getCategories() {
        logger.info("Sending all categories");

        return categoryRepository.findAll();
    }

    @GetMapping(path = "/{id}/subcategories", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Subcategory> getSubCategories(@PathVariable int id) {
        logger.info("Sending all subcategories by category id " + id);
        
        return subCategoryRepository.getSubCategoriesByCategory(id);
    }
}
