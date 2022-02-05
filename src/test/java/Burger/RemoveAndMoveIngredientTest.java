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
        burger.removeIngredient(0);
        assertEquals("Количество ингридиентов в бургере не равно 1", 1, burger.ingredients.size());
        assertEquals("В бургере осталсе не удаленным не тот ингридиент", ingredientTwo.name,burger.ingredients.get(0).name);
    }

    @Test
    public  void removeAllIngredientSuccess(){
        burger.removeIngredient(1);
        burger.removeIngredient(0);
        assertEquals( "В бургере удалены не все ингридиенты", burger.ingredients.size());
    }

    @Test
    public  void moveIngredientSuccess(){
        burger.moveIngredient(0,1);
        assertEquals("Ингридиенты остались на прежних местах",ingredient.name,burger.ingredients.get(1).name);
        assertEquals("Ингридиенты остались на прежних местах", ingredientTwo.name,burger.ingredients.get(0).name);
    }
}