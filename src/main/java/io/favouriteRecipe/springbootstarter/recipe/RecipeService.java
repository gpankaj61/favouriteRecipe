package io.favouriteRecipe.springbootstarter.recipe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    public List<Recipe> getAllRecipes(){
        List<Recipe> topics = new ArrayList<>();
        recipeRepository.findAll().forEach(recipes::add);
        return recipes;
    }

    public Optional<Recipe> getRecipe(String id){
        return recipeRepository.findById(id);
    }

    public Recipe addRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    public void updateRecipe(String id, Recipe recipe) {
        recipeRepository.save(recipe);
    }

    public void deleteRecipe(String id) {
        Optional<Recipe> recipe =  recipeRepository.findById(id);
        if(recipe.isPresent()) {
            recipeRepository.delete(recipe.get());
        }
    }
}
