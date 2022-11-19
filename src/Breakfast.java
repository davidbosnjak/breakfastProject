import java.awt.*;
import java.util.HashMap;

public class Breakfast {



    //instance variables
    private String partyName;
    private boolean bigEaters;



    private MenuItem menuItem;
    private int numOfPeople;




    //constructors and overloaded constructors
    Breakfast(){
        partyName ="None";
        bigEaters = true;
        numOfPeople = 4;


    }
    Breakfast(boolean tradBreakfast, int numOfPeople){


        this.numOfPeople = numOfPeople;
        partyName = "null";
        bigEaters = true;

    }
    Breakfast(String partyName){


        this.partyName = partyName;
        bigEaters = true;
        numOfPeople = 4;
        menuItem = new MenuItem("Unknown");
    }

    //important constructor with all parameters
    Breakfast(String partyName, boolean bigEaters, int numOfPeople, MenuItem menuItem){

        this.partyName = partyName;
        this.bigEaters = bigEaters;
        this.numOfPeople = numOfPeople;
        this.menuItem = menuItem;
    }

    //getters and setters
    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public boolean isBigEaters() {
        return bigEaters;
    }

    public void setBigEaters(boolean tradBreakfast) {
        this.bigEaters = bigEaters;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
        setColor = true;
    }

    private Color color;

    public boolean isSetColor() {
        return setColor;
    }

    public void setSetColor(boolean setColor) {
        this.setColor = setColor;
    }

    private boolean setColor = false;

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    public int getNumOfPeople() {
        return numOfPeople;
    }

    public void setNumOfPeople(int numOfPeople) {
        this.numOfPeople = numOfPeople;
    }

    //calculate stuff based on whether it's a large portion and the amount of people. (i really like the ternary operator)
    public int calcEggs(){
        return bigEaters ? (menuItem.getEggs()+2)*numOfPeople : menuItem.getEggs() * numOfPeople;
    }
    public int calcButter(){
        return bigEaters ? (menuItem.getTbspButter()+2)*numOfPeople : menuItem.getTbspButter() * numOfPeople;
    }
    public int calcMilk(){
        return bigEaters ? (menuItem.getCupsOfMilk()+2)*numOfPeople : menuItem.getCupsOfMilk() * numOfPeople;
    }
    public float calcCost(){
        return (float) (bigEaters ? menuItem.getCost()*1.5*numOfPeople : menuItem.getCost()*numOfPeople);
    }




    public String toString(){


        return partyName+" "+bigEaters+" "+numOfPeople+" "+menuItem.getName()+" "+menuItem.getEggs()+" "+menuItem.getCost()+" "+menuItem.getCupsOfMilk()+" "+menuItem.getTbspButter()+"\n";
    }



}
