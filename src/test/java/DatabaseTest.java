import org.junit.Test;
import praktikum.Database;

import static junit.framework.TestCase.assertFalse;


public class DatabaseTest {

    Database database = new Database();

    @Test
    public void availableBuns() {
        assertFalse("List of buns should contain some data", database.availableBuns().isEmpty());
    }

    @Test
    public void availableIngredients() {
        assertFalse("List of buns should contain some data", database.availableIngredients().isEmpty());
    }
}