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
import static praktikum.IngredientType.FILLING;

@RunWith(MockitoJUnitRunner.class)
public class GetReceiptTest {

    Burger burger;

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredientOne;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void getReceiptOnlyBunsSuccess() {
        burger.setBuns(bun);
        Mockito.when(bun.getName()).thenReturn("Сежая булочка");
        Mockito.when(burger.getPrice()).thenReturn(42F);
        System.out.println(burger.getReceipt());
    }

    @Test
    public void getReceiptBunsAndOneIngredientSuccess() {
        burger.setBuns(bun);
        burger.addIngredient(ingredientOne);
        Mockito.when(bun.getName()).thenReturn("Сежая булочка");
        Mockito.when(ingredientOne.getType()).thenReturn(FILLING);
        Mockito.when(ingredientOne.getName()).thenReturn("ОгурчиК");
        Mockito.when(burger.getPrice()).thenReturn(42F);
        assertEquals("(==== Сежая булочка ====)\n= filling ОгурчиК =\n(==== Сежая булочка ====)\n\nPrice: 42,000000\n", burger.getReceipt());
    }
}