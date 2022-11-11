import java.util.HashMap;

public class Breakfast {

    enum MenuItem{
        EGGS_AND_TOAST,
        PANCAKES,
        FRENCH_TOAST
    }


    //data members
    private String partyName;
    private boolean bigEaters;
    private boolean tradBreakfast;
    private int numOfPeople;

    final static int eggsPerTrad = 2;
    final static int eggsPerPancakes = 1;

    final static HashMap<MenuItem, Double[]> ingredientTable = new HashMap<>();


    //constructors and overloaded constructors
    Breakfast(){
        makeIngredientTable();
        partyName ="None";
        bigEaters = true;
        tradBreakfast = true;
        numOfPeople = 4;


    }
    Breakfast(boolean tradBreakfast, int numOfPeople){
        makeIngredientTable();

        this.tradBreakfast = tradBreakfast;
        this.numOfPeople = numOfPeople;
        partyName = "null";
        bigEaters = true;

    }
    Breakfast(String partyName){
        makeIngredientTable();

        this.partyName = partyName;
        bigEaters = true;
        tradBreakfast = true;
        numOfPeople = 4;
    }

    Breakfast(String partyName, boolean bigEaters, boolean tradBreakfast, int numOfPeople){
        makeIngredientTable();

        this.partyName = partyName;
        this.bigEaters = bigEaters;
        this.tradBreakfast = tradBreakfast;
        this.numOfPeople = numOfPeople;
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

    public boolean isTradBreakfast() {
        return tradBreakfast;
    }

    public void setTradBreakfast(boolean tradBreakfast) {
        this.tradBreakfast = tradBreakfast;
    }

    public int getNumOfPeople() {
        return numOfPeople;
    }

    public void setNumOfPeople(int numOfPeople) {
        this.numOfPeople = numOfPeople;
    }

    //behaviors
    public int calcEggs(){
        if(tradBreakfast) return bigEaters ? (int) (ingredientTable.get(MenuItem.EGGS_AND_TOAST)[2] * numOfPeople): (int) (ingredientTable.get(MenuItem.EGGS_AND_TOAST)[0] * numOfPeople);
        else{
            return bigEaters ? (int) (ingredientTable.get(MenuItem.PANCAKES)[2] * numOfPeople) : (int) (ingredientTable.get(MenuItem.PANCAKES)[0] * numOfPeople);
        }
    }
    public float calcCost(){
        return 0;
    }

    private void makeIngredientTable(){
        ingredientTable.put(MenuItem.EGGS_AND_TOAST, new Double[]{2.0, 4.99, 3.0, 1.5});
        ingredientTable.put(MenuItem.PANCAKES, new Double[]{1.0,6.75,2.0,1.5});
        ingredientTable.put(MenuItem.FRENCH_TOAST, new Double[]{2.0,7.50,3.0,1.5});

    }


    //toString method
    public String toString(){
        return "Party name: "+partyName+" bigEaters: "+bigEaters+" tradBreakfast "+tradBreakfast+" for "+numOfPeople+"people";
    }



}
