## U-ticket Design Document

### Design Decisions
We added an important functionality, the U-Store, for customers to redeem items with their reward points and the item redeemed will be stored at customer’s purchase history. 
We have added a new class, PriceCalculator, that conducts the price calculation task. 
We have added a new class, PurchaseHistory and its use case class PHManager. PurchaseHistory will store tickets purchased and redeemed rewards items. Before, these were stored in CustomerManager, but now we have decided to separate them out so that CustomerManager is only in charge of managing customers’ information. 
Also, we have created 3 subclasses of flight (differ by seatArray), smallFlight, mediumFlight and largeFlight. We added a buildSeat method in the Flight class to generate different seat arrays for different flight types. There are also new getSeatByflightNum and getSeatByflightNumAndClass methods implemented in flight managers.

### Clean Architecture
In our program, the dependency rule is followed, i.e. dependencies only point inward, and the inner layers are designed not to have any knowledge of the outer layers, because all entity classes are only monitored by their corresponding use case classes, and the controller monitors GUI and manager classes. 
We will demonstrate this by showing the CRC and scenario walkthrough.

### SOLID Principles
* Single Responsibility \
We ensured that all classes have single responsibility by keeping the responsibility of each class to the minimum,  so that a class will only have one reason to change, and we could test the entire class more thoroughly, which also allowed us to focus on parts that need to be addressed more.
* Open for extension and closed for modification \
Differ from phase0, we want to add new features to flight(i.e., restrict the number of available seats and assign seat type for each seat). We chose not to modify the original flight, but use inheritance by adding 3 subclasses of flight. Then, we need to modify only the 3 subclasses of flight, to reach our goal of extending features of flight.
* Liskov substitution \
For all child classes of a parent class, we make sure that those subclasses won’t override methods from the parent class.
* Interface Segregation principle \
We have just one interface in our program, the Redeemable interface which is part of the simple factory design pattern used. This interface only has a method named redeemItem which redeems a rewards item and returns it. Also, all classes implementing this interface are rewards items, so they are related and share the feature of being able to be redeemed.
* Dependency Inversion
Currently, we have not had a chance to adopt this aspect into our project, thus no designs have been implemented to violate this principle.

### Packaging Strategies
We used the strategy of package-by-component to organize the code, that is, we managed to place all items that are closely related to a component into the same package. The reason we decided to use this strategy is because once we have an idea of what the desired file is roughly about, we can easily find it. For instance, if we wished to access the file that is related to ticket sales, it is natural to navigate to the folder Ticket, and the file TicketManager is indeed in charge of ticket sales.
* Flight and its 3 subclasses, and FlightManager are stored in the Flight package.
* RewardsItem, Redeemable, RewardsItemFactory and all subclasses of RewardsItem are stored in the UStore package.
* Customer, CustomerManager, Membership, LoginSystem, PurchaseHistory and PHManager are stored in the Customer package.
* Ticket, TicketManager, and PriceCalculator（it uses a flight instance to calculate the price needed to generate for a ticket, i.e., the price will be stored in ticket generated） are stored in the Ticket package.
* All GUI-related files are stored in the GUI package.

### Design Pattern
We chose to implement the simple factory design pattern, which is illustrated by the UStore, i.e., our rewards item redemption system. The simple factory design pattern is a creational pattern that deals with the problem of creating objects without having to specify the exact class of the object that will be created, i.e., without exposing the creation logic to the client. It provides loose coupling and high cohesion; it encapsulates object creation logic which makes it easy to change it later when you change how an object gets created. 
In our program, this is done by creating a rewards item object by calling a factory to generate a rewards item based on the inputted item type, and then our system will redeem this item created and add it to the customer's purchase history.

