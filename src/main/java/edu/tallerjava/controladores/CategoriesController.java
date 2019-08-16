package edu.tallerjava.controladores;

import edu.tallerjava.modelo.Category;
import edu.tallerjava.servicios.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CategoriesController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping(path="/categories")
    public ResponseEntity<List<Category>> list() {
        return new ResponseEntity<>(categoryService.findAll(), HttpStatus.OK);
    }

    @GetMapping(path="/categories/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable Long id) {
        System.out.println(id);
        Optional<Category> optional = categoryService.findById(id);
        if (optional.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(optional.get(), HttpStatus.OK);
    }

    @PostMapping(path="/categories")
    public ResponseEntity<Category> createCategory(@RequestBody Category category){
        return new ResponseEntity<>(categoryService.save(category), HttpStatus.OK);
    }
}
