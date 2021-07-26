package io.favouriteRecipe.springbootstarter.recipe;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Recipe {

    @Id
    private String id;

    private String name;
    private LocalDateTime created;
    private boolean vegan;
    private int servings;
    private List<String> ingredients;
    private String instructions;


    public Recipe() {
    }

}
