import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {
    Bun bun = new Bun("Самая вкусная" , 45);

    @Test
    public void getNameBunSuccess(){
        assertEquals( "Самая вкусная", bun.getName());
    }

    @Test
    public void getPriseBunSuccess(){
        assertEquals(45,bun.getPrice(), 0);
    }
}