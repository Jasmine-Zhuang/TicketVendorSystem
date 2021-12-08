package Ticket;

import Customer.Customer;
import Flight.Flight;
import Ticket.Ticket;
import org.junit.*;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class PriceTest {
    private PriceCalculator p;
    Flight f;
    Customer cus_0;
    Customer cus_1;
    Customer cus_2;
    Customer cus_3;
    Ticket t_1;
    Ticket t_2;
    Ticket t_3;
    Ticket t_4;

    @Before
    public void setUp(){
        //set up priceCalculator
        p = new PriceCalculator();

        //set up customer info
        String new_username = "Happy";
        String new_password = "1111";
        String new_name = "Abc";
        //customer 0 has no membership.
        cus_0 = new Customer(new_username,new_password,new_name);
        //customer 1 has membership with level 1
        cus_1 = new Customer(new_username,new_password,new_name);
        cus_1.changeMembership();
        //customer 2 has membership with level 2
        cus_2 = new Customer(new_username,new_password,new_name);
        cus_2.changeMembership();
        cus_2.incrMileage(1500);
        cus_2.changeMembershiplevel();
        //customer 3 has membership with level 3
        cus_3 = new Customer(new_username,new_password,new_name);
        cus_3.changeMembership();
        cus_3.incrMileage(6000);
        cus_3.changeMembershiplevel();

        //set up flight info
        ArrayList<String> dTime = new ArrayList<>(Arrays.asList("2021","12","1","8","50","0"));
        ArrayList<String> aTime = new ArrayList<>(Arrays.asList("2021","12","1","10","45","0"));
        ArrayList<String> seatNumArray = new ArrayList<>(Arrays.asList("1A","1B","2A","2B","3A","3B","4A","4B","5A","5B"));
        f = new Flight("CZ311", "Toronto", "Vancouver",dTime,aTime,
                10, 10, 1000,"10A", seatNumArray);

        //set up Ticket info
        ArrayList<String> dTime_2 = new ArrayList<>(Arrays.asList("2022","12","1","8","50","0"));
        int dYear = Integer.parseInt(dTime.get(0));
        int dMonth = Integer.parseInt(dTime.get(1));
        int dDay = Integer.parseInt(dTime.get(2));
        int dHour = Integer.parseInt(dTime.get(3));
        int dMinute = Integer.parseInt(dTime.get(4));
        int aYear = Integer.parseInt(aTime.get(0));
        int aMonth = Integer.parseInt(aTime.get(1));
        int aDay = Integer.parseInt(aTime.get(2));
        int aHour = Integer.parseInt(aTime.get(3));
        int aMinute = Integer.parseInt(aTime.get(4));
        LocalDateTime departureTime = LocalDateTime.of(dYear,dMonth,dDay,dHour,dMinute);
        int dYear2 = Integer.parseInt(dTime_2.get(0));
        int dMonth2 = Integer.parseInt(dTime_2.get(1));
        int dDay2 = Integer.parseInt(dTime_2.get(2));
        int dHour2 = Integer.parseInt(dTime_2.get(3));
        int dMinute2 = Integer.parseInt(dTime_2.get(4));
        LocalDateTime arrivalTime =  LocalDateTime.of(aYear,aMonth,aDay,aHour,aMinute);
        LocalDateTime d_2 = LocalDateTime.of(dYear2,dMonth2,dDay2,dHour2,dMinute2);
        ArrayList<String> dTime_3 = new ArrayList<>(Arrays.asList("2022","1","1","8","50","0"));
        ArrayList<String> dTime_4 = new ArrayList<>(Arrays.asList("2021","11","1","8","50","0"));
        int dYear3 = Integer.parseInt(dTime_3.get(0));
        int dMonth3 = Integer.parseInt(dTime_3.get(1));
        int dDay3 = Integer.parseInt(dTime_3.get(2));
        int dHour3 = Integer.parseInt(dTime_3.get(3));
        int dMinute3 = Integer.parseInt(dTime_3.get(4));
        int dYear4 = Integer.parseInt(dTime_4.get(0));
        int dMonth4 = Integer.parseInt(dTime_4.get(1));
        int dDay4 = Integer.parseInt(dTime_4.get(2));
        int dHour4 = Integer.parseInt(dTime_4.get(3));
        int dMinute4 = Integer.parseInt(dTime_4.get(4));
        LocalDateTime d_3 = LocalDateTime.of(dYear3,dMonth3,dDay3,dHour3,dMinute3);
        LocalDateTime d_4 = LocalDateTime.of(dYear4,dMonth4,dDay4,dHour4,dMinute4);
        t_1 = new Ticket("A00100", "Beijing", "Toronto", departureTime, arrivalTime,
                "C4", "15P", 1500, "James", "J52000", "First");
        t_2 = new Ticket("A00100", "Beijing", "Toronto", d_2, arrivalTime,
                "C4", "15P", 1500, "James", "J52000", "First");
        t_3 = new Ticket("A00100", "Beijing", "Toronto", d_3, arrivalTime,
                "C4", "15P", 1500, "James", "J52000", "First");
        t_4 = new Ticket("A00100", "Beijing", "Toronto", d_4, arrivalTime,
                "C4", "15P", 1500, "James", "J52000", "First");
    }
    @Test(timeout = 500)
    public void TestCalculatePrice(){
        //set up Class type
        String Eco = "Economy";
        String Bus = "Business";
        String Fir = "First";
        //Economy class test:
        assertEquals(400, p.calculatePrice(f, cus_0, Eco));
        //Business class test:
        assertEquals(800, p.calculatePrice(f, cus_0, Bus));
        //First class test:
        assertEquals(1200, p.calculatePrice(f, cus_0, Fir));
        //Membership level 1 Test:
        assertEquals(380, p.calculatePrice(f, cus_1, Eco));
        assertEquals(760, p.calculatePrice(f, cus_1, Bus));
        assertEquals(1140, p.calculatePrice(f, cus_1, Fir));
        //Membership level 2 Test:
        assertEquals(360, p.calculatePrice(f, cus_2, Eco));
        assertEquals(720, p.calculatePrice(f, cus_2, Bus));
        assertEquals(1080, p.calculatePrice(f, cus_2, Fir));
        //Membership level 3 Test:
        assertEquals(320, p.calculatePrice(f, cus_3, Eco));
        assertEquals(640, p.calculatePrice(f, cus_3, Bus));
        assertEquals(960, p.calculatePrice(f, cus_3, Fir));
    }

    @Test
    public void TestPenalty(){
        assertEquals(150, p.penaltyPrice(t_1));
        assertEquals(0, p.penaltyPrice(t_2));
        assertEquals(75, p.penaltyPrice(t_3));
        assertEquals(150, p.penaltyPrice(t_4));
    }
    @Test
    public void TestLuggagePenalty() {
        assertEquals(0, p.luggagePenalty(22, t_1));
        assertEquals(45, p.luggagePenalty(25, t_1));
        assertEquals(157, p.luggagePenalty(30, t_1));
        assertEquals(-1, p.luggagePenalty(35, t_1));
    }
}