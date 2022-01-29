package Burger;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class SetBunsAndAddIngredientTest {
    Burger burger;

    @Before
    public void setUp(){
        burger = new Burger();
    }

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Test
    public  void setBunsSuccess(){
        burger.setBuns(bun);
        assertEquals( bun, burger.bun);
    }

    @Test
    public  void addOneIngredientSuccess(){
        burger.addIngredient(ingredient);
        assertEquals( 1, burger.ingredients.size());
        burger.addIngredient(ingredient);
        assertEquals( 2, burger.ingredients.size());
    }

    @Test
    public  void addTwoIngredientSuccess(){
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        assertEquals( 2, burger.ingredients.size());
    }
}