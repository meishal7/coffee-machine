/** 
* TITLE: CaffeinBev.java 
* AUTHOR: Elena Mudrakova   
* COURSE: CS 112 Intro to CS II - Java  
* MODULE: 1 
* PROJECT: Lab 03_Coffee
* LAST MODIFIED: 08/29/2020
* DESCRIPTION: this program defines the class CoffeinBev 
*
* ALGORITHM: 
* declare instance vars name, ounce, price
* declare setters and getters for vars
* declare equals() method
* declare toString() method
* declare hashCode() method
* 
* PACKAGES INCLUDED
* import java.util.Objects for hashCode()
* 
* 
*/   
package L03_Coffee;
import java.util.Objects;
import java.lang.*;

public abstract class CaffeinBev {
    
    /**************************** INSTANCE VARS ***************************/
    protected String name;
    protected int ounce;
    protected double price;
    

    /**************************** CONSTRUCTORS ***************************/
    
    /**
     * No arguments constructor
     */
    public CaffeinBev(){ }
     /**
     * Three arguments constructor, name, level
     */
    public CaffeinBev(String name, int ounce, double price){
        setName(name);
        setOunce(ounce);
        setPrice(price);
    }

    /**************************** GETTERS AND SETTERS ***************************/
    
    /**
     * Sets the name
     * @param name name for set
     */
    public void setName(String name){
        this.name = name;
    }
    /**
     * 
     * @return name
     */
    public String getName(){
        return name;
    }
    /**
     * Sets the ounces
     * @param ounce ounce for set, has to be the integer, min = 1 
     */
    public void setOunce(int ounce){
        if(ounce < 1 ){
            System.out.println("Error. Invalid ounce. Ounce should be minimum 1");
            System.exit(99);
        }
        this.ounce = ounce;
    }
    /**
     * @return ounce
     */
    public int getOunce(){
        return ounce;
    }
    
    /**
     * Sets price
     * @param price price for set, double, min = 1.00
     */
    public void setPrice(double price){
        if(price < 1.00 ){
            System.out.println("Error. Invalid price. Price should be minimum 1.00");
            System.exit(99);
        }
        this.price = price;
    }
    /**
     * @return price
     */
    public double getPrice(){
        return price;
    }
    
    /************************************ EQUALS() **************************************/
    /**
     * Prints out the object data
     */
    public String toString()
    {
        return ("Drink: " + name + ", " + ounce + " ounce, " + "$"+ price);
    }
    /**
     * Tests for equality of two objects. To be equal
     * objects must have the same name, ounce, price
     * @return returns true if the objects are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CaffeinBev that = (CaffeinBev) o;
        return ounce == that.ounce &&
                Double.compare(that.price, price) == 0 &&
                name.equals(that.name);
    }

    /**
     * Returns hash code value for the obj
     * 
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, ounce, price);
    }
    
}