package Meal;

import java.io.Serializable;

import Ticket.Ticket;


public class regular_meal extends Meal_choice implements Meal_selection, Serializable {
    /**
     * Construct a meal selection vegan
     */
    public regular_meal() {
        super("Regular Meal");

    }

}