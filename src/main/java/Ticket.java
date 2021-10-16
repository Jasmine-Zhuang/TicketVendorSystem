import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


/*
    An entity class represents each flight ticket, which stores:
        * Flight information(Flight number, Departure city, Arrival city, Departure time, Arrival time,
        Boarding gate, ticket id)
        * Seat information(Seat letter&number, Price for the ticket)
        * Information of passenger(Name of the passenger, Passenger username)

 */
public class Ticket {
    private String flightNumber;
    private String departure_city;
    private String arrival_city;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private String boardingGate;
    private String seat_number;
    private int price;
    private String passenger_name;
    private String passenger_username;
    private String ticket_id;

    /**
     * Construct a Flight Ticket giving it the given flightNumber, departure city, arrival city,
     * departure time, arrival time, boarding gate, seat number, distance traveled, passenger's name and username.
     *
     * @param flightNumber Sting of the flight number of the flight on the ticket.
     * @param d_city       String of the departure city's name.
     * @param a_city       String of the arrival city's name.
     * @param d_time       Departure time in the format of [year,month,day,hour,minute].
     * @param a_time       Arrival time in the format of [year,month,day,hour,minute]
     * @param b_gate       String of the boarding gate(e.g. "C9").
     * @param seat_num     String of the passenger's seat number(e.g. "15C").
     * @param price        Float of the price of the flight.
     * @param p_name       String of passenger's Name.
     * @param p_user       String of passenger's username when the passenger booked the flight.
     */
    public Ticket(String flightNumber, String d_city, String a_city, LocalDateTime d_time,
                  LocalDateTime a_time, String b_gate, String seat_num, int price,
                  String p_name, String p_user) {
        this.flightNumber = flightNumber;
        this.departure_city = d_city;
        this.arrival_city = a_city;
        this.boardingGate = b_gate;
        this.seat_number = seat_num;
        this.price = price;
        this.passenger_name = p_name;
        this.passenger_username = p_user;
        this.ticket_id = flightNumber + "," + seat_num;
        this.arrivalTime = a_time;
        this.departureTime = d_time;
    }

    /**
     * Construct an empty flight Ticket.
     */
    public Ticket() {
    }

    /**
     * A getter method.
     *
     * @return The flight number.
     */
    public String getFlightNumber() {
        return flightNumber;
    }

    /**
     * A getter method.
     *
     * @return The departure city.
     */
    public String getDeparture_city() {
        return departure_city;
    }

    /**
     * A getter method.
     *
     * @return The arrival city.
     */
    public String getArrival_city() {
        return arrival_city;
    }

    /**
     * A getter method.
     *
     * @return The departure time.
     */
    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    /**
     * A getter method.
     *
     * @return The arrival time.
     */
    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    /**
     * A getter method.
     *
     * @return The boarding gate.
     */
    public String getBoardingGate() {
        return boardingGate;
    }

    /**
     * A getter method.
     *
     * @return Passenger's seat number.
     */
    public String getSeat_number() {
        return seat_number;
    }

    /**
     * A getter method.
     *
     * @return The price of the ticket.
     */
    public int getPrice() {
        return price;
    }

    /**
     * A getter method.
     *
     * @return Passenger's name.
     */
    public String getPassenger_name() {
        return passenger_name;
    }

    /**
     * A getter method.
     *
     * @return Passenger's username.
     */
    public String getPassenger_username() {
        return passenger_username;
    }

    /**
     * A getter method.
     *
     * @return Ticket's id.
     */
    public String getTicket_id() {
        return ticket_id;
    }

    /**
     * Override the toString method.
     *
     * @return the Air Ticket with information.
     */
    @Override
    public String toString() {
        DateTimeFormatter FormatObj = DateTimeFormatter.ofPattern("yyyy MMM dd  HH:mm:ss");
        String formattedArrivalTime = arrivalTime.format(FormatObj);
        String formattedDepartureTime = departureTime.format(FormatObj);
        return "--------Air Ticket-------- \n" + "Name of Passenger: " + passenger_name + "\nFlight: " + flightNumber +
                "  Seat: " + seat_number +
                "\nFrom " + departure_city + " to " + arrival_city +
                "\nDeparture time: " + formattedDepartureTime +
                "\nEstimate arrival time: " + formattedArrivalTime +
                "\nBoarding Gate: " + boardingGate +
                "\nPrice: $" + price +
                "\nBoarding time will be one hour before departure." +
                "\nAnd gate closes 20 minutes before departure." +
                "\nHave a nice trip!\n" +
                "-----------------------";
    }


}
