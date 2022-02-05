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
public class BurgerTest {

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
        assertEquals("Цена для бургера из булочек рассчитывается не верно", 21 * 2, burger.getPrice(), 0);
    }

    @Test
    public void getPriceBunsAndOneIngredientSuccess() {
        burger.setBuns(bun);
        burger.addIngredient(ingredientOne);
        Mockito.when(bun.getPrice()).thenReturn(21F);
        Mockito.when(ingredientOne.getPrice()).thenReturn(45F);
        assertEquals("Цена для бургера из булочек и одного ингридиента рассчитывается не верно", 21 * 2 + 45, burger.getPrice(), 0);
    }

    @Test
    public void getPriceBunsAndTwoIngredientSuccess() {
        burger.setBuns(bun);
        burger.addIngredient(ingredientOne);
        burger.addIngredient(ingredientTwo);
        Mockito.when(bun.getPrice()).thenReturn(21F);
        Mockito.when(ingredientOne.getPrice()).thenReturn(45F);
        Mockito.when(ingredientTwo.getPrice()).thenReturn(33F);
        assertEquals("Цена для бургера из булочек и двух ингридиентов рассчитывается не верно",21 * 2 + 45 + 33, burger.getPrice(), 0);
    }

    @Test
    public void getReceiptBunsAndTwoIngredientsSuccess() {
        burger.setBuns(bun);
        burger.addIngredient(ingredientOne);
        Mockito.when(bun.getName()).thenReturn("Сежая булочка");
        Mockito.when(ingredientOne.getType()).thenReturn(FILLING);
        Mockito.when(ingredientOne.getName()).thenReturn("ОгурчиК");
        Mockito.when(burger.getPrice()).thenReturn(500f);
        String actualReceipt  = burger.getReceipt();
        StringBuilder expextedReceipt = new StringBuilder(String.format("(==== %s ====)%n", "Сежая булочка"));
        expextedReceipt.append(String.format("= %s %s =%n", "filling","ОгурчиК"));
        expextedReceipt.append(String.format("(==== %s ====)%n", "Сежая булочка"));
        expextedReceipt.append(String.format("%nPrice: %f%n", 500.0));

        assertEquals("Рецепт не совпадает!", expextedReceipt.toString(),actualReceipt);
    }

    @Test
    public  void setBunsSuccess(){
        burger.setBuns(bun);
        assertEquals("Булочка не добавлена в состав бургера", bun, burger.bun);
    }

    @Test
    public  void addOneIngredientSuccess(){
        burger.addIngredient(ingredientOne);
        burger.addIngredient(ingredientOne);
        assertEquals( "Ингридиенты не добавлены в состав бургера", 2, burger.ingredients.size());
    }
}