package edu.tallerjava.repositorios;


import edu.tallerjava.dto.MeliAPICategory;
import edu.tallerjava.modelo.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryAPIRepository {

    Category save(Category category);
    Optional<Category> findById(Long id);
    List<Category> findAll();
}
