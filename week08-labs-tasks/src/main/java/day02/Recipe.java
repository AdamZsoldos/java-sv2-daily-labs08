package day02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Recipe {

    private final String title;
    private final List<String> ingredients;
    private final String description;

    public Recipe(String title) {
        this(title, "N/A");
    }

    public Recipe(String title, String description) {
        this.title = title;
        this.ingredients = new ArrayList<>();
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public String getDescription() {
        return description;
    }

    public void addIngredients(String... ingredients) {
        if (ingredients.length < 1) {
            throw new IllegalArgumentException("At least one ingredient must be added.");
        }
        Collections.addAll(this.ingredients, ingredients);
    }
}
