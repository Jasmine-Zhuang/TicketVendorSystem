package GUI;

import Flight.FlightManager;

import java.util.ArrayList;
import java.util.Arrays;

public class PickFlightMain {

    PickFlightMain(){
            FlightManager fm = new FlightManager();
            ArrayList<String> dTime = new ArrayList<>(Arrays.asList("2021","12","1","8","50","0"));
            ArrayList<String> aTime = new ArrayList<>(Arrays.asList("2021","12","1","10","45","0"));
            ArrayList<String> seatNumArray = new ArrayList<>(Arrays.asList("1A","1B","2A","2B","3A","3B","4A","4B","5A","5B"));
            fm.AddFlight("CZ311", "Toronto", "Vancouver", dTime, aTime,10, 10, 3600, "10A", seatNumArray);
            new PickRoutesFrame(fm);
        }

    }

