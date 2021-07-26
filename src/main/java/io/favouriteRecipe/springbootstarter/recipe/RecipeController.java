package io.favouriteRecipe.springbootstarter.recipe;

import antlr.collections.List;
import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springbootstarter.course.Course;
import springbootstarter.course.CourseService;

import java.util.List;
import java.util.Optional;

@RestController
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @RequestMapping("/recipes")
    public List<Recipe> getAllRecipes(){
        return recipeService.getAllRecipes();
    }

    @RequestMapping("/recipe/{id}")
    public Optional<Recipe> getRecipe(@PathVariable String id){
        return recipeService.getRecipe(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/recipe")
    public Recipe addRecipe(@RequestBody Recipe recipe){         //It will create an instance of Topic and take all the fields of Topic from request body.
        return recipeService.addRecipe(recipe);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/recipe/{id}")
    public void updateRecipe(@RequestBody Recipe recipe, @PathVariable String id){
        recipeService.updateRecipe(id, recipe);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/recipe/{id}")
    public void deleteRecipe(@PathVariable String id){
        recipeService.deleteRecipe(id);
    }
}