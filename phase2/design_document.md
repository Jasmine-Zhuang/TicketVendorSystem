# Design Document

## SOLID Principles 

### Single Responsibility 
We ensured that all classes have single responsibility by keeping the responsibility of each class to the minimum,  so that a class will only have one reason to change, and we could test the entire class more thoroughly, which also allowed us to focus on parts that need to be addressed more.
### Open for extension and closed for modification: 
Differ from previous phases, we now added some new features to flight(i.e., restrict the number of available seats and assign seat type for each seat). We chose not to modify the original flight, but use inheritance by adding 3 subclasses of flight. Then, we need to modify only the 3 subclasses of flight, to reach our goal of extending features of flight. 
### Liskov substitution 
The principle defines that objects of a superclass shall be replaceable with objects of its subclasses without breaking the application. 
All subclasses do not override methods from the parent class such that the objects of your subclasses behave in the same way as the objects of your superclass. Therefore, this principle is not violated.
 
### Interface Segregation principle:    
We have two interfaces in our program. The Redeemable interface is part of the simple factory design pattern. This interface only has a method named redeemItem which redeems a rewards item and returns it. Also, all classes implementing this interface are rewards items, so they are related and share the feature of being able to be redeemed.  The Meal_selection interface is also part of the simple factory design pattern. It only has one method called chosemeal, which is used to select a meal option and returns it. Meanwhile, all the classes which implement this interface are meal options, therefore, all the meal options can share the feature of being selected.
 
### Dependency Inversion 
Currently, we have not had a chance to adopt this aspect into our project, thus no designs have been implemented to violate this principle.
 
## Clean Architecture
In our program, the dependency rule is followed, i.e. dependencies only point inward, and the inner layers are designed not to have any knowledge of the outer layers, because all entity classes are only monitored by their corresponding use case classes, and the controller  class manipulates our GUI and manager classes (which are our use case classes). 
We will demonstrate this by showing the CRC and scenario walkthrough.

## Design Pattern 
 
In phase1, we chose to implement the simple factory design pattern, which is illustrated by the UStore, i.e., our rewards item redemption system. The simple factory design pattern is a creational pattern that deals with the problem of creating objects without having to specify the exact class of the object that will be created, i.e., without exposing the creation logic to the client. It provides loose coupling and high cohesion; it encapsulates object creation logic which makes it easy to change later. 
In our program, this is done by creating a rewards item object by calling a factory to generate a rewards item based on the inputted item type, and then our system will redeem this item created by calling its redeemItem method, and add it to the customer's purchase history.
https://github.com/CSC207-UofT/course-project-happy207/pull/18

In phase2, we chose to implement the simple factory design pattern, which is illustrated by the Meal selection system. The simple factory design pattern is a creational pattern that deals with the problem of creating objects without having to specify the exact class of the object that will be created, i.e., without exposing the creation logic to the client. It provides loose coupling and high cohesion; it encapsulates object creation logic which makes it easy to change later. 
In our program, this is done by creating a Meal_choice item object by calling a Meal_choiceFactory to generate a meal_choice item based on the inputted meal type, and our meal selection system will assign the newly created meal by calling its “choosemeal”  method, and assign it to the ticket’s instance “meal”.
https://github.com/CSC207-UofT/course-project-happy207/pull/33


## Use of GitHub Features

