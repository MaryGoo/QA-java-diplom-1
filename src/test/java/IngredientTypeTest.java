import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.*;

@RunWith(Parameterized.class)
public class IngredientTypeTest {
    IngredientType ingredientType;

    @Parameterized.Parameters
    public static Object[][] getSexData() {
        return new Object[][] {
                { SAUCE},
                { FILLING},
        };
    }

    public IngredientTypeTest(IngredientType ingredientType){
        this.ingredientType=ingredientType;
    }

    @Test
    public void getTypeIngredientSuccess() {
        Ingredient ingredient = new Ingredient(ingredientType, "Что то", 23);
        assertEquals(ingredientType, ingredient.getType());
    }
}