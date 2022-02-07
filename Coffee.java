/** 
* TITLE: Coffee.java 
* AUTHOR: Elena Mudrakova   
* COURSE: CS 112 Intro to CS II - Java  
* MODULE: 1 
* PROJECT: Lab 03_Coffee
* LAST MODIFIED: 08/29/2020
* DESCRIPTION: this program defines the class Coffee that extends CeffeinBev class
*
* ALGORITHM:
* import java.text.NumberFormat;
* import java.util.Objects; 
* declare instance String roastType
* declare constructors
* declare setters and getters
* declare equals() method
* declare toString() method
* declare hashCode() method
* 
* PACKAGES INCLUDED
* import java.text.NumberFormat for formatting price
* import java.util.Objects for hashCode()
* 
* 
*/   
package L03_Coffee;
import java.text.NumberFormat;
import java.util.Objects;

public class Coffee extends CaffeinBev{
    /**************************** INSTANCE VARS ***************************/
    private int roastType;
    

    /**************************** CONSTRUCTORS ***************************/
    
    /**
     * No arguments constructor
     */
    public Coffee(){
        super();
    }
    
    /**
     * Four arguments constructor
     */
    public Coffee(String name, int ounce, double price, int roastType){
        super(name, ounce, price);
        setName(name);
        setOunce(ounce);
        setPrice(price);
        setRoast(roastType);
    }

    /**************************** GETTERS AND SETTERS ***************************/
    
    /**
     * Sets the roast type
     * @param roastType roastType for set, has to be the integer 1, 2 or 3
     */
    public void setRoast(int roastType){
        if(roastType != 1 && roastType != 2 && roastType != 3 ){
            System.out.println("Error. Invalid roast type. Roast type has to be 1, 2 or 3");
            System.exit(99);
        }
        this.roastType = roastType;
    }
    /**
     * @return roastType
     */
    public int getRoast(){
        return roastType;
    }
    
    /************************************ EQUALS() toSTRING() hashCODE() **************************************/
    /**
     * Prints out the object data
     */
    public String toString()
    {
        // Use a class called NumberFormat
        // to format a number (mPrice) as currency
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        
        //Make a decision about roast type
        String roast = "";
        switch (roastType)
        {
            case 1: // light roast
                roast = "light roast";
                break;
            case 2: // medium roast
                roast = "medium roast";
                break;
            case 3: // dark roast
                roast = "dark roast";
                break;

        }

        return "Coffee: " +
                name + ", " +
                ounce + " ounces, " +
                roast + ", " +
                currency.format(price);  // Prints as $2.50
        
    }
    /**
     * Tests for equality of two objects. To be equal
     * objects must have the same name, ounce, price, roastType
     * @return returns true if the objects are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Coffee coffee = (Coffee) o;
        return roastType == coffee.roastType;
    }
    /**
     * Returns hash code value for the obj
     * 
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), roastType);
    }
}