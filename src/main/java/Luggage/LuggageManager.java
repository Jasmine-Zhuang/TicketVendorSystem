package Luggage;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class LuggageManager implements Serializable {

    private HashMap<String, Luggage> idToLuggage = new LinkedHashMap<>();
    private static final long serialVersionUID = 7;

    /**
     *
     * @return  check the eligibility of luggage weight input by user,
     * return 1 if it is smaller than 23kg
     * return 0 if it is between 23kg and 30 kg
     * return -1 if it is greater than 30 kg which is not allowed
     */
    public int checkWeight(int inputWeight){
        if(inputWeight <= 23 && inputWeight >= 0){
            return 1;
        } else if (inputWeight <= 30 && inputWeight > 23) {
            return 0;
        } else {
            return -1;
        }

    }

    /**
     * Add a new Luggage to LuggageManager
     * @param luggageWeight of this luggage
     * @param luggageId of this luggage
     */
    public void generateLuggage(int luggageWeight, String luggageId){
       int weightFlag = checkWeight(luggageWeight);
       if (weightFlag == 1){
           Luggage newLuggage = new Luggage(luggageId, luggageWeight);
           this.idToLuggage.put(luggageId, newLuggage);
       }
    }

    /**
     * A getter method to return the weight of the luggage by it's number
     * @param luggageId A luggage id String
     * @return an integer which is the weight of the luggage
     */
    public int getWeightById(String luggageId){
        return this.idToLuggage.get(luggageId).getLuggageWeight();
    }

}
