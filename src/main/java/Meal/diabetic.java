package Meal;

import java.io.Serializable;


public class diabetic extends Meal_choice implements Meal_selection, Serializable {

    /**
     * Construct a meal selection diabetic
     */
    public diabetic() {
        super("Diabetic");
    }

}