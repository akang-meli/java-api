package edu.tallerjava.repositorios;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.tallerjava.modelo.Category;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

// TODO: This class should implement DTO methods, not BO.

@Repository
public class CategoryAPIRepositoryImpl implements CategoryAPIRepository {
    private String url = "https://api.mercadolibre.com/sites/MLA/categories";

    public Category save(Category category) {
        return null;
    }

    public Optional<Category> findById(Long id) {
        return findAll().stream().findAny();
//        return restTemplate.getForObject(url + new Long(id), Category.class);
    }

    public List<Category> findAll() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, List.class);
    }
}
