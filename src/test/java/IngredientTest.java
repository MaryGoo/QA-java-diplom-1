import org.junit.Test;
import praktikum.Ingredient;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.SAUCE;

public class IngredientTest {
    Ingredient ingredient = new Ingredient(SAUCE, "Что то", 23);

    @Test
    public void getNameIngredientSuccess() {
        assertEquals("Что то", ingredient.getName());
    }

    @Test
    public void getTypeIngredientSuccess() {
        assertEquals(SAUCE, ingredient.getType());
    }

    @Test
    public void getPriseBunSuccess() {
        assertEquals(23, ingredient.getPrice(), 0);
    }
}