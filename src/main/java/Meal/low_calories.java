package Meal;

import java.io.Serializable;

public class low_calories extends Meal_choice implements Meal_selection, Serializable {

    /**
     * Construct a meal selection low calories
     */
    public low_calories() {
        super("Low Calories");

    }
}