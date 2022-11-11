/**
 * @author Your Name goes here.....
 *
 * File: ClientRequest.java
 * Date: Sept 17, 20xx
 *
 * Purpose: This is the interface which allows us to test the Breakfast class,
 * a class that records the breakfast order for a table in a very small cafe.
 *
 */
public class ClientRequest {
    public static void main(String args[]) {

        UserInterface.startInterface();
        // Instantiate the different clients (orders)
        Breakfast client1 = new Breakfast();
        Breakfast client2 = new Breakfast("Smith");
        // below: traditional breakfast? with no of people
        Breakfast client3 = new Breakfast(false, 8);
        Breakfast client4 = new Breakfast("Jones", false, true, 10);
        // Print the orders
        System.out.println(client1);
        System.out.println(client2);
        System.out.println(client3);
        System.out.println(client4);
        // Change some of the data in the orders
        System.out.println();
        System.out.println("Updating Client Names");
        client1.setPartyName("deRossa");
        client1.setNumOfPeople(5);
        client3.setPartyName("Brooks");
        // View the changes
        System.out.println();
        System.out.println(client1);
        System.out.println(client2);
        System.out.println(client3);
        System.out.println(client4);
        System.out.println();
        // Using getters and showing some other features of the class
        System.out.println(client2.getNumOfPeople() + " is the number of people in the reservation for " + client2.getPartyName());

        System.out.println("The amount of eggs required for the " + client3.getPartyName() + " party is " + client3.calcEggs());

        System.out.println("The total cost of " + client3.getPartyName() + " breakfast is " + client3.calcCost() + " excluding tax and tip");
        client3.setBigEaters(false);
        System.out.println("If the party wanted a regular portion the amount of eggs required is " + client3.calcEggs());

        System.out.println("The total cost of " + client3.getPartyName() + " breakfast is " + client3.calcCost() + " excluding tax and tip");

        System.out.println();
        System.out.println("The total cost of " + client4.getPartyName() + " breakfast is " + client4.calcCost() + " excluding tax and tip");
        client4.setBigEaters(true);
        System.out.println("The total cost of " + client4.getPartyName() + " breakfast is " + client4.calcCost() + " excluding tax and tip");
    }
}