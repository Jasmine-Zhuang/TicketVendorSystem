package Ticket;/*
Calculate the price of the flight ticket.
 */
import Customer.Customer;
import Flight.Flight;

import java.time.LocalDateTime;
public class PriceCalculator {
    public PriceCalculator(){}
    /**
     * Calculate the price of a ticket.
     * @param f The flight of the price we need to calculate.
     * @param c The customer who want to buy the ticket.
     * @param ClassType The class type that the customer want to have.
     * @return The price of the ticket.
     */
    public int calculatePrice(Flight f, Customer c, String ClassType){
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

    /**
     * Calculate the time penalty the ticket owner will have.
     * @param ticket The ticket that the ticket owner will have penalty due to refunding/exchanging.
     * @return The penalty that the ticket owner will have.
     */
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

    /**
     * Calculate the penalty of overweight luggage.
     * @param weight The weight of the luggage.
     * @param ticket The Ticket of luggage-owner.
     * @return The penalty of
     */
    public int luggagePenalty(int weight, Ticket ticket){
        int ticket_price = ticket.getPrice();
        if(weight <= 23 && weight >=0){
            return 0;
        }else if(weight <= 30 && weight >= 23){
            return (int) ((weight-23) * ticket_price * 0.015);
        }
        return -1;

    }


    /**
     * Calculate the penalty if redeem point < 0 after refunding/exchanging ticket according to its rate.
     * @param c The customer who will have the penalty.
     * @return The penalty price.
     */
    public int pointPenalty(Customer c){
        int point = c.getRedeem_points();
        if(point >= 0){
            return 0;
        }
        return - (point /40);
    }
}