We opened issues to discuss some specific problems. More detailed discussions were held in other ways because we found this more efficient.
We tried the actions function but failed to implement it because we were not able to solve the error on GitHub, even after consulting the TA :(.
We have at least one pull request for each person in each phase that indicates what we have done individually. For example, we have pull requests for each entity class and each manager class, in this way we are able to compare our code more easily and know the responsibility for each member.



## Code Style and Documentation

We have documented each method with parameters needed and return value description.(javadoc used)
We have applied coding conventions, such as file organization, comments(make code easier to understand), naming conventions(mostly CamelCase), etc. Since each member is in charge of different components and some require to use code from others, using these coding conventions make it easier to understand others' code and apply it in one’s own part.
We have opened pull requests for each branch and reviewed the commits of others, such that we can understand other members’ implementation, before we met on a weekly basis. By doing this, we save time explaining each member’s code during meetings.

## Testing

All of our files have a test coverage of 80% or more. Due to serialization and deserialization,  it is hard to test if each of our objects is really serializable.
Since serialization allows us to convert the state of an object into a byte stream, which then can be saved into a file on the local disk or sent over the network to And deserialization allows us to reverse the process, which means reconverting the serialized byte stream to an object again.
Since our serialization and deserialization are both called from the GUI. So we need to manually add a new user profile before this program can save it. This is hard to test.
We have 124 tests in total. We divide the test files into 6 big folders. For example, all classes related to Customer are grouped into Customer files, such as Customer, CustomerManager, Membership, PH Manager,PurchaseHistory Each class has a corresponding test file.
We will present our test coverage to the TA through a presentation.

## Refactoring

In flight, we have refactored the code in its constructor to 3 helper methods called buildSeatArray, CreateClassSeat and buildTime, these are shown in the pull request: ```Flight #35```.
- buildSeatArray: Input total number of seats and an arraylist of seat number, and return  an arraylist of array list of seat number and seat type (Based on the total seat number, we can know which kind of flights that is going to be constructed and thus we have this nested arraylist built, since we have predefined how each type of flight’s seat array will be like). Notice this method called the helper method CreateClassSeat that is stated below.

- CreateClassSeat: Create and add seats with type C into an array list of arraylist of seat number and seat type, with inputs of  seatArray(an array list of arraylist of seat number and seat type), seatNumArray(array of seat number), total number of seats wanted to be made and added to seatArray, and the start index, is the index of the seat number for the first seat created in seatNumArray.

- buildTime: Build a LocalDateTime instance using Year,Month,Day,Hour and Minute stored in the arraylist inputted.


With these 3 helper methods that are refactored from the original constructor of flight, we are able to simply call this in the constructor to construct a flight instance with the desired attribute built up using these helpers. By doing this, we manage to improve code readability and reduce complexity.


In addition, in flightManager, we have done some refactoring for the **addFlight** method, which is also shown in the pull request: ```Flight #35```.


Using switch and case statements, we can call one of the 3 flight-subclasses’s constructors based on input flight type. Since we have predefined the seat capacity and seat array for each type of flight, by adding a static variable seatArray, in each of the subclass of flight, for example, we have a static variable named smallSeatNumArray in smallFlight, and then put this in the constructor of smallFlight.


That is to say, another significant improvement of the above refactorings described would be the reduced number of parameters needed to be inputted in these methods.


Besides, We did some general refactoring that changed the name of some ambiguous variables to make our code more readable.  We also fixed some crucial typos in our code that may change the literal meaning of the function or variable names. The evidence is in pull request PP2_login.


For the code smell, the class Customer may be too large, which can be devided into smaller classes. Meanwhile, we have too much parameter for method generateTicket, which may causes data clumps.
 
## Code Organization

We used the strategy of package-by-component to organize the code, that is, we managed to place all items that are closely related to a component into the same package. The reason we decided to use this strategy is because once we have an idea of what the desired file is roughly about, we can easily find it. For instance, if we wished to access the file that is related to ticket sales, it is natural to navigate to the folder Ticket, and the file TicketManager is indeed in charge of ticket sales.
- Flight and its 3 subclasses, and FlightManager are stored in the Flight package.

- RewardsItem, Redeemable, RewardsItemFactory and all subclasses of RewardsItem are stored in the UStore package.

- Customer, CustomerManager, Membership, LoginSystem, PurchaseHistory and PHManager are stored in the Customer package.

- Ticket, TicketManager, and PriceCalculator（it uses a flight instance to calculate the price needed to generate for a ticket, i.e., the price will be stored in ticket generated） are stored in the Ticket package.

- All GUI-related files are stored in the GUI package.


## Functionality

Our program satisfies all the functions listed in our specification, including but not limited to booking tickets, refund/change tickets, booking flight meals and earning rewards based on customer’s membership and mileage. Our functions have been met to allow passengers to achieve basic operations related to air tickets, and if the operations are appropriate, they can already be profitable. If possible, we can cooperate with airline companies(such as Air Canada) and payment companies(paypal) to make our project realize the operation of real ticket booking.

Also, we have serialization and deserialization functions in our design. When we perform an operation, we can save the operator's status by updating their status (including but not limited to purchase records, login information, etc.).When users log out, their status will be saved. When they log in again, they can see their saved information and operations, etc.

When the user runs the controller, the 5 managers(flightManager, ticketManager, LuggageManager, CustomerManager, PHManager) will be first deserialized with .ser files saved before, and then these managers with status restored will be inputted into GUI. In GUI, for each operation that results in a state change of managers, we will add a corresponding method to save its current state, and store it in the .ser file. By doing this, when the user restarts the program, the previous state will be restored.


## Pogress Report

- Jasmine Zhuang:
I participated in the implementation of cancel ticket and change ticket features(with methods added in TicketManager and features shown in GUI purchase history ticket frames). Also, I have predefined each type of flight’s seat array and capacity. In flightManager, I have updated the addFlight method such that by inputting flight type we can construct a flight instance of that type, and add a method that returns a formatted flight information string which can be used in GUI . For GUI, I have modified some frames related to flight pick such that it is more good-looking with larger font. ```https://github.com/CSC207-UofT/course-project-happy207/pull/35 ```, 
```https://github.com/CSC207-UofT/course-project-happy207/pull/42``` (this main1 branch contains all commits from code with me, such that it also contains my team members’ changes that have been specified in the commit message.)


- Yefan Jiang: 
I joined Jasmine to work on implementing ticket cancellation and modification features. This feature not only involves modifying tickets, but also returning paid balance to customer’s account and removing any cancelled items from the system. I also participated in creating corresponding GUI frames so that users could access this feature. Moreover, I revised TicketManager, PurchaseHistory and PHManager classes to better serve the current version of our program, and modified the tests for these classes. Lastly, I helped touch up the appearance of the GUI to improve readability.
Below are the links to two of my most significant contribution to the project. They include commits of creating and revising the classes TicketManager, PurchaseHistory, and PHManager, and their tests. They are the three major classes that I was in charge of. 
```https://github.com/CSC207-UofT/course-project-happy207/pull/7```, 
```https://github.com/CSC207-UofT/course-project-happy207/pull/32```

- Ryan Fang: 
I continued to work on storing our users and let our program read the stored data. I combined csv edit and serialization during a user’s login and creating account process so that we could both serialize the user’s data and view the data in a csv file. I also fixed some bugs left from phase 1 and optimized some of  our GUI presentation. Below are the links that show part of what I have done. This demonstrates a significant contribution because the login process is the start of our program usage, so it must be implemented well for users’ and our convenience.
```https://github.com/CSC207-UofT/course-project-happy207/pull/11```, ```https://github.com/CSC207-UofT/course-project-happy207/pull/25```

- Chuan Liu: 
Yunya and I worked on a new feature luggage in this project for PP2. To be specific, I’m responsible for creating the GUI for your luggage. When people choose to add luggage to their air ticket, the gui will call the manager to create a new luggage and link the ticket id to the booked ticket. Also, the serialization will save the state for the luggage and the ticket, and the customer can check their luggage status when they go back to their ticket history. If the customer’s luggage is overweight, the system will let the customer know the penalty will be deducted from the customer’s balance. If the customer inputs an invalid weight, or a string, the system will warn him and let him/her retry again. Also, I continue to implement the PriceCalculator to calculate the penalty of overweight luggage and returning tickets.
```https://github.com/CSC207-UofT/course-project-happy207/pull/21```

- Qiaoru Zhang: 
PP2 I was responsible for creating the Meal_choice class (and the associated four metal options of diabetic, low_calories, vegan and gluten_intolerance), the Meal_choiceFactory class, and the Meal_selection interface. I was also responsible for implementing all their related test methods and achieving over 80% test coverage. I also added the instances of meal to the ticket class, and I added methods to the ticket manager that can be called at the use case level, and I wrote test methods for all the methods I added. I also changed methods for customer, customer manager, and membership classes and wrote test methods for all changes.
For GUI frames, I was responsible for adding all GUI frames related to select meals and improving the purchase history page about tickets.
```https://github.com/CSC207-UofT/course-project-happy207/pull/33```

- Yunya Li: 
In phase 2, I was in charge of creating a new entity class Luggage as well as Luggage manager which interacts with the Luggage class (Including tests). I created serialization and deserialization methods to save changes to the Luggage manager. I also took part in designing the GUI luggage frame with Liu Chuan.
I updated the way to store the seat number array in flight so that we can have a cancel seat function. All related methods and tests are up to date.
Jasmine and I updated the add flight method in flight manager, we simplified the input of the method from needing seat number, available seat, and seat array, to a simple input of light type. 
In the controller, I initialized 30 flights between 4 cities “Vancouver, Toronto, Ottawa, Montreal”.
```https://github.com/CSC207-UofT/course-project-happy207/pull/34```
