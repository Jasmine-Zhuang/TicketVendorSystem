package Meal;

import Ticket.Ticket;

import java.io.Serializable;

public class Meal_choice implements Meal_selection, Serializable {
    private boolean isSelected;
    private final String name;

    /**
     * Construct a meal choice
     */
    public Meal_choice(String name) {
        this.name = name;
        this.isSelected = false;
    }

    /**
     * A getter method.
     *
     * @return name of the meal
     */
    public String getName() {
        return this.name;
    }


    /**
     * A getter method.
     *
     * @return true if the meal is selected, false otherwise.
     */
    public boolean isSelected() {
        return this.isSelected;
    }

    /**
     * A setter method.
     * set true if meal is selected, false otherwise.
     */
    public void setSelected() {
        this.isSelected = true;
    }

    /**
     * Add this meal for the given ticket.
     * @param ticket Ticket
     */
    public Meal_choice choosemeal(Ticket ticket) {
        if (this.isSelected){
            ticket.setMeal(this);
            return this;
        }
        return null;
    }

    @Override
    public String toString() {
        return "The selected meal is " + this.getName();
    }

}
