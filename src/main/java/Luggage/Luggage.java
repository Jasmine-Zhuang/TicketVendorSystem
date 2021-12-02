package Luggage;

import java.io.Serializable;

public class Luggage implements Serializable {

    private int luggageWeight;
    private String luggageNum;

    /**Construct a Luggage.Luggage giving the total weight,
     * @param luggageNumber luggage number of this flight
     * @param luggageWeight the weight of this luggage
     */
    public Luggage(String luggageNumber, int luggageWeight){
        this.luggageNum = luggageNumber;
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
    public String getLuggageNum(){
        return luggageNum;
    }

    public String toString(){
        return Integer.toString(luggageWeight);
    }
}