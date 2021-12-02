package Luggage;

import java.io.Serializable;

public class Luggage implements Serializable {

    private int luggageWeight;
    private String luggageId;

    /**Construct Luggage. Luggage giving the total weight,
     * @param luggageNumber luggage number of this flight
     * @param luggageWeight the weight of this luggage
     */
    public Luggage(String luggageNumber, int luggageWeight){
        this.luggageId = luggageNumber;
        this.luggageWeight = luggageWeight;
    }

    /**
     * Construct empty luggage
     */
    public Luggage(){}

    /**
     * Getter method to get luggage weight
     */
    public int getLuggageWeight(){
        return luggageWeight;
    }

    /**
     * Getter method to get luggage number
     */
    public String getLuggageId(){
        return luggageId;
    }

    public String toString(){
        return luggageId + ": " + luggageWeight + "; ";
    }
}