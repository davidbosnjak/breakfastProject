public class Breakfast {



    //data members
    private String partyName;
    private boolean bigEaters;
    private boolean tradBreakfast;
    private int numOfPeople;

    //constructors and overloaded constructors
    Breakfast(){
        partyName ="None";
        bigEaters = false;
        tradBreakfast = false;
        numOfPeople = 0;
    }

    Breakfast(String partyName, boolean bigEaters, boolean tradBreakfast, int numOfPeople){
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

    public void setBigEaters(boolean bigEaters) {
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
    public void calcEggs(){

    }
    public void calcCost(){

    }

    //toString method
    public String toString(){
        return "Partyname: "+partyName+" bigEaters: "+bigEaters+" tradBreakfast "+tradBreakfast;
    }



}
