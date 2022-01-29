package Burger;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class GetPriceTest {

    Burger burger;

    @Mock
    Bun bun ;

    @Mock
    Ingredient ingredientOne;

    @Mock
    Ingredient ingredientTwo;

    @Before
    public void setUp(){
        burger = new Burger();
    }

    @Test
    public void getPriceWithOnlyBunsSuccess() {
        burger.setBuns(bun);
        Mockito.when(bun.getPrice()).thenReturn(21F);
        assertEquals(21 * 2, burger.getPrice(), 0);
    }

    @Test
    public void getPriceBunsAndOneIngredientSuccess() {
        burger.setBuns(bun);
        burger.addIngredient(ingredientOne);
        Mockito.when(bun.getPrice()).thenReturn(21F);
        Mockito.when(ingredientOne.getPrice()).thenReturn(45F);
        assertEquals(21 * 2 + 45, burger.getPrice(), 0);
    }

    @Test
    public void getPriceBunsAndTwoIngredientSuccess() {
        burger.setBuns(bun);
        burger.addIngredient(ingredientOne);
        burger.addIngredient(ingredientTwo);
        Mockito.when(bun.getPrice()).thenReturn(21F);
        Mockito.when(ingredientOne.getPrice()).thenReturn(45F);
        Mockito.when(ingredientTwo.getPrice()).thenReturn(33F);
        assertEquals(21 * 2 + 45 + 33, burger.getPrice(), 0);
    }
}