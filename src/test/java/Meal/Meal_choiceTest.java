package Meal;

import Ticket.Ticket;
import org.junit.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;

public class Meal_choiceTest {
    Meal_choice diabetic;
    Ticket ticket;

    @Before
    public void setUp() {
        diabetic = new Meal_choice("diabetic");
        ArrayList<String> dTime = new ArrayList<>(5);
        dTime.add("2021");
        dTime.add("12");
        dTime.add("1");
        dTime.add("8");
        dTime.add("50");
        dTime.add("0");
        //initialize arrival time
        ArrayList<String> aTime = new ArrayList<>(5);
        aTime.add("2021");
        aTime.add("12");
        aTime.add("1");
        aTime.add("10");
        aTime.add("45");
        aTime.add("0");
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
        LocalDateTime departureTime = LocalDateTime.of(dYear, dMonth, dDay, dHour, dMinute);
        LocalDateTime arrivalTime = LocalDateTime.of(aYear, aMonth, aDay, aHour, aMinute);

        ticket = new Ticket("A00100", "Beijing", "Toronto", departureTime, arrivalTime,
                "C4", "15P", 1500, "James", "J52000", "First");
    }

    @Test(timeout = 50)
    public void TestConstructor() {
        assertEquals(diabetic.getName(), "diabetic");
        assertFalse(diabetic.isSelected());
    }

    @Test(timeout = 50)
    public void TestGetName() {
        assertEquals(diabetic.getName(), "diabetic");
    }


    @Test(timeout = 50)
    public void TestIsSelected() {
        assertFalse(diabetic.isSelected());
    }

    @Test(timeout = 50)
    public void TestChoosemeal() {
        ticket.setMeal(diabetic);
        assertEquals(diabetic.choosemeal(ticket).getName(), "diabetic");
    }

    @Test(timeout = 50)
    public void TesttoString() {
        String a =
                "The selected meal is diabetic";
        assertEquals(a, diabetic.toString());

    }
}
