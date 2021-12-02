package Meal;

import Ticket.Ticket;

import java.io.Serializable;

public class vegan extends Meal_choice implements Meal_selection, Serializable {

    /**
     * Construct a meal selection vegan
     */
    public vegan() {
        super("Meal selection vegan");

    }

}