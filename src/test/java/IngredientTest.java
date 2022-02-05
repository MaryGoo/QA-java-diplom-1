import org.junit.Test;
import praktikum.Ingredient;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.SAUCE;

public class IngredientTest {
    Ingredient ingredient = new Ingredient(SAUCE, "Что то", 23);

    @Test
    public void getNameIngredientSuccess() {
        assertEquals("Имя ингридиента не верное","Что то", ingredient.getName());
    }

    @Test
    public void getTypeIngredientSuccess() {
        assertEquals("Тип ингридиента не верный",SAUCE, ingredient.getType());
    }

    @Test
    public void getPriseBunSuccess() {
        assertEquals("Цена ингридиента не верная",23, ingredient.getPrice(), 0);
    }
}