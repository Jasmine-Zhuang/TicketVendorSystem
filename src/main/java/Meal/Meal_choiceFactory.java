package Meal;

import java.io.Serializable;

public class Meal_choiceFactory implements Serializable {
    public Meal_choiceFactory() {
    }
    /**
     * Get an object of type Meal_choice
     * @param mealType type of meal to be selected
     */
    public Meal_selection getmeal(String mealType){
        if ("Diabetic".equals(mealType)) {
            return new diabetic();
        } else if ("Gluten Intolerance".equals(mealType)) {
            return new gluten_intolerance();
        } else if ("Vegan".equals(mealType)) {
            return new vegan();
        } else if ("Low calories".equals(mealType)) {
            return new low_calories();
        }
        return null;
    }
}
