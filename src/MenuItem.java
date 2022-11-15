import java.awt.*;

//menu item class
public class MenuItem {

    //instance variables for important information
    private boolean largeServing;
    private int eggs;
    private int largeButter;
    private double cost;
    private int cupsOfMilk;
    private int largeMilk;
    private int tbspButter;
    private String name;
    private Color color;
    private boolean setColor = false;
    //default constructor
    MenuItem(){
        name = "unknown";
        this.eggs = 1;
        this.cupsOfMilk = 1;
        this.tbspButter =1;
        cost = 5;
        largeMilk = cupsOfMilk +2;
        largeButter = tbspButter+2;
    }

    //constructor with name param
    MenuItem(String name){
        this.name = name;
        this.eggs = 1;
        this.cupsOfMilk = 1;
        this.tbspButter =1;
        cost = 5;
        largeMilk = cupsOfMilk +2;
        largeButter = tbspButter+2;
    }

    //important constructor with 5 parameters

    MenuItem(String name, int eggs, double cost, int cupsOfMilk, int tbspButter){
        this.name = name;
        this.eggs = eggs;
        this.cost = cost;
        this.cupsOfMilk = cupsOfMilk;
        this.tbspButter = tbspButter;
    }


    //getters and setters
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
        setColor = true;
    }
    public boolean isLargeServing() {
        return largeServing;
    }

    public void setLargeServing(boolean largeServing) {
        this.largeServing = largeServing;
    }

    public int getEggs() {
        return eggs;
    }

    public void setEggs(int eggs) {
        this.eggs = eggs;
    }

    public double getCost() {
        return cost;
    }

    public int getLargeMilk(){
        return cupsOfMilk+2;
    }
    public int getLargeButter(){
        return tbspButter+2;
    }
    public int getLargeEggs(){
        return eggs+2;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getCupsOfMilk() {
        return cupsOfMilk;
    }

    public void setCupsOfMilk(int cupsOfMilk) {
        this.cupsOfMilk = cupsOfMilk;
    }

    public int getTbspButter() {
        return tbspButter;
    }

    public void setTbspButter(int tbspButter) {
        this.tbspButter = tbspButter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public boolean isSetColor() {
        return setColor;
    }

    public void setSetColor(boolean setColor) {
        this.setColor = setColor;
    }
    //html tostring method which didnt end up getting used because i couldnt find a way to get even spacing so i instead used different labels
    public String toString(){

        String htmlString = "<html><span style=\"font-family:Arial;font-size:13px;\">Item: "+name+"&nbsp;&nbsp;&nbsp; Eggs: "+eggs+"/"+eggs+2+" &nbsp;&nbsp;&nbsp;" +
                "&nbsp; Butter: "+tbspButter+"/"+largeButter+" <br> Milk: "+cupsOfMilk+"/"+largeMilk+" &nbsp;&nbsp;&nbsp; Cost: "+cost+"</span></html>";

        return htmlString;
    }



}
