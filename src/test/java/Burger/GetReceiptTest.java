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
    Ingredient ingredient;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void getReceiptBunsAndTwoIngredientsSuccess() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getName()).thenReturn("Сежая булочка");
        Mockito.when(ingredient.getType()).thenReturn(FILLING);
        Mockito.when(ingredient.getName()).thenReturn("ОгурчиК");
        Mockito.when(burger.getPrice()).thenReturn(500f);
        String actualReceipt  = burger.getReceipt();
        StringBuilder expextedReceipt = new StringBuilder(String.format("(==== %s ====)%n", "Сежая булочка"));
        expextedReceipt.append(String.format("= %s %s =%n", "filling","ОгурчиК"));
        expextedReceipt.append(String.format("(==== %s ====)%n", "Сежая булочка"));
        expextedReceipt.append(String.format("%nPrice: %f%n", 500.0));
        //Assert
        assertEquals("Рецепт не совпадает!", expextedReceipt.toString(),actualReceipt);
    }
}