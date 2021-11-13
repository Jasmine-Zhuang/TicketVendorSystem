/*
Calculate the price of the flight ticket.
 */
import Customer.Customer;
import Flight.Flight;
import Ticket.Ticket;

import java.time.LocalDateTime;
public class PriceCalculator {
    public PriceCalculator(){}
    public int CalculatePrice(Flight f, Customer c, String ClassType){
        int distance = f.getDistanceTraveled();
        int price;
        if(ClassType.equals("Economy")){
            price = (int) (200 + 0.2 * distance);
        }else if(ClassType.equals("Business")){
            price = (int) (200 + 0.6 * distance);
        }else{
            price = 200 + distance;
        }
        if(c.checkMembership()){
            if(c.checkMembershiplevel()==1){
                price = (int) (price * (1-0.05));
            }else if(c.checkMembershiplevel()==2){
                price = (int) (price * (1-0.1));
            }else{
                price = (int) (price * (1-0.2));
            }
        }
        return price;
    }
    public int penaltyPrice(Ticket ticket) {
        String now_t = LocalDateTime.now().toString();
        String t = ticket.getDepartureTime().toLocalDate().toString();
        String[] now = now_t.split("-");
        String[] t_t = t.split("-");
        int now_y = Integer.parseInt(now[0]);
        int now_m = Integer.parseInt(now[1]);
        int t_y = Integer.parseInt(t_t[0]);
        int t_m = Integer.parseInt(t_t[1]);
        if(t_y>now_y){
            if(t_m>=now_m){
                return 0;
            }else{
                if(12-now_m+t_m>2){
                    return 0;
                }else if (12-now_m+t_m<=2&&12-now_m+t_m>=1){
                    return 75;
                }else{
                    return 150;
                }
            }
        }
        if (t_y==now_y&&t_m>now_m){
            if(t_m-now_m>2){
                return 0;
            }else if(t_m-now_m>=1){
                return 75;
            }else{
                return 150;
            }
        }
        return 150;
    }

    public static void main(String[] args) {
        String t = LocalDateTime.now().toLocalDate().toString();
        System.out.println(t);

    }
}