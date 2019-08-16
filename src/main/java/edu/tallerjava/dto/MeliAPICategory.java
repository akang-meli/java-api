package edu.tallerjava.dto;

import edu.tallerjava.modelo.Category;

public class MeliAPICategory {
    private String id;
    private String name;

    public MeliAPICategory(Category category){
        id = category.getId().toString();
        name = category.getNombre();
    }

    public Category toCategory() {
        Category category = new Category();
        category.setId(Long.parseLong(id.substring(3)));
        category.setNombre(name);
        return category;
    }
}
