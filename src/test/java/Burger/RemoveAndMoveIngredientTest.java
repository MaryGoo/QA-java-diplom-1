package Burger;

import org.junit.Before;
import org.junit.Test;
import praktikum.Burger;
import praktikum.Ingredient;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.SAUCE;

public class RemoveAndMoveIngredientTest {
    Burger burger;
    Ingredient ingredient;
    Ingredient ingredientTwo;

    @Before
    public void setUp(){
        burger = new Burger();
        ingredient = new Ingredient(SAUCE, "Лук" , 22);
        ingredientTwo = new Ingredient(SAUCE, "Огурчик" , 27);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredientTwo);
    }

    @Test
    public  void removeOneIngredientSuccess(){
        assertEquals( 2, burger.ingredients.size());
        burger.removeIngredient(0);
        assertEquals( 1, burger.ingredients.size());
        assertEquals(ingredientTwo.name,burger.ingredients.get(0).name);
    }

    @Test
    public  void removeAllIngredientSuccess(){
        assertEquals( 2, burger.ingredients.size());
        burger.removeIngredient(1);
        burger.removeIngredient(0);
        assertEquals( 0, burger.ingredients.size());
    }

    @Test
    public  void moveIngredientSuccess(){
        assertEquals(ingredient.name,burger.ingredients.get(0).name);
        assertEquals(ingredientTwo.name,burger.ingredients.get(1).name);
        burger.moveIngredient(0,1);
        assertEquals(ingredient.name,burger.ingredients.get(1).name);
        assertEquals(ingredientTwo.name,burger.ingredients.get(0).name);
    }
}