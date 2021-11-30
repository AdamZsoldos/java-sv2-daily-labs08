package day02;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RecipeTest {

    Recipe recipe = new Recipe("Scrambled Eggs", "Put the eggs over the flame, then stir.");

    @Test
    void testCreate() {
        assertEquals("Scrambled Eggs", recipe.getTitle());
        assertEquals("Put the eggs over the flame, then stir.", recipe.getDescription());
        assertEquals(new ArrayList<>(), recipe.getIngredients());
    }

    @Test
    void testCreateByTitle() {
        Recipe recipe1 = new Recipe("Scrambled Eggs");
        assertEquals("Scrambled Eggs", recipe1.getTitle());
        assertEquals("N/A", recipe1.getDescription());
        assertEquals(new ArrayList<>(), recipe1.getIngredients());
    }

    @Test
    void testAddIngredientsNone() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> recipe.addIngredients());
        assertEquals("At least one ingredient must be added.", e.getMessage());
    }

    @Test
    void testAddIngredientsSingle() {
        recipe.addIngredients("2 eggs");
        assertEquals(1, recipe.getIngredients().size());
        assertEquals("2 eggs", recipe.getIngredients().get(0));
    }

    @Test
    void testAddIngredientsMultiple() {
        recipe.addIngredients("2 eggs", "Salt", "Pepper");
        assertEquals(3, recipe.getIngredients().size());
        assertEquals("2 eggs", recipe.getIngredients().get(0));
        assertEquals("Salt", recipe.getIngredients().get(1));
        assertEquals("Pepper", recipe.getIngredients().get(2));
    }
}
