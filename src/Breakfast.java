import java.util.HashMap;

public class Breakfast {




    //data members
    private String partyName;
    private boolean bigEaters;

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    private MenuItem menuItem;
    private int numOfPeople;
    private int orderNumber;

    final static int eggsPerTrad = 2;
    final static int eggsPerPancakes = 1;

    final static HashMap<MenuItem, Double[]> ingredientTable = new HashMap<>();


    //constructors and overloaded constructors
    Breakfast(){
        makeIngredientTable();
        partyName ="None";
        bigEaters = true;
        numOfPeople = 4;
        orderNumber = 1;


    }
    Breakfast(boolean tradBreakfast, int numOfPeople){
        makeIngredientTable();

        this.numOfPeople = numOfPeople;
        partyName = "null";
        bigEaters = true;

    }
    Breakfast(String partyName){
        makeIngredientTable();

        this.partyName = partyName;
        bigEaters = true;
        numOfPeople = 4;
        menuItem = new MenuItem("Unknown", bigEaters);
    }

    Breakfast(String partyName, boolean bigEaters, int numOfPeople, int orderNumber, MenuItem menuItem){
        makeIngredientTable();

        this.partyName = partyName;
        this.bigEaters = bigEaters;
        this.numOfPeople = numOfPeople;
        this.orderNumber = orderNumber;
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



    public int getNumOfPeople() {
        return numOfPeople;
    }

    public void setNumOfPeople(int numOfPeople) {
        this.numOfPeople = numOfPeople;
    }

    //behaviors
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

    private void makeIngredientTable(){


    }


    //toString method
    public String toString(){
        String portion = bigEaters ? "large" : "regular";
        String htmlString = "<html><span style=\"font-family:Arial;font-size:13px;\">Reservation :"+partyName+" &nbsp; &nbsp;&nbsp;&nbsp;&nbsp; Guests: " +numOfPeople+
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Portion:"+portion+" <br> Meal: "+menuItem.getName()+" &nbsp;&nbsp;&nbsp;&nbsp; Cost: "+calcCost()+" </html>";
        return htmlString;
    }



}
