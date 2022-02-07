/** 
* TITLE: DemoCoffee.java 
* AUTHOR: Elena Mudrakova   
* COURSE: CS 112 Intro to CS II - Java  
* MODULE: 1 
* PROJECT: Lab 03_Coffee
* LAST MODIFIED: 08/29/2020
* DESCRIPTION: this program allows user to choose from prompt, enter a drink data and 
* display drink data 
*
* ALGORITHM: 
* declare CaffeinBev[] inventory
* declare Scanner obj
* declare int userChoice=0, ounce, roastType, count = 0, String name, flavour, double price
* declare equals() method
* declare toString() method
* declare hashCode() method
* declare while() loop
*   display user prompt
*   declare switch()
*   switch(userChoice) case 1 => display user prompt for Coffee obj, take input, 
*   create Coffee obj, store it in array 
*   switch(userChoice) case 2 => display user prompt for EnergyDrink obj, take input, 
*   create EnergyDrink obj, store it in array 
* after while() print an array
* 
* PACKAGES INCLUDED
* import java.util.Objects for hashCode()
* import java.util.Scanner for user input
* import java.text.NumberFormat; //fornmatting price
* 
* 
*/   
package L03_Coffee;
import java.util.Scanner;
import java.text.NumberFormat; //fornmatting price


public class DemoCoffee {
    /**
     * Calculates avg price of cards in array
     */
    public static double findAvgPrice(CaffeinBev[] inventory){

        int avgPrice = 0;
        double totalPrice = 0;
        int count = 0;
        for(int i =0; i<inventory.length; i++){
            if(inventory[i] != null){
                count++;
                totalPrice += inventory[i].getPrice();

            }
            
            avgPrice = (int)totalPrice / count;
        }
        // Use a class called NumberFormat
        // to format a number (mPrice) as currency
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        System.out.println("Avg price is " + currency.format(avgPrice));
        return avgPrice;

    }
    
    public static void main(String[] args) {
        /*********************** DECLARATION AND INITIALIZATION **********************/
        CaffeinBev[] inventory = new CaffeinBev[10];
        Scanner sc = new Scanner(System.in);
        // Prompt user with 3 options in a loop
        int userChoice=0, ounce, roastType, count = 0;
        String name, flavour;
        double price;

        while(userChoice != 3){
            //User prompt
            System.out.println("Choose the option below:");
            System.out.println("\n1. Enter new coffee.");
            System.out.println("2. Enter new energy drink.");
            System.out.println("3. Exit");

            //Another prompt and take user input
            userChoice = sc.nextInt();
            switch(userChoice){
                case 1: 
                System.out.print("Enter coffee name: ");
                sc.nextLine();
                name = sc.nextLine();
                System.out.print("Enter coffee ounce(integer): ");
                ounce = sc.nextInt();
                System.out.print("Enter coffee price: ");
                price = sc.nextDouble();
                System.out.print("Enter coffee roast:( 1-light, 2-medium, 3-dark) ");
                roastType = sc.nextInt();
                 // Create a Coffee obj, put into array
                 inventory[count++] = new Coffee(name, ounce, price, roastType);
                break;
                
                case 2: 
                System.out.print("Enter energy drink name: ");
                sc.nextLine();
                name = sc.nextLine();
                System.out.print("Enter energy drink ounce(integer): ");
                ounce = sc.nextInt();
                System.out.print("Enter energy drink price: ");
                price = sc.nextDouble();
                System.out.print("Enter energy drink flavour: ");
                flavour = sc.next();
                //Create EnergyDrink object, put in array
                inventory[count++] = new EnergyDrink(name, ounce, price, flavour);
                break;
            }
        }

        
        //Print an array
        System.out.println("************************* Drinks **********************");
        for(int i=0; i<inventory.length; i++){
            
            if (inventory[i] != null)
            System.out.println(inventory[i]);
        }

        DemoCoffee.findAvgPrice(inventory);
        
    }
}