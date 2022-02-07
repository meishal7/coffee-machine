/** 
* TITLE: EnergyDrink.java 
* AUTHOR: Elena Mudrakova   
* COURSE: CS 112 Intro to CS II - Java  
* MODULE: 1 
* PROJECT: Lab 03_Coffee
* LAST MODIFIED: 08/29/2020
* DESCRIPTION: this program defines the class EnergyDrink that extends CeffeinBev class
*
* ALGORITHM:
* import java.text.NumberFormat;
* import java.util.Objects; 
* declare instance String flavour
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

public class EnergyDrink extends CaffeinBev {
    /**************************** INSTANCE VARS ***************************/
    private String flavour;
    

    /**************************** CONSTRUCTORS ***************************/
    /**
     * No arguments constructor
     */
    public EnergyDrink(){
        super();
    }
    
    /**
     * Four arguments constructor
     */
    public EnergyDrink(String name, int ounce, double price, String flavour ){
        super(name, ounce, price);
        setName(name);
        setOunce(ounce);
        setPrice(price);
        setFlavour(flavour);
    }

    /**************************** GETTERS AND SETTERS ***************************/
    
    /**
     * Sets the flavour
     * @param flavour flavour for set
     */
    public void setFlavour(String flavour){
        this.flavour = flavour;
    }
    /**
     * @return flavour
     */
    public String getFlavour(){
        return flavour;
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
        
        return "Drink: " +
                name + ", " +
                ounce + " ounces, " +
                flavour + ", " +
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
        EnergyDrink enDrink = (EnergyDrink) o;
        return flavour == enDrink.flavour;
    }
    /**
     * Returns hash code value for the obj
     * 
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), flavour);
    }
}