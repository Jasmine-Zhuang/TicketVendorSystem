package Meal;

import Meal.*;
import org.junit.Test;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class Meal_choiceFactoryTest {

    Meal_choiceFactory mealFactory = new Meal_choiceFactory();

    @Test(timeout = 50)
    public void TestGetmeal() {
        assertTrue(mealFactory.getmeal("Diabetic") instanceof diabetic);
        assertTrue(mealFactory.getmeal("Gluten Intolerance") instanceof gluten_intolerance);
        assertTrue(mealFactory.getmeal("Vegan") instanceof vegan);
        assertTrue(mealFactory.getmeal("Low calories") instanceof low_calories);
        assertNull(mealFactory.getmeal(" "));
    }
}